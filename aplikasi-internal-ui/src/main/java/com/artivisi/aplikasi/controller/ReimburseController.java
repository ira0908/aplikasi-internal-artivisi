/**
 * 
 */
package com.artivisi.aplikasi.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artivisi.aplikasi.internal.MasterPegawaiService;
import com.artivisi.aplikasi.internal.MasterTypeReimburseService;
import com.artivisi.aplikasi.internal.MasterUserService;
import com.artivisi.aplikasi.internal.PencairanReimburseService;
import com.artivisi.aplikasi.internal.ReimburseService;
import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.MasterTypeReimburse;
import com.artivisi.aplikasi.internal.entity.MasterUser;
import com.artivisi.aplikasi.internal.entity.PencairanReimburse;
import com.artivisi.aplikasi.internal.entity.Reimburse;
import com.artivisi.aplikasi.internal.entity.ReimburseDokter;

/**
 * @author ira
 *
 */
@Controller
public class ReimburseController {

	@Autowired
	private ReimburseService reimburseService;
	
	@Autowired
	private MasterUserService userService;
	
	@Autowired
	private MasterTypeReimburseService typeReimburseService;
	
	@Autowired
	private MasterPegawaiService pegawaiService;
	
	@Autowired
	private PencairanReimburseService pencairanReimburseService;
	
	private String tanggal="yyyy-MM-dd";
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(tanggal), true));
		binder.registerCustomEditor(MasterTypeReimburse.class, new TypeReimburseEditor(typeReimburseService));
		binder.registerCustomEditor(MasterPegawai.class, new PegawaiEditor(pegawaiService));
		binder.registerCustomEditor(Reimburse.class, new ReimburseEditor(reimburseService));
	}
	
	public List<MasterTypeReimburse> typeReimburse() throws Exception{
		return typeReimburseService.findAllType();
	}
	
	public List<Reimburse> reimburse() throws Exception{
		return reimburseService.findAll();
	}
	
	public List<MasterPegawai> masterPegawai() throws Exception{
		return pegawaiService.semuaPegawai();
	}
	
	@RequestMapping(value="/transaksi/formReimburse", method=RequestMethod.GET)
	public ModelMap displayFrom(){
		ModelMap mm = new ModelMap();
		mm.addAttribute("type", typeReimburseService.findAllType());
		mm.addAttribute("daftarPegawai", pegawaiService.semuaPegawai());
		return mm;
	}
	
	@RequestMapping(value="/transaksi/formReimburse", method=RequestMethod.POST)
	public String saveReimburse(@ModelAttribute Reimburse reimburse){
		reimburse.setApp("No");
		reimburse.setDiBayar(BigDecimal.ZERO);
		reimburseService.saveReimburse(reimburse);
		return "redirect:formReimburse";
	}
	
	@RequestMapping("/transaksi/daftarReimburse")
	public ModelMap daftarReimburse(){
		ModelMap mm= new ModelMap();
		mm.addAttribute("data",reimburseService.findAllNoApp());
		return mm;
	}
	
	@RequestMapping("/transaksi/approveReimburse")
	public String approveReimburse(@RequestParam Long id){
		Reimburse reimburse = reimburseService.findById(id);
		reimburse.setApp("Approved");
		reimburseService.saveReimburse(reimburse);
		return "redirect:daftarReimburse";
	}
	
	@RequestMapping("/transaksi/cancelReimburse")
	public String cancelReimburse(@RequestParam Long id){
		Reimburse reimburse=reimburseService.findById(id);
		reimburse.setApp("Cancel");
		reimburseService.saveReimburse(reimburse);
		return "redirect:daftarReimburse";
	}
	
	//pencairan reimburse
	
	@RequestMapping("/transaksi/listPembayaran")
	public ModelMap listPembayaran(@RequestParam Long id){
		ModelMap mm = new ModelMap();
		Reimburse reimburse=reimburseService.findById(id);
		mm.addAttribute("header", reimburse);
		mm.addAttribute("data", pencairanReimburseService.findPencairanByPengajuan(reimburse));
		mm.addAttribute("sisa", reimburseService.findById(id).getNilai().subtract(reimburseService.findById(id).getDiBayar()));
		return mm;
	}
	
	@RequestMapping(value="/transaksi/formPencairan", method=RequestMethod.GET)
	public ModelMap displayFormPencairan(@RequestParam Long id){
		ModelMap mm= new ModelMap();
		mm.addAttribute("idReimburse", reimburseService.findById(id));
		return mm;
	}
	
	@RequestMapping(value="/transaksi/cair")
	public String saveCair(@ModelAttribute PencairanReimburse cair){
		pencairanReimburseService.savePencairan(cair);
		Reimburse reimburse=reimburseService.findById(cair.getReimburse().getId());
		reimburse.setDiBayar(reimburse.getDiBayar().add(cair.getNilai()));
		reimburseService.saveReimburse(reimburse);
		return "redirect:daftarReimburse";
	}
	
	
	//laporan
	
	@RequestMapping("/laporan/laporanReimburse")
	public ModelMap laporanReimburse(){
		MasterUser mu=userService.findByUsername(SecurityHelper.getCurrentUsername());
		if (!mu.getMasterGroup().getNamaGroup().equals("ADMINISTRATOR")){
			ModelMap mm= new ModelMap();
			mm.addAttribute("daftarPegawai", pegawaiService.findByUser(mu.getMasterPegawai().getId()));
			return mm;	
		}else{
			ModelMap mm= new ModelMap();
			mm.addAttribute("daftarPegawai", pegawaiService.semuaPegawai());
			return mm;
		}
	}
	
	@RequestMapping("/laporan/viewLapReimburse")
	public ModelMap viewLaporanReimburse(@RequestParam MasterPegawai masterPegawai, Date mulai, Date sampai){
		ModelMap mm=new ModelMap();
		mm.addAttribute("data", reimburseService.findByPegawai(masterPegawai, mulai, sampai));
		mm.addAttribute("header", pegawaiService.findById(masterPegawai.getId()));
		mm.addAttribute("mulai", new SimpleDateFormat("yyyy-MM-dd").format(mulai));
		mm.addAttribute("sampai", new SimpleDateFormat("yyyy-MM-dd").format(sampai));
		return mm;
	}
	
}
