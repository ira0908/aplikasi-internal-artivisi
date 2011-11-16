package com.artivisi.aplikasi.internal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="masterGroup")
public class MasterGroup {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="namaGroup")
	private String namaGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaGroup() {
		return namaGroup;
	}

	public void setNamaGroup(String namaGroup) {
		this.namaGroup = namaGroup;
	}

	
}
