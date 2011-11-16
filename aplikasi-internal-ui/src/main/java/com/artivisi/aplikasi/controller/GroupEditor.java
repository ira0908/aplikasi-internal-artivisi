package com.artivisi.aplikasi.controller;

import java.beans.PropertyEditorSupport;

import com.artivisi.aplikasi.internal.MasterGroupService;
import com.artivisi.aplikasi.internal.entity.MasterGroup;

public class GroupEditor extends PropertyEditorSupport {

	private MasterGroupService groupService;
	
	

	public GroupEditor(MasterGroupService groupService) {
		super();
		this.groupService = groupService;
	}



	public void setAsText(String id) throws IllegalArgumentException {
		Long kode = Long.valueOf(id);
		MasterGroup masterGroup = groupService.findById(kode);
		if(masterGroup != null) {
			setValue(masterGroup);
		}
	}
}
