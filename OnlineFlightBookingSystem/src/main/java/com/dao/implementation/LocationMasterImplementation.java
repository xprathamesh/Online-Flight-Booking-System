package com.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LocationMasterDAO;
import com.model.LocationMaster;

@Repository
@Transactional
public class LocationMasterImplementation implements LocationMasterDAO {

	@Autowired
	private SessionFactory factory;
	
	public boolean createLocation(LocationMaster locationMaster) {
		Session session = factory.getCurrentSession();
		try
		{
		session.save(locationMaster);
		return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
	}

	
	public boolean updateLocation(LocationMaster locationMaster) {
		Session session = factory.getCurrentSession();
		try
		{
		session.save(locationMaster);
		return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}	
	}

	
	public boolean deleteLocation(int locationId) {
		Session session = factory.getCurrentSession();
		try
		{	
		Query delete_query=session.createQuery("delete from LocationMaster where locationMasterId=:id");
		delete_query.setParameter("id", locationId);
		delete_query.executeUpdate();
		return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
}

	public LocationMaster getLocation(int locationMasterId) {
		Session session = factory.getCurrentSession();
		LocationMaster locationMaster=new LocationMaster();
		try
		{
		locationMaster=(LocationMaster)session.get(LocationMaster.class, locationMasterId);
		return locationMaster;
		}
		catch(RuntimeException e)
		{
			return locationMaster;
		}
	}

	
	public List<LocationMaster> getAllLocation() {
		Session session = factory.getCurrentSession();
		List<LocationMaster> locationMasters=new ArrayList<LocationMaster>();
		try
		{
			locationMasters=session.createQuery("from LocationMaster").list();
			return locationMasters;
		}
		catch(RuntimeException e)
		{
			return locationMasters;
		}
	}
}
