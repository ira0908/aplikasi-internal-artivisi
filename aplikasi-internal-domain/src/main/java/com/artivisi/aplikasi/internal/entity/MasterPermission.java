package com.artivisi.aplikasi.internal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="masterPermission")
public class MasterPermission {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="namaPermission")
	private String namaPermission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaPermission() {
		return namaPermission;
	}

	public void setNamaPermission(String namaPermission) {
		this.namaPermission = namaPermission;
	}
	
	
}
