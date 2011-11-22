package com.artivisi.aplikasi.internal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mTypeReimburse")
public class MasterTypeReimburse {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="typeReimburse")
	private String typeReimburse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeReimburse() {
		return typeReimburse;
	}

	public void setTypeReimburse(String typeReimburse) {
		this.typeReimburse = typeReimburse;
	}
	
	
}
