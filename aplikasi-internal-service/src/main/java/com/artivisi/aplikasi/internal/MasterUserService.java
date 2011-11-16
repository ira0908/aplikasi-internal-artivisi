package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterUser;

public interface MasterUserService {

	public void saveUser(MasterUser mu);
	public List<MasterUser> findAllUser();
	public MasterUser findById(Long id);
	public void deleteUser(MasterUser mu);
	
}
