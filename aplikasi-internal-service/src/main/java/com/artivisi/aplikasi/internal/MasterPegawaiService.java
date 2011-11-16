package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.SaldoKasbon;

public interface MasterPegawaiService {

	public void savePegawai(MasterPegawai pegawai);
	public List<MasterPegawai> semuaPegawai();
	public MasterPegawai findById(Long id);
	
}

