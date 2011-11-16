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
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;



@Entity
@Table(name="TrKasbon")
public class TrKasbon {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pegawai_id", nullable=false)
	private MasterPegawai masterPegawai;
	
	@NotNull @NotEmpty
	@Column(name="tanggal")
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	
	@NotNull @NotEmpty
	@Column(name="ket")
	private String ket;
	
	@Min(0)
	@Column(name="nilai")
	private BigDecimal nilai;
	
	@Column(name="saldoAwal")
	private BigDecimal saldoAwal;
	
	@Column(name="saldoAkhir")
	private BigDecimal saldoAkhir;

	@Column(name="type")
	private String type;
	
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

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getKet() {
		return ket;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}

	

	public BigDecimal getNilai() {
		return nilai;
	}

	public void setNilai(BigDecimal nilai) {
		this.nilai = nilai;
	}

	public BigDecimal getSaldoAwal() {
		return saldoAwal;
	}

	public void setSaldoAwal(BigDecimal saldoAwal) {
		this.saldoAwal = saldoAwal;
	}

	public BigDecimal getSaldoAkhir() {
		return saldoAkhir;
	}

	public void setSaldoAkhir(BigDecimal saldoAkhir) {
		this.saldoAkhir = saldoAkhir;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
