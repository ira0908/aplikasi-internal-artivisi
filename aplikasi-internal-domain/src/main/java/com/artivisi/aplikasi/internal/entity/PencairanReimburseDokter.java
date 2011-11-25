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
@Table(name="pencairanReimburseDokter")
public class PencairanReimburseDokter {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pengajuan_id", nullable=false)
	private ReimburseDokter reimburseDokter;
	
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

	public ReimburseDokter getReimburseDokter() {
		return reimburseDokter;
	}

	public void setReimburseDokter(ReimburseDokter reimburseDokter) {
		this.reimburseDokter = reimburseDokter;
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
