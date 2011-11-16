package com.artivisi.aplikasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artivisi.aplikasi.internal.MasterGroupService;
import com.artivisi.aplikasi.internal.entity.MasterGroup;

@Controller
@RequestMapping("/master")
public class MasterGroupController {
	
	@Autowired
	private MasterGroupService groupService;
	
	@RequestMapping(value="formMasterGroup", method=RequestMethod.GET)
	public ModelMap displayFormGroup(@RequestParam (value="id", required=false)Long id){
		return new ModelMap().addAttribute("group",groupService.findById(id));
	}
	
	@RequestMapping(value="formMasterGroup", method=RequestMethod.POST)
	public String saveMasterGroup(@ModelAttribute MasterGroup mu){
		groupService.saveMasterGroup(mu);
		return "redirect:listMasterGroup";
	}

	@RequestMapping("listMasterGroup")
	public ModelMap listMasterGroup(){
		ModelMap mm = new ModelMap();
		mm.addAttribute("group",groupService.findAllGroup());
		return mm;
	}
	
	@RequestMapping("hapusGroup")
	public String hapusGroup(@RequestParam Long id){
		MasterGroup mg=groupService.findById(id);
		groupService.hapusGroup(mg);
		return "redirect:listMasterGroup";
	}
	
}
