/**
 * 
 */
package com.artivisi.aplikasi.internal;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.aplikasi.internal.entity.PencairanReimburse;
import com.artivisi.aplikasi.internal.entity.Reimburse;

/**
 * @author ira
 *
 */
@Service("pencairanReimburseService")
@Transactional(readOnly=true)
public class PencairanReimburseServiceImpl implements PencairanReimburseService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void savePencairan(PencairanReimburse cair){
		sessionFactory.getCurrentSession().saveOrUpdate(cair);
	}

	@Override
	public List<PencairanReimburse> findPencairanByPengajuan(Reimburse reimburse){
		return sessionFactory.getCurrentSession()
				.createQuery("from PencairanReimburse where reimburse= :reimburse")
				.setParameter("reimburse", reimburse)
				.list();
	}
	
	
	
	
}
