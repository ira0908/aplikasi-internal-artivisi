package com.artivisi.aplikasi.internal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="masterGroupPermission")
public class MasterGroupPermission {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="group_id", nullable=false)
	private MasterGroup masterGroup;
	
	@ManyToOne
	@JoinColumn(name="permission_id", nullable=false)
	private MasterPermission masterPermission;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterGroup getMasterGroup() {
		return masterGroup;
	}

	public void setMasterGroup(MasterGroup masterGroup) {
		this.masterGroup = masterGroup;
	}

	public MasterPermission getMasterPermission() {
		return masterPermission;
	}

	public void setMasterPermission(MasterPermission masterPermission) {
		this.masterPermission = masterPermission;
	}

	
}
