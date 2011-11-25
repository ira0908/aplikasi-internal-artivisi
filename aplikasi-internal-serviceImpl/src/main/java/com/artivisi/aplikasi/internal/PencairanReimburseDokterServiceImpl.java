/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.PencairanReimburseDokter;
import com.artivisi.aplikasi.internal.entity.ReimburseDokter;

/**
 * @author ira
 *
 */
@Service("pencairanReimburseDokter")
@Transactional(readOnly=true)
public class PencairanReimburseDokterServiceImpl implements PencairanReimburseDokterService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void savePencairan(PencairanReimburseDokter cair){
		sessionFactory.getCurrentSession().saveOrUpdate(cair);
	}
	
	@Override
	public List<PencairanReimburseDokter> findByPengajuan(ReimburseDokter reimburseDokter){
		return sessionFactory.getCurrentSession()
				.createQuery("from PencairanReimburseDokter where reimburseDokter= :reimburseDokter")
				.setParameter("reimburseDokter", reimburseDokter)
				.list();
	}
}
