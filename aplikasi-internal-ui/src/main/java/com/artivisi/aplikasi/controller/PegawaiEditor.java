package com.artivisi.aplikasi.controller;

import java.beans.PropertyEditorSupport;

import com.artivisi.aplikasi.internal.MasterPegawaiService;
import com.artivisi.aplikasi.internal.entity.MasterPegawai;

public class PegawaiEditor extends PropertyEditorSupport {
	private MasterPegawaiService pegawaiService;
	
	public PegawaiEditor(MasterPegawaiService pegawaiService) {
		super();
		this.pegawaiService = pegawaiService;
	}

	public void setAsText(String id) throws IllegalArgumentException {
		Long kode = Long.valueOf(id);
		MasterPegawai masterPegawai = pegawaiService.findById(kode);
		if(masterPegawai != null) {
			setValue(masterPegawai);
		}
	}

}
