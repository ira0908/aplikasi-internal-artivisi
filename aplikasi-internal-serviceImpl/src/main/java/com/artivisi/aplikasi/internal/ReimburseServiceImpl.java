/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterPegawai;
import com.artivisi.aplikasi.internal.entity.Reimburse;

/**
 * @author ira
 *
 */
@Service("reimburseService")
@Transactional(readOnly=true)
public class ReimburseServiceImpl implements ReimburseService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void saveReimburse(Reimburse reimburse){
		sessionFactory.getCurrentSession().saveOrUpdate(reimburse);
	}
	
	@Override
	public List<Reimburse> findAll(){
		return sessionFactory.getCurrentSession()
				.createQuery("from Reimburse")
				.list();
	}
	
	@Override
	public Reimburse findById(Long id){
		return (Reimburse) sessionFactory.getCurrentSession()
				.createQuery("from Reimburse where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@Override
	public List<Reimburse> findAllNoApp(){
		return sessionFactory.getCurrentSession()
				.createQuery("from Reimburse where app = :noApp or app= :app and diBayar<>nilai")
				.setParameter("noApp", "No")
				.setParameter("app", "Approved")
				.list();
	}
	
	@Override
	public List<Reimburse> findByPegawai(MasterPegawai masterPegawai, Date mulai, Date sampai){
		return sessionFactory.getCurrentSession()
				.createQuery("from Reimburse where masterPegawai = :masterPegawai and tanggal between :mulai and :sampai")
				.setParameter("mulai", mulai)
				.setParameter("sampai", sampai)
				.setParameter("masterPegawai", masterPegawai)
				.list();
	}
	
	@Override
	public List<Reimburse> findByPegawaiNoApp(MasterPegawai masterPegawai){
		return sessionFactory.getCurrentSession()
				.createQuery("from Reimburse where masterPegawai = :masterPegawai and app = :noApp")
				.setParameter("masterPegawai", masterPegawai)
				.setParameter("noApp", "No")
				.list();
	}
	
	@Override
	public List<Reimburse> findByPegawaiApp(MasterPegawai masterPegawai){
		return sessionFactory.getCurrentSession()
				.createQuery("from Reimburse where masterPegawai = :masterPegawai and app = :app")
				.setParameter("masterPegawai", masterPegawai)
				.setParameter("app", "Approved")
				.list();
	}
	
}
