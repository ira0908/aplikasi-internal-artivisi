/**
 * 
 */
package com.artivisi.aplikasi.controller;

import java.beans.PropertyEditorSupport;

import com.artivisi.aplikasi.internal.ReimburseDokterService;
import com.artivisi.aplikasi.internal.entity.ReimburseDokter;

/**
 * @author ira
 *
 */
public class ReimburseDokterEditor extends PropertyEditorSupport{


	private ReimburseDokterService reimburseDokterService;
	

	
	public ReimburseDokterEditor(ReimburseDokterService reimburseDokterService) {
		super();
		this.reimburseDokterService = reimburseDokterService;
	}



	public void setAsText(String id) throws IllegalArgumentException {
		Long kode = Long.valueOf(id);
		ReimburseDokter reimburseDokter = reimburseDokterService.findById(kode);
		if(reimburseDokter != null) {
			setValue(reimburseDokter);
		}
	}
}
