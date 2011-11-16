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

import com.artivisi.aplikasi.internal.MasterGroupPermissionService;
import com.artivisi.aplikasi.internal.MasterGroupService;
import com.artivisi.aplikasi.internal.MasterPermissionService;
import com.artivisi.aplikasi.internal.entity.MasterGroup;
import com.artivisi.aplikasi.internal.entity.MasterGroupPermission;
import com.artivisi.aplikasi.internal.entity.MasterPermission;

@Controller
@RequestMapping("/master")
public class MasterGroupPermissionController {

	@Autowired
	private MasterGroupService groupService;
	
	@Autowired
	private MasterPermissionService permissionService;
	
	@Autowired
	private MasterGroupPermissionService gpService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(MasterGroup.class, new GroupEditor(groupService));
		binder.registerCustomEditor(MasterPermission.class, new PermissionEditor(permissionService));
	}
	
	public List<MasterGroup> group() throws Exception{
		return groupService.findAllGroup();
	}
	
	public List<MasterPermission> permission() throws Exception{
		return permissionService.findAllPermission();
	}
	
	@RequestMapping(value="/formMasterGP", method=RequestMethod.GET)
	public ModelMap displayFrom(@RequestParam (value="id", required=false)Long id){
		ModelMap mm=new ModelMap();
		mm.addAttribute("g",groupService.findAllGroup());
		mm.addAttribute("p",permissionService.findAllPermission());
		mm.addAttribute("data",gpService.findById(id));
		return mm;
	}
	
	@RequestMapping(value="/formMasterGP", method=RequestMethod.POST)
	public String saveGroupPermission(@ModelAttribute MasterGroupPermission gp){
		gpService.saveGroupPermission(gp);
		return "redirect:listMasterGP";
	}
	
	@RequestMapping(value="/listMasterGP", method=RequestMethod.GET)
	public ModelMap displayList(){
		ModelMap mm = new ModelMap();
		mm.addAttribute("gp",gpService.findAllGroupPermission());
		return mm;
	}
	
	@RequestMapping(value="/hapusGP", method=RequestMethod.GET)
	public String hapusGroupPermission(@RequestParam (value="id", required=true)Long id){
		MasterGroupPermission gp=gpService.findById(id);
		gpService.hapusGroupPermission(gp);
		return "redirect:listMasterGP";
	}
}
