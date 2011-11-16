package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.MasterUser;

@Service("userService")
@Transactional(readOnly=true)
public class MasterUserServiceImpl implements MasterUserService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void saveUser(MasterUser mu){
		sessionFactory.getCurrentSession().saveOrUpdate(mu);
	}
	
	@Override
	public List<MasterUser> findAllUser(){
		return sessionFactory.getCurrentSession()
				.createQuery("from MasterUser")
				.list();
	}
	
	@Override
	public MasterUser findById(Long id){
		return (MasterUser) sessionFactory.getCurrentSession()
				.createQuery("from MasterUser where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@Transactional(readOnly=false)
	public void deleteUser(MasterUser mu){
		sessionFactory.getCurrentSession().delete(mu);
	}
	
}
