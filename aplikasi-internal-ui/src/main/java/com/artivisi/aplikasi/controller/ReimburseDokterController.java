/**
 * 
 */
package com.artivisi.aplikasi.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.artivisi.aplikasi.internal.MasterGroupService;
import com.artivisi.aplikasi.internal.MasterPegawaiService;
import com.artivisi.aplikasi.internal.MasterPlafonService;
import com.artivisi.aplikasi.internal.MasterUserService;
import com.artivisi.aplikasi.internal.PencairanReimburseDokterService;
import com.artivisi.aplikasi.internal.ReimburseDokterService;
import com.artivisi.aplikasi.internal.entity.MasterGroup;
import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.MasterPlafon;
import com.artivisi.aplikasi.internal.entity.MasterUser;
import com.artivisi.aplikasi.internal.entity.PencairanReimburseDokter;
import com.artivisi.aplikasi.internal.entity.ReimburseDokter;

/**
 * @author ira
 *
 */
@Controller
public class ReimburseDokterController {
	
	private final Log LOGGER = LogFactory.getLog(ReimburseDokterController.class);

	@Autowired
	private ReimburseDokterService reimburseDokterService;
	
	@Autowired
	private MasterPegawaiService pegawaiService;
	
	@Autowired
	private MasterUserService userService;
	
	@Autowired
	private MasterGroupService groupService;
	
	@Autowired
	private MasterPlafonService plafonService;
	
	@Autowired
	private PencairanReimburseDokterService cairService;
	
