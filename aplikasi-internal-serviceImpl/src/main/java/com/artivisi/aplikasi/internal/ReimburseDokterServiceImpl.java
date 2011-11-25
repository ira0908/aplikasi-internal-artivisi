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
import com.artivisi.aplikasi.internal.entity.ReimburseDokter;

/**
 * @author ira
 *
 */
@Service("reimburseDokterService")
@Transactional(readOnly=true)
public class ReimburseDokterServiceImpl implements ReimburseDokterService {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=false)
	public void saveReimburse(ReimburseDokter reimburse){
		sessionFactory.getCurrentSession().saveOrUpdate(reimburse);
	}
	
	@Override
	public List<ReimburseDokter> findAll(){
		return sessionFactory.getCurrentSession()
				.createQuery("from ReimburseDokter order by tanggal asc")
				.list();
	}
	
	@Override
	public ReimburseDokter findById(Long id){
		return (ReimburseDokter) sessionFactory.getCurrentSession()
				.createQuery("from ReimburseDokter where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@Override
	public List<ReimburseDokter> findAllByPegawai(MasterPegawai masterPegawai){
		return sessionFactory.getCurrentSession()
				.createQuery("from ReimburseDokter where masterPegawai = :masterPegawai order by tanggal asc")
				.setParameter("masterPegawai", masterPegawai)
				.list();
	}
	
	@Override
	public List<ReimburseDokter> findAllNoApp(){
		return sessionFactory.getCurrentSession()
				.createQuery("from ReimburseDokter where approve <> :cancel and nilai <> diBayar")
				.setParameter("cancel", "Cancel")
				.list();
	}
	
	@Override
	public List<ReimburseDokter> findAllByPegawaiNoApp(MasterPegawai masterPegawai){
		return sessionFactory.getCurrentSession()
				.createQuery("from ReimburseDokter where masterPegawai = :masterPegawai and approve <> :cancel and nilai<>diBayar order by tanggal asc")
				.setParameter("cancel", "Cancel")
				.setParameter("masterPegawai", masterPegawai)
				.list();
	}
	
	@Override
	public List<ReimburseDokter> findAllByPegawaiApp(MasterPegawai masterPegawai, Date tanggal){
		return sessionFactory.getCurrentSession()
				.createQuery("from ReimburseDokter where masterPegawai = :masterPegawai and approve = :approve and year(tanggal) = year(:tanggal) order by tanggal asc")
				.setParameter("masterPegawai", masterPegawai)
				.setParameter("approve", "Approved")
				.setParameter("tanggal", tanggal)
				.list();
	}
	
}
