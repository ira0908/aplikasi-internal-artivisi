package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterGroupPermission;

public interface MasterGroupPermissionService {
	
	public void saveGroupPermission(MasterGroupPermission gp);
	public List<MasterGroupPermission> findAllGroupPermission();
	public MasterGroupPermission findById(Long id);
	public void hapusGroupPermission(MasterGroupPermission gp);
	

}
