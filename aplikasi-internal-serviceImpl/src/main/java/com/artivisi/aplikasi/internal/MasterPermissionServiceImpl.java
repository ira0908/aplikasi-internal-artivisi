package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterPermission;

@Service("permissionService")
@Transactional(readOnly=true)
public class MasterPermissionServiceImpl implements MasterPermissionService {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=false)
	public void savePermission(MasterPermission mp){
		sessionFactory.getCurrentSession().saveOrUpdate(mp);
	}
	
	@Override
	public List<MasterPermission> findAllPermission(){
		return sessionFactory.getCurrentSession()
				.createQuery("from MasterPermission")
				.list();
	}
	
	@Override
	public MasterPermission findById(Long id){
		return (MasterPermission) sessionFactory.getCurrentSession()
				.createQuery("from MasterPermission where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@Transactional(readOnly=false)
	public void hapusPermission(MasterPermission mp){
		sessionFactory.getCurrentSession().delete(mp);
	}
}
