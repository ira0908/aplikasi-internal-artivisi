/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.Date;
import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.Reimburse;

/**
 * @author ira
 *
 */
public interface ReimburseService {

	public void saveReimburse(Reimburse reimburse);
	public List<Reimburse> findAll();
	public Reimburse findById(Long id);
	public List<Reimburse> findAllNoApp();
	public List<Reimburse> findByPegawai(MasterPegawai masterPegawai, Date mulai, Date sampai);
	public List<Reimburse> findByPegawaiNoApp(MasterPegawai masterPegawai);
	public List<Reimburse> findByPegawaiApp(MasterPegawai masterPegawai);
	
}
