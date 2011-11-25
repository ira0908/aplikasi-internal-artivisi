/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterTypeReimburse;

/**
 * @author ira
 *
 */
public interface MasterTypeReimburseService {

	public void saveTypeReimburse(MasterTypeReimburse type);
	public List<MasterTypeReimburse> findAllType();
	public MasterTypeReimburse findById(Long id);
	public void hapusType(MasterTypeReimburse type);
}
