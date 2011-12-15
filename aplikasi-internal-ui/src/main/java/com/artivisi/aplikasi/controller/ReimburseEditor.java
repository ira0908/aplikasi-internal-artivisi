/**
 * 
 */
package com.artivisi.aplikasi.controller;

import java.beans.PropertyEditorSupport;

import com.artivisi.aplikasi.internal.ReimburseService;
import com.artivisi.aplikasi.internal.entity.Reimburse;

/**
 * @author ira
 *
 */
public class ReimburseEditor extends PropertyEditorSupport{


	private ReimburseService reimburseService;
	
	
	
	public ReimburseEditor(ReimburseService reimburseService) {
		super();
		this.reimburseService = reimburseService;
	}



	public void setAsText(String id) throws IllegalArgumentException {
		Long kode = Long.valueOf(id);
		Reimburse reimburse = reimburseService.findById(kode);
		if(reimburse != null) {
			setValue(reimburse);
		}
	}
}
