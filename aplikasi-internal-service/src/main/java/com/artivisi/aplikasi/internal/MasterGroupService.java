package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterGroup;

public interface MasterGroupService {

	public void saveMasterGroup(MasterGroup mg);
	public List<MasterGroup> findAllGroup();
	public MasterGroup findById(Long id);
	public void hapusGroup(MasterGroup mg);
}
