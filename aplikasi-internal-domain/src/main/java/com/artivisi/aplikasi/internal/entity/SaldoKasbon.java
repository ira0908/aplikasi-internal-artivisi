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

@Entity
@Table(name="saldoKasbon")
public class SaldoKasbon {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pegawai_id", nullable=false)
	private MasterPegawai masterPegawai;
	
	@Column(name="saldoAkhir")
	private BigDecimal saldoAkhir=BigDecimal.ZERO;

	@Column(name="tanggal")
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	
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

	public BigDecimal getSaldoAkhir() {
		return saldoAkhir;
	}

	public void setSaldoAkhir(BigDecimal saldoAkhir) {
		this.saldoAkhir = saldoAkhir;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	

	
	
}
