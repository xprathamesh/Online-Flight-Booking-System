package com.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.AddressDetailsDAO;
import com.model.AddressDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AddressDetailsImplementation implements AddressDetailsDAO {

	@Autowired
	private SessionFactory factory;

	public boolean modifyAddress(AddressDetail addressDetail) {
		Session session = factory.getCurrentSession();
		try {
			
			session.update(addressDetail);
			
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	public boolean addNewAddress(AddressDetail addressDetail) {
		Session session = factory.getCurrentSession();
		try {
			session.save(addressDetail);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	public List<AddressDetail> getAddressList(int personId) {
		Session session = factory.getCurrentSession();
		List<AddressDetail> addressDetailList = new ArrayList<AddressDetail>();
		try {
			String query="from AddressDetail where person="+personId;
			addressDetailList = session.createQuery(query).list();
			return addressDetailList;
		} catch (RuntimeException e) {
			return addressDetailList;
		}
	}

	public boolean deleteAddress(int addressId) {
		Session session = factory.getCurrentSession();
		try {
			Query delete_query = session.createQuery("delete from AddressDetail where addressId=:id");
			delete_query.setParameter("id", addressId);
			int n = delete_query.executeUpdate();
			return true;
		} catch (RuntimeException e) {
			return false;
		}

	}

}
