package com.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.FleetMasterDAO;
import com.model.FleetMaster;
@Repository
@Transactional
public class FleetMasterImplementation implements FleetMasterDAO{
	@Autowired
	private SessionFactory factory;
	
	
	public boolean createFleet(FleetMaster fleetMaster) {
		Session session = factory.getCurrentSession();
		try
		{
		session.save(fleetMaster);
		return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
		
	}

	
	public boolean modifyFleet(FleetMaster fleetMaster) {
		Session session = factory.getCurrentSession();
		try
		{
		session.update(fleetMaster);
		return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
	}

	
	public boolean deleteFleet(int fleetId) {
		Session session = factory.getCurrentSession();
		try
		{
		FleetMaster fleetMaster = (FleetMaster) session.load(FleetMaster.class, fleetId);
		session.delete(fleetMaster);
		return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
	}

	
	public FleetMaster getFleet(int fleetId) {
		Session session = factory.getCurrentSession();
		FleetMaster fleetMaster = new FleetMaster();
		try
		{
		fleetMaster = (FleetMaster)session.get(FleetMaster.class, fleetId);
		return fleetMaster;
		}
		catch(RuntimeException e)
		{
			return fleetMaster;
		}
	}

	
	public List<FleetMaster> getAllFleet() {
		Session session = factory.getCurrentSession();
		List<FleetMaster> fleetMasterList = new ArrayList<FleetMaster>();
		try
		{
		fleetMasterList = session.createQuery("from FleetMaster").list();
		return fleetMasterList;
		}
		catch(RuntimeException e)
		{
			return fleetMasterList;
		}

	}
}
