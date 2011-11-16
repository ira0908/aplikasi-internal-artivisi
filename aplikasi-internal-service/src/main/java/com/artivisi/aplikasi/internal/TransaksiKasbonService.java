package com.artivisi.aplikasi.internal;

import java.util.Date;
import java.util.List;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.SaldoKasbon;
import com.artivisi.aplikasi.internal.entity.TrKasbon;

public interface TransaksiKasbonService {

	public void saveKasbon(TrKasbon kasbon);
	public List<TrKasbon> findAllKasbonByPegawai(MasterPegawai masterPegawai, Date mulai, Date sampai);
	public List<TrKasbon> findAllBayarByPegawai(MasterPegawai masterPegawai, Date mulai, Date sampai);
	public List<TrKasbon> findAllByPegawai(MasterPegawai masterPegawai, Date mulai, Date sampai);
	public TrKasbon findSaldoAwalByDate(MasterPegawai masterPegawai, Date mulai, Date sampai);
}
