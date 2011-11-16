package com.artivisi.aplikasi.controller;

import java.beans.PropertyEditorSupport;

import com.artivisi.aplikasi.internal.MasterPermissionService;
import com.artivisi.aplikasi.internal.entity.MasterPermission;

public class PermissionEditor extends PropertyEditorSupport {

	private MasterPermissionService permissionService;
	
	
	public PermissionEditor(MasterPermissionService permissionService) {
		super();
		this.permissionService = permissionService;
	}


	public void setAsText(String id) throws IllegalArgumentException {
		Long kode = Long.valueOf(id);
		MasterPermission masterPermission = permissionService.findById(kode);
		if(masterPermission != null) {
			setValue(masterPermission);
		}
	}
}
