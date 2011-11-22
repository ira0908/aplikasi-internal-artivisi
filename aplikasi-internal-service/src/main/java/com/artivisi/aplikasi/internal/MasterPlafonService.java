package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.MasterPlafon;

public interface MasterPlafonService {

	public void savePlafon(MasterPlafon plafon);
	public List<MasterPlafon> findAllPlafon();
	public MasterPlafon findById(Long id);
	public MasterPlafon findByPegawai(MasterPegawai masterPegawai);
	public void hapusPlafon(MasterPlafon plafon);
}
