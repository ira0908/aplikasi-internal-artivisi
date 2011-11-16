package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterGroupPermission;

@Service("groupPermissionService")
@Transactional(readOnly=true)
public class MasterGroupPermissionServiceImpl implements MasterGroupPermissionService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void saveGroupPermission(MasterGroupPermission gp){
		sessionFactory.getCurrentSession().saveOrUpdate(gp);
	}
	
	@Override
	public List<MasterGroupPermission> findAllGroupPermission(){
		return sessionFactory.getCurrentSession()
				.createQuery("from MasterGroupPermission")
				.list();
	}
	
	@Override
	public MasterGroupPermission findById(Long id){
		return (MasterGroupPermission) sessionFactory.getCurrentSession()
				.createQuery("from MasterGroupPermission where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@Transactional(readOnly=false)
	public void hapusGroupPermission(MasterGroupPermission gp){
		sessionFactory.getCurrentSession().delete(gp);
	}
	
}
