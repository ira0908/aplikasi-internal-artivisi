/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.Date;
import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.ReimburseDokter;

/**
 * @author ira
 *
 */
public interface ReimburseDokterService {

	public void saveReimburse(ReimburseDokter reimburse);
	public List<ReimburseDokter> findAll();
	public ReimburseDokter findById(Long Id);
	public List<ReimburseDokter> findAllByPegawai(MasterPegawai masterPegawai);
	public List<ReimburseDokter> findAllNoApp();
	public List<ReimburseDokter> findAllByPegawaiNoApp(MasterPegawai masterPegawai);
	public List<ReimburseDokter> findAllByPegawaiApp(MasterPegawai masterPegawai, Date tanggal);
}
