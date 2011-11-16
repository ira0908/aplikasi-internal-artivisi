package com.artivisi.aplikasi.internal;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.SaldoKasbon;
import com.artivisi.aplikasi.internal.entity.TrKasbon;

@Service("kasbonService")
@Transactional(readOnly=true)
public class TransaksiKasbonServiceImpl implements TransaksiKasbonService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void saveKasbon(TrKasbon kasbon){
		sessionFactory.getCurrentSession().saveOrUpdate(kasbon);
	}
	
	@Transactional(readOnly=false)
	public List<TrKasbon> findAllKasbonByPegawai(MasterPegawai masterPegawai, Date mulai, Date sampai){
		return sessionFactory.getCurrentSession()
				.createQuery("from TrKasbon where masterPegawai = :masterPegawai and tanggal between :mulai and :sampai and type = 'kasbon'")
				.setParameter("masterPegawai", masterPegawai)
				.setParameter("mulai", mulai)
				.setParameter("sampai", sampai)
				.list();
	}
	
	@Transactional(readOnly=false)
	public List<TrKasbon> findAllBayarByPegawai(MasterPegawai masterPegawai, Date mulai, Date sampai){
		return sessionFactory.getCurrentSession()
				.createQuery("from TrKasbon where masterPegawai = :masterPegawai  and tanggal between :mulai and :sampai and type = 'bayar'")
				.setParameter("masterPegawai", masterPegawai)
				.setParameter("mulai", mulai)
				.setParameter("sampai", sampai)
				.list();
	}
	
	@Transactional(readOnly=false)
	public List<TrKasbon> findAllByPegawai(MasterPegawai masterPegawai, Date mulai, Date sampai){
		return sessionFactory.getCurrentSession()
				.createQuery("from TrKasbon where masterPegawai = :masterPegawai and tanggal between :mulai and :sampai")
				.setParameter("masterPegawai", masterPegawai)
				.setParameter("mulai", mulai)
				.setParameter("sampai", sampai)
				.list();
	}
	
	@Transactional(readOnly=false)
	public TrKasbon findSaldoAwalByDate(MasterPegawai masterPegawai, Date mulai, Date sampai){
		return (TrKasbon)sessionFactory.getCurrentSession()
				.createQuery("from TrKasbon where masterPegawai = :masterPegawai and tanggal between :mulai and :sampai")
				.setParameter("masterPegawai", masterPegawai)
				.setParameter("mulai", mulai)
				.setParameter("sampai", sampai)
				.setMaxResults(1).uniqueResult();
				
	}

}
