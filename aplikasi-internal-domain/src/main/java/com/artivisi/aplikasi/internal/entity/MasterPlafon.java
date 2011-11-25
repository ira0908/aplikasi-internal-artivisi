package com.artivisi.aplikasi.internal.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mPlafon")
public class MasterPlafon {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pegawai_id", nullable=false)
	private MasterPegawai masterPegawai;
	
	@Column(name="plafon")
	private BigDecimal plafon;
	
	@Column(name="terpakai")
	private BigDecimal terpakai;
	
	@Column(name="tahun")
	private String tahun;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterPegawai getMasterPegawai() {
		return masterPegawai;
	}

	public void setMasterPegawai(MasterPegawai masterPegawai) {
		this.masterPegawai = masterPegawai;
	}

	

	public BigDecimal getPlafon() {
		return plafon;
	}

	public void setPlafon(BigDecimal plafon) {
		this.plafon = plafon;
	}
	
	
	
	public BigDecimal getTerpakai() {
		return terpakai;
	}

	public void setTerpakai(BigDecimal terpakai) {
		this.terpakai = terpakai;
	}

	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}
	
	
}
