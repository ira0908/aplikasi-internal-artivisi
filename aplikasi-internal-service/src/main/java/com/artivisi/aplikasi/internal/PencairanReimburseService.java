/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.PencairanReimburse;
import com.artivisi.aplikasi.internal.entity.Reimburse;

/**
 * @author 
 * ira
 *
 */
public interface PencairanReimburseService {

	public void savePencairan(PencairanReimburse cair);
	public List<PencairanReimburse> findPencairanByPengajuan(Reimburse reimburse);
}
