package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.SaldoKasbon;

@Service
@Transactional(readOnly=true)
public class SaldoKasbonServiceImpl implements SaldoKasbonService{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<SaldoKasbon> listSaldoKasbon(){
		return sessionFactory.getCurrentSession()
                .createQuery("from SaldoKasbon order by masterPegawai.kodePegawai Asc")
                .list();
	}
	
	@Transactional(readOnly=false)
	public void saveSaldoKasbon(SaldoKasbon saldo){
		sessionFactory.getCurrentSession().saveOrUpdate(saldo);
	}
	
	@Transactional(readOnly=false)
	public SaldoKasbon findByPegawai(MasterPegawai mp){
		return (SaldoKasbon) sessionFactory.getCurrentSession()
				.createQuery("from SaldoKasbon where masterPegawai = :masterPegawai")
				.setParameter("masterPegawai", mp).uniqueResult();
	}
	@Transactional(readOnly=false)
	public SaldoKasbon findById(Long id){
		return (SaldoKasbon) sessionFactory.getCurrentSession()
				.createQuery("from SaldoKasbon where id = :id")
				.setParameter("id", id).uniqueResult();
	}
	
}
