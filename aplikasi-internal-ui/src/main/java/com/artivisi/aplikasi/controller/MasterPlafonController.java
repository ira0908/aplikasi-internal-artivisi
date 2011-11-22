package com.artivisi.aplikasi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artivisi.aplikasi.internal.MasterPegawaiService;
import com.artivisi.aplikasi.internal.MasterPlafonService;
import com.artivisi.aplikasi.internal.entity.MasterGroup;
import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.MasterPlafon;

@Controller
public class MasterPlafonController {

	@Autowired
	private MasterPlafonService plafonService;
	
	@Autowired
	private MasterPegawaiService pegawaiService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(MasterPegawai.class, new PegawaiEditor(pegawaiService));
	}
	
	public List<MasterPegawai> pegawai() throws Exception{
		return pegawaiService.semuaPegawai();
	}
	
	@RequestMapping(value="/master/formMasterPlafon", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam (value="id", required=false)Long id){
		ModelMap mm = new ModelMap();
		mm.addAttribute("peg", pegawaiService.semuaPegawai());
		mm.addAttribute("data", plafonService.findById(id));
		return mm;
	}
	
	@RequestMapping(value="/master/formMasterPlafon", method=RequestMethod.POST)
	public String savePlafon(@ModelAttribute MasterPlafon plafon){
		plafonService.savePlafon(plafon);
		return "redirect:listMasterPlafon";
	}
	
	@RequestMapping("/master/listMasterPlafon")
	public ModelMap listMasterPlafon(){
		ModelMap mm = new ModelMap();
		mm.addAttribute("plafon", plafonService.findAllPlafon());
		return mm;
	}
	
	@RequestMapping("/master/hapusPlafon")
	public String hapusPlafon(@RequestParam (value="id", required=false)Long id){
		MasterPlafon mp=plafonService.findById(id);
		plafonService.hapusPlafon(mp);
		return "redirect:listMasterPlafon";
	}
	
}
