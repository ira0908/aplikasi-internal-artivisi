package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.MasterPlafon;

@Service("masterPlafonService")
@Transactional(readOnly=true)
public class MasterPlafonServiceImpl implements MasterPlafonService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void savePlafon(MasterPlafon plafon){
		sessionFactory.getCurrentSession().saveOrUpdate(plafon);
	}
	
	@Override
	public List<MasterPlafon> findAllPlafon(){
		return sessionFactory.getCurrentSession()
				.createQuery("from MasterPlafon")
				.list();
	}
	
	@Override
	public MasterPlafon findById(Long id){
		return (MasterPlafon) sessionFactory.getCurrentSession()
				.createQuery("from MasterPlafon where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@Override
	public MasterPlafon findByPegawai(MasterPegawai masterPegawai){
		return (MasterPlafon) sessionFactory.getCurrentSession()
				.createQuery("from MasterPlafon where masterPegawai = :pegawai")
				.setParameter("pegawai", masterPegawai)
				.uniqueResult();
				
	}
	
	@Transactional(readOnly=false)
	public void hapusPlafon(MasterPlafon plafon){
		sessionFactory.getCurrentSession().delete(plafon);
	}
	
}
