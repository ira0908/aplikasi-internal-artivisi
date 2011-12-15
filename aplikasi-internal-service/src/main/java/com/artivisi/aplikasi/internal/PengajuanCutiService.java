/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.PengajuanCuti;

/**
 * @author ira
 *
 */
public interface PengajuanCutiService {

	public void savePengajuanCuti(PengajuanCuti cuti);
	public List<PengajuanCuti> findAll();
	public List<PengajuanCuti> findAllNoApp();
	public List<PengajuanCuti> findAllAppByPegawai(MasterPegawai masterPegawai);
	public List<PengajuanCuti> findAllByPengawai(MasterPegawai masterPegawai);
	public PengajuanCuti findById(Long id);
}
