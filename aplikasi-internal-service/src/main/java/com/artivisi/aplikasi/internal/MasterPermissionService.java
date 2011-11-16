package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPermission;

public interface MasterPermissionService {

	public void savePermission(MasterPermission mp);
	public List<MasterPermission> findAllPermission();
	public MasterPermission findById(Long id);
	public void hapusPermission(MasterPermission mp);
}
