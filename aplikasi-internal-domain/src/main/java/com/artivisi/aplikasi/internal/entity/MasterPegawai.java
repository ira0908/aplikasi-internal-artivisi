package com.artivisi.aplikasi.internal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;






@Entity
@Table (name="mPegawai")
public class MasterPegawai {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull @NotEmpty
	@Column(name="kodePegawai")
	private String kodePegawai;
	
	@NotNull @NotEmpty
	@Column(name="namaPegawai")
	private String namaPegawai;
	
	@NotNull @NotEmpty
	@Column(name="alamat")
	private String alamat;
	
	@NotNull @NotEmpty
	@Column(name="noTelp")
	private String noTelp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKodePegawai() {
		return kodePegawai;
	}

	public void setKodePegawai(String kodePegawai) {
		this.kodePegawai = kodePegawai;
	}

	public String getNamaPegawai() {
		return namaPegawai;
	}

	public void setNamaPegawai(String namaPegawai) {
		this.namaPegawai = namaPegawai;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNoTelp() {
		return noTelp;
	}

	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}

}
