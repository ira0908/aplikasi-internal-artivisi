package com.artivisi.aplikasi.internal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name="masterUser")
public class MasterUser {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="namaUser")
	private String namaUser;
	
	@Column(name="pass")
	private String pass;
	
	@ManyToOne
	@JoinColumn(name="pegawai_id", nullable=false)
	private MasterPegawai masterPegawai;
	
	@ManyToOne
	@JoinColumn(name="group_id", nullable=false)
	private MasterGroup masterGroup;
	
	@Column(name="enable")
	private Boolean enable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaUser() {
		return namaUser;
	}

	public void setNamaUser(String namaUser) {
		this.namaUser = namaUser;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public MasterPegawai getMasterPegawai() {
		return masterPegawai;
	}

	public void setMasterPegawai(MasterPegawai masterPegawai) {
		this.masterPegawai = masterPegawai;
	}

	public MasterGroup getMasterGroup() {
		return masterGroup;
	}

	public void setMasterGroup(MasterGroup masterGroup) {
		this.masterGroup = masterGroup;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	
}
