package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.SaldoKasbon;

@Service("pegawaiService")
@Transactional(readOnly=true)
public class MasterPegawaiServiceImpl implements MasterPegawaiService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void savePegawai(MasterPegawai pegawai){
		sessionFactory.getCurrentSession().saveOrUpdate(pegawai);
	}
	
	@Override
	public List<MasterPegawai> semuaPegawai(){
		return sessionFactory.getCurrentSession()
                .createQuery("from MasterPegawai order by kodePegawai Asc")
                .list();
	}
	
	@Override
	public MasterPegawai findById(Long id){
		return (MasterPegawai) sessionFactory.getCurrentSession()
				.createQuery("from MasterPegawai where id =:id")
				.setParameter("id", id).uniqueResult();
	}
}
