package com.artivisi.aplikasi.controller;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artivisi.aplikasi.internal.MasterPegawaiService;
import com.artivisi.aplikasi.internal.SaldoKasbonService;
import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.SaldoKasbon;

@Controller
@RequestMapping("/master")
public class MasterPegawaiController {

	@Autowired
	private MasterPegawaiService appService;
	
	@Autowired
	private SaldoKasbonService saldoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(MasterPegawai.class, new PegawaiEditor(appService));
	}
	
	public List<MasterPegawai> pegawai() throws Exception{
		return appService.semuaPegawai();
	}
	
	@RequestMapping(value="/listMasterPegawai", method=RequestMethod.GET)
	public ModelMap listPegawai(){
		return new ModelMap().addAttribute("daftarPegawai", appService.semuaPegawai());
	}
	
	@RequestMapping(value="/formMasterPegawai", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam(value="id", required=false) Long id){
		ModelMap mm = new ModelMap();
		MasterPegawai mp=appService.findById(id);
		if (mp!=null){
			mm.addAttribute("pegawai", mp);
		}
		return mm;
	}
	
	@RequestMapping(value="/formMasterPegawai", method=RequestMethod.POST)
	public String process(@Valid MasterPegawai pegawai, BindingResult br) {
		if (br.hasErrors()){
			return "redirect:formMasterPegawai";
		}
            appService.savePegawai(pegawai);
            SaldoKasbon sk = saldoService.findByPegawai(pegawai);
            if (sk==null){
            	SaldoKasbon saldoKasbon = new SaldoKasbon();
                saldoKasbon.setMasterPegawai(pegawai);
                saldoKasbon.setSaldoAkhir(BigDecimal.ZERO);
                saldoService.saveSaldoKasbon(saldoKasbon);
            }
            return "redirect:listMasterPegawai";
    }
	
	
}
