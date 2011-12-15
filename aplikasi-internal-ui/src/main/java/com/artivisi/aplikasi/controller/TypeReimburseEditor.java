package com.artivisi.aplikasi.controller;

import java.beans.PropertyEditorSupport;

import com.artivisi.aplikasi.internal.MasterTypeReimburseService;
import com.artivisi.aplikasi.internal.entity.MasterTypeReimburse;

public class TypeReimburseEditor extends PropertyEditorSupport {
	private MasterTypeReimburseService typeReimburseService;
	


	public TypeReimburseEditor(MasterTypeReimburseService typeReimburseService) {
		super();
		this.typeReimburseService = typeReimburseService;
	}



	public void setAsText(String id) throws IllegalArgumentException {
		Long kode = Long.valueOf(id);
		MasterTypeReimburse typeReimburse = typeReimburseService.findById(kode);
		if(typeReimburse != null) {
			setValue(typeReimburse);
		}
	}

}
