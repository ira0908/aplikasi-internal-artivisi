/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.PencairanReimburseDokter;
import com.artivisi.aplikasi.internal.entity.ReimburseDokter;

/**
 * @author ira
 *
 */
public interface PencairanReimburseDokterService {

	public void savePencairan(PencairanReimburseDokter cair);
	public List<PencairanReimburseDokter> findByPengajuan(ReimburseDokter reimburseDokter);
}
