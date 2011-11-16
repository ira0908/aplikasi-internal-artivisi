package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterGroup;

@Service("groupService")
@Transactional(readOnly=true)
public class MasterGroupServiceImpl implements MasterGroupService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void saveMasterGroup(MasterGroup mg){
		sessionFactory.getCurrentSession().saveOrUpdate(mg);
	}
	
	@Override
	public List<MasterGroup> findAllGroup(){
		return sessionFactory.getCurrentSession()
				.createQuery("from MasterGroup")
				.list();
	}
	
	@Override
	public MasterGroup findById(Long id){
		return (MasterGroup) sessionFactory.getCurrentSession()
				.createQuery("from MasterGroup where id= :id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@Transactional(readOnly=false)
	public void hapusGroup(MasterGroup mg){
		sessionFactory.getCurrentSession().delete(mg);
	}
}
