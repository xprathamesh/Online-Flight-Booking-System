package com.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.FareMasterDAO;
import com.model.AddressDetail;
import com.model.FareMaster;
@Repository
@Transactional
public class FareMasterImplementation implements FareMasterDAO {

	@Autowired
	private SessionFactory factory;

	
	public boolean newFare(FareMaster fareMaster) {
		Session session = factory.getCurrentSession();
		try {
			session.save(fareMaster);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	
	public boolean modifyFare(FareMaster fareMaster) {
		Session session = factory.getCurrentSession();
		try {
			session.update(fareMaster);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	
	public boolean deleteFare(int fareId) {
		Session session = factory.getCurrentSession();
		try {
			FareMaster fareMasterDelete = (FareMaster) session.load(FareMaster.class, fareId);
			session.delete(fareMasterDelete);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	
	public FareMaster getFare(int fareMasterId) {
		Session session = factory.getCurrentSession();
		FareMaster fareMaster = new FareMaster();
		try {
			fareMaster = (FareMaster) session.get(FareMaster.class, fareMasterId);
			return fareMaster;
		} catch (RuntimeException e) {
			return fareMaster;
		}
	}

	
	public List<FareMaster> getAllFareList() {
		Session session = factory.getCurrentSession();
		List<FareMaster> fareMasterList = new ArrayList<FareMaster>();
		try {
			fareMasterList = session.createQuery("from FareMaster").list();
			return fareMasterList;
		} catch (RuntimeException e) {
			return fareMasterList;
		}
	}

}