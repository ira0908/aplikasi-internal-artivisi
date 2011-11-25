/**
 * 
 */
package com.artivisi.aplikasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artivisi.aplikasi.internal.MasterTypeReimburseService;
import com.artivisi.aplikasi.internal.entity.MasterTypeReimburse;

/**
 * @author ira
 *
 */
@Controller
public class MasterTypeReimburseController {

	@Autowired
	private MasterTypeReimburseService typeService;
	
	@RequestMapping(value="/master/formMasterTypeReimburse", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam (value="id", required=false)Long id){
		ModelMap mm = new ModelMap();
		mm.addAttribute("data", typeService.findById(id));
		return mm;
	}
	
	@RequestMapping(value="/master/formMasterTypeReimburse", method=RequestMethod.POST)
	public String saveTypeReimburse(@ModelAttribute MasterTypeReimburse type){
		typeService.saveTypeReimburse(type);
		return "redirect:listMasterTypeReimburse";
	}
	
	@RequestMapping("/master/listMasterTypeReimburse")
	public ModelMap listTypeReimburse(){
		ModelMap mm = new ModelMap();
		mm.addAttribute("data", typeService.findAllType());
		return mm;
	}
	
	@RequestMapping("/master/hapusType")
	public String hapusType(@RequestParam (value="id", required=true)Long id){
		MasterTypeReimburse mtr=typeService.findById(id);
		typeService.hapusType(mtr);
		return "redirect:listMasterTypeReimburse";
	}
	
}