	private String tanggal="yyyy-MM-dd";
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(tanggal), true));
		binder.registerCustomEditor(MasterPegawai.class, new PegawaiEditor(pegawaiService));
		binder.registerCustomEditor(ReimburseDokter.class, new ReimburseDokterEditor(reimburseDokterService));
	}
	
	public List<MasterPegawai> pegawai() throws Exception{
		return pegawaiService.semuaPegawai();
	}
	
	public List<ReimburseDokter> findAll() throws Exception{
		return reimburseDokterService.findAll();
	}
	
	@RequestMapping(value="/transaksi/formReimburseDokter", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam (value="id", required=false)Long id){
		/*MasterPlafon mp=plafonService.findById(id);
		MasterPegawai peg=pegawaiService.findById(mp.getMasterPegawai().getId());
		ModelMap mm= new ModelMap();
		mm.addAttribute("daftarPegawai", peg);
		mm.addAttribute("sisa", mp.getPlafon().subtract(mp.getTerpakai()));
		return mm;*/
		
		MasterUser mu = userService.findByUsername(SecurityHelper.getCurrentUsername());
		if (mu.getMasterGroup().getNamaGroup().equals("USER")){
			ModelMap mm = new ModelMap();
			mm.addAttribute("data", reimburseDokterService.findById(id));
			mm.addAttribute("daftarPegawai",pegawaiService.findByUser(mu.getMasterPegawai().getId()));
			return mm;
		}else{
			ModelMap mm = new ModelMap();
			mm.addAttribute("data", reimburseDokterService.findById(id));
			mm.addAttribute("daftarPegawai",pegawaiService.semuaPegawai());
			return mm;
		}
	}
	
	@RequestMapping(value="/transaksi/formReimburseDokter", method=RequestMethod.POST)
	public String saveReimburse(@ModelAttribute ReimburseDokter reimburse){
		reimburse.setApprove("No");
		reimburse.setDiBayar(BigDecimal.ZERO);
		reimburseDokterService.saveReimburse(reimburse);
		return "redirect:/app/laporan/lapReimburseDokter";
	}
	
	
	@RequestMapping(value="/laporan/lapReimburseDokter")
	public ModelMap lapReimburseDokters(){
		MasterUser mu = userService.findByUsername(SecurityHelper.getCurrentUsername());
		if (!mu.getMasterGroup().getNamaGroup().equals("ADMINISTRATOR")){
			ModelMap mm =new ModelMap();
			mm.addAttribute("data", reimburseDokterService.findAllByPegawai(mu.getMasterPegawai()));
			return mm;
		}
		ModelMap mm =new ModelMap();
		mm.addAttribute("data", reimburseDokterService.findAll());
		return mm;
	}
	
	@RequestMapping(value="/transaksi/listReimburse", method=RequestMethod.GET)
	public ModelMap listReimburse(){
		MasterUser mu = userService.findByUsername(SecurityHelper.getCurrentUsername());
		if (mu.getMasterGroup().getNamaGroup().equals("USER")){
			ModelMap mm =new ModelMap();
			mm.addAttribute("data", pegawaiService.findByUser(mu.getMasterPegawai().getId()));
			return mm;
		}
		ModelMap mm =new ModelMap();
		mm.addAttribute("data", pegawaiService.semuaPegawai());
		return mm;
	}
	
	@RequestMapping(value="/transaksi/listReimburseDokter", method=RequestMethod.POST)
	public ModelMap listReimburse2(@RequestParam MasterPegawai masterPegawai, Date tanggal){
		ModelMap mm = new ModelMap();
		List<ReimburseDokter> datas = reimburseDokterService.findAllByPegawaiApp(masterPegawai, tanggal);
		mm.addAttribute("data",datas);
		LOGGER.info("Size data reimburse : " + datas);
		mm.addAttribute("header", plafonService.findByTahunDanPeg(masterPegawai, tanggal));
		return mm;
	}
	
	@RequestMapping(value="/transaksi/appReimburse")
	public ModelMap approve(){
			ModelMap mm = new ModelMap();
			mm.addAttribute("data", reimburseDokterService.findAllNoApp());
			return mm;
	}
	
	@RequestMapping("/transaksi/app")
	public String approveReimburse(@RequestParam Long id){
		ReimburseDokter rd=reimburseDokterService.findById(id);
		rd.setApprove("Approved");
		reimburseDokterService.saveReimburse(rd);
		return "redirect:appReimburse";
	}
	
	@RequestMapping("/transaksi/cancel")
	public String cancelReimburse(@RequestParam Long id){
		ReimburseDokter rd=reimburseDokterService.findById(id);
		MasterPlafon mp=plafonService.findByTahunDanPeg(rd.getMasterPegawai(), rd.getTanggal());
		rd.setApprove("Cancel");
		reimburseDokterService.saveReimburse(rd);
		mp.setTerpakai(mp.getTerpakai().subtract(rd.getNilai()));
		plafonService.savePlafon(mp);
		return "redirect:appReimburse";
	}
	
	
	//pencairan reimburse dokter
	
	@RequestMapping(value="/transaksi/lihatPembayaran", method=RequestMethod.GET)
	public ModelMap daftarPencairanBerdasarkanPengajuan(@RequestParam Long id){
		ReimburseDokter rd = reimburseDokterService.findById(id);
		ModelMap mm = new ModelMap();
		mm.addAttribute("header", rd);
		mm.addAttribute("data", cairService.findByPengajuan(rd));
		mm.addAttribute("sisa", rd.getNilai().subtract(rd.getDiBayar()));
		return mm;
	}
	
	@RequestMapping(value="/transaksi/formBayar", method=RequestMethod.GET)
	public ModelMap entryPembayaran(@RequestParam Long id){
		ReimburseDokter rd = reimburseDokterService.findById(id);
		ModelMap mm = new ModelMap();
		mm.addAttribute("data", rd);
		return mm;
	}
	
	@RequestMapping(value="/transaksi/bayar", method=RequestMethod.POST)
	public String savePembayaran(@ModelAttribute PencairanReimburseDokter cair){
		cairService.savePencairan(cair);
		ReimburseDokter rd = reimburseDokterService.findById(cair.getReimburseDokter().getId());
		rd.setDiBayar(rd.getDiBayar().add(cair.getNilai()));
		reimburseDokterService.saveReimburse(rd);
		MasterPlafon mp=plafonService.findByTahunDanPeg(rd.getMasterPegawai(), rd.getTanggal());
		mp.setTerpakai(mp.getTerpakai().add(cair.getNilai()));
		plafonService.savePlafon(mp);
		return "redirect:appReimburse";
	}
}
