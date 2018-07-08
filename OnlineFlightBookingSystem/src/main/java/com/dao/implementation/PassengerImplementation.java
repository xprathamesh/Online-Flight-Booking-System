package com.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PassengerDAO;
import com.model.AddressDetail;
import com.model.Passenger;
@Repository
@Transactional
public class PassengerImplementation implements PassengerDAO {
	@Autowired
	private SessionFactory factory;

	
	public boolean newPassenger(Passenger passenger) {
		Session session = factory.getCurrentSession();
		try
		{
			session.save(passenger);
			return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
	}

	
	public List<Passenger> getPassenger(int bookingId) {
		Session session = factory.getCurrentSession();
		List<Passenger> allPassenger=new ArrayList<Passenger>();
		try
		{
			//Booking booking=(Booking) session.get(Booking.class, bookingId);
/*			Criteria criteria=session.createCriteria(Passenger.class);
			criteria.add(Restrictions.eq("booking", bookingId));
			allPassenger=criteria.list();*/
			String sql_query="from Passenger WHERE booking="+bookingId;
			allPassenger=session.createQuery(sql_query).list();
			return allPassenger;
		}
		catch(RuntimeException e)
		{
			return allPassenger;
		}
	}

}
