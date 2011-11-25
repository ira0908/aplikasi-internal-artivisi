package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterTypeReimburse;

@Service("typeReimburseService")
@Transactional(readOnly=true)
public class MasterTypeReimburseServiceImpl implements MasterTypeReimburseService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void saveTypeReimburse(MasterTypeReimburse type){
		sessionFactory.getCurrentSession().saveOrUpdate(type);
	}
	
	@Override
	public List<MasterTypeReimburse> findAllType(){
		return sessionFactory.getCurrentSession()
				.createQuery("from MasterTypeReimburse")
				.list();
	}
	
	@Override
	public MasterTypeReimburse findById(Long id){
		return (MasterTypeReimburse) sessionFactory.getCurrentSession()
				.createQuery("from MasterTypeReimburse where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@Transactional(readOnly=false)
	public void hapusType(MasterTypeReimburse type){
		sessionFactory.getCurrentSession().delete(type);
	}
}
