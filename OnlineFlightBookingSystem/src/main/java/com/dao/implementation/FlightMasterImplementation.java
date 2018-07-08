package com.dao.implementation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.FlightMasterDAO;
import com.model.FlightMaster;
import com.model.LocationMaster;
import com.model.Person;
@Repository
@Transactional
public class FlightMasterImplementation implements FlightMasterDAO {
	@Autowired
	private SessionFactory factory;
	
	public boolean newFlight(FlightMaster flightMaster) {
		Session session = factory.getCurrentSession();
		try
		{
		session.save(flightMaster);
		return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
	}

	
	public List<FlightMaster> searchFlight(LocationMaster sourceLocation, LocationMaster destinationLocation, Date travelDate) {

		Session session = factory.getCurrentSession();
		List<FlightMaster> flightMaster=new ArrayList<FlightMaster>();
		try
		{
		Criteria c=session.createCriteria(FlightMaster.class);
		c.add(Restrictions.eq("locationMaster1", sourceLocation));
		c.add(Restrictions.eq("locationMaster2",destinationLocation));
		c.add(Restrictions.eq("flightTravelDate", travelDate));
		c.addOrder(Order.asc("departureTime"));
		flightMaster=c.list();
		return flightMaster;
		}
		catch(RuntimeException e)
		{
			return  flightMaster;
		}
	}
	
	
	public boolean updateRemainingSeats(FlightMaster flightMaster) {
		Session session = factory.getCurrentSession();
		try
		{
		session.update(flightMaster);
		return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
	}
	
	public FlightMaster getFlight(int flightId) {
		Session session = factory.getCurrentSession();
		FlightMaster flight=new FlightMaster();
		try
		{
			Criteria criteria = session.createCriteria(FlightMaster.class);
			criteria.add(Restrictions.eq("flightId", flightId));
			flight=(FlightMaster)criteria.uniqueResult();
			return flight;
		}
		catch(RuntimeException e)
		{
			return flight;
		}
	}


	public List<FlightMaster> getAll()
	{

		Session session = factory.getCurrentSession();
		List<FlightMaster> list=session.createQuery("from FlightMaster").list();
		return list;
	}
}
