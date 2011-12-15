/**
 * 
 */
package com.artivisi.aplikasi.internal.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ira
 *
 */
@Entity
@Table(name="pengajuanCuti")
public class PengajuanCuti {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="masterPegawai", nullable=false)
	private MasterPegawai masterPegawai;
	
	@Column(name="tanggalMulai")
	@Temporal(TemporalType.DATE)
	private Date tanggalMulai;
	
	@Column(name="tanggalSelesai")
	@Temporal(TemporalType.DATE)
	private Date tanggalSelesai;
	
	@Column(name="lamaCuti")
	private BigDecimal lamaCuti;
	
	@Column(name="lamaCutiReal")
	private BigDecimal lamaCutiReal;
	
	@Column(name="app")
	private String app;

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

	public Date getTanggalMulai() {
		return tanggalMulai;
	}

	public void setTanggalMulai(Date tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}

	public Date getTanggalSelesai() {
		return tanggalSelesai;
	}

	public void setTanggalSelesai(Date tanggalSelesai) {
		this.tanggalSelesai = tanggalSelesai;
	}

	public BigDecimal getLamaCuti() {
		return lamaCuti;
	}

	public void setLamaCuti(BigDecimal lamaCuti) {
		this.lamaCuti = lamaCuti;
	}

	public BigDecimal getLamaCutiReal() {
		return lamaCutiReal;
	}

	public void setLamaCutiReal(BigDecimal lamaCutiReal) {
		this.lamaCutiReal = lamaCutiReal;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
	
	
	

}
