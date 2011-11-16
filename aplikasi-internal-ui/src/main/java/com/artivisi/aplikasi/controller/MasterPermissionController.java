package com.artivisi.aplikasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artivisi.aplikasi.internal.MasterPermissionService;
import com.artivisi.aplikasi.internal.entity.MasterPermission;

@Controller
@RequestMapping("/master")
public class MasterPermissionController {

	@Autowired
	private MasterPermissionService permissionService;
	
	@RequestMapping(value="/formMasterPermission", method=RequestMethod.GET)
	public ModelMap displayFrom(@RequestParam (value="id", required=false)Long id){
		ModelMap mm=new ModelMap();
		mm.addAttribute("data", permissionService.findById(id));
		return mm;
	}
	
	@RequestMapping(value="/formMasterPermission", method=RequestMethod.POST)
	public String savePermission(@ModelAttribute MasterPermission mp){
		permissionService.savePermission(mp);
		return "redirect:listMasterPermission";
	}
	
	@RequestMapping("/listMasterPermission")
	public ModelMap listMasterPermission(){
		ModelMap mm= new ModelMap();
		mm.addAttribute("p", permissionService.findAllPermission());
		return mm;
	}
	
	@RequestMapping("/hapusPermission")
	public String hapusPermission(@RequestParam (value="id", required=true)Long id){
		MasterPermission mp=permissionService.findById(id);
		permissionService.hapusPermission(mp);
		return "redirect:listMasterPermission";
	}
	
}
