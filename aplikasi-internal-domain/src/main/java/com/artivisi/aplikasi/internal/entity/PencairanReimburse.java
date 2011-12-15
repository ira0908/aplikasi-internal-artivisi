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
@Table(name="pencairanReimburse")
public class PencairanReimburse {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_reimburse", nullable=false)
	private Reimburse reimburse;
	
	@Column(name="tanggal")
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	
	@Column(name="nilai")
	private BigDecimal nilai;
	
	@Column(name="ket")
	private String ket;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reimburse getReimburse() {
		return reimburse;
	}

	public void setReimburse(Reimburse reimburse) {
		this.reimburse = reimburse;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
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
	
	

}
