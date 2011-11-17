package com.artivisi.aplikasi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artivisi.aplikasi.internal.MasterGroupService;
import com.artivisi.aplikasi.internal.MasterPegawaiService;
import com.artivisi.aplikasi.internal.MasterUserService;
import com.artivisi.aplikasi.internal.entity.MasterGroup;
import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.MasterUser;

@Controller
@RequestMapping("/master")
public class MasterUserController {

	@Autowired
	private MasterUserService userService;
	
	@Autowired
	private MasterPegawaiService pegawaiService;
	
	@Autowired
	private MasterGroupService groupService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(MasterPegawai.class, new PegawaiEditor(pegawaiService));
		binder.registerCustomEditor(MasterGroup.class, new GroupEditor(groupService));
	}
	
	public List<MasterPegawai> pegawai() throws Exception{
		return pegawaiService.semuaPegawai();
	}
	
	public List<MasterUser> user() throws Exception{
		return userService.findAllUser();
	}
	
	@RequestMapping(value="/listMasterUser", method=RequestMethod.GET)
	public ModelMap listUser(){
		return new ModelMap().addAttribute("user",userService.findAllUser());
	}
	
	@RequestMapping(value="/formMasterUser", method=RequestMethod.POST)
	public String saveUser(@Valid MasterUser mu){
		userService.saveUser(mu);
		return "redirect:listMasterUser";
	}
	
	@RequestMapping(value="/formMasterUser", method=RequestMethod.GET)
	public ModelMap displayFor(@RequestParam (value="id", required=false)Long id){
		ModelMap mm=new ModelMap();
		mm.addAttribute("data", userService.findById(id));
		mm.addAttribute("peg",pegawaiService.semuaPegawai());
		mm.addAttribute("group",groupService.findAllGroup());
		return mm;
	}
	
	@RequestMapping(value="/hapusUser", method=RequestMethod.GET)
	public String hapusUser(@RequestParam Long id){
		MasterUser mu=userService.findById(id);
		userService.deleteUser(mu);
		return "redirect:listMasterUser";
	}
	
	
		
}
