package com.artivisi.aplikasi.internal;

import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.SaldoKasbon;

public interface SaldoKasbonService {

	public void saveSaldoKasbon(SaldoKasbon saldoKasbon);
	public List<SaldoKasbon> listSaldoKasbon();
	public SaldoKasbon findByPegawai(MasterPegawai mp);
	public SaldoKasbon findById(Long id);
}
