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
@Table(name="reimburse")
public class Reimburse {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="typeReimburse", nullable=false)
	private MasterTypeReimburse typeReimburse;
	
	
	@Column(name="tanggal")
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	
	@ManyToOne
	@JoinColumn(name="masterPegawai", nullable=false)
	private MasterPegawai masterPegawai;
	
	@Column(name="nilai")
	private BigDecimal nilai;
	
	@Column(name="ket")
	private String ket;
	
	@Column(name="app")
	private String app;
	
	@Column(name="diBayar")
	private BigDecimal diBayar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterTypeReimburse getTypeReimburse() {
		return typeReimburse;
	}

	public void setTypeReimburse(MasterTypeReimburse typeReimburse) {
		this.typeReimburse = typeReimburse;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public MasterPegawai getMasterPegawai() {
		return masterPegawai;
	}

	public void setMasterPegawai(MasterPegawai masterPegawai) {
		this.masterPegawai = masterPegawai;
	}

	public BigDecimal getNilai() {
		return nilai;
	}

	public void setNilai(BigDecimal nilai) {
		this.nilai = nilai;
	}

	public String getKet() {
		return ket;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public BigDecimal getDiBayar() {
		return diBayar;
	}

	public void setDiBayar(BigDecimal diBayar) {
		this.diBayar = diBayar;
	}
	
	
	
}
