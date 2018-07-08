package com.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BookingDAO;
import com.model.Booking;
import com.model.Person;

@Repository
@Transactional
public class BookingImplementation implements BookingDAO {
	
	@Autowired
	private SessionFactory factory;
	public boolean newBooking(Booking booking) {
		Session session = factory.getCurrentSession();
		try
		{
			session.save(booking);
			return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
	}

	public List<Booking> getBookedDetails(int personId) {
		
		Session session=factory.getCurrentSession();
		
		try
		{
			List<Booking> bookingList;
			session.beginTransaction().commit();
			String sql_query="from Booking WHERE person="+personId;
			bookingList=session.createQuery(sql_query).list();
			return bookingList;
		}
		catch(RuntimeException e)
		{
			return null;
		}
	}
	public boolean deleteBooking(int bookingId) {
		Session session = factory.getCurrentSession();
		try
		{
			Booking del = (Booking) session.load(Booking.class, bookingId);
			session.delete(del);
			return true;
		}
		catch(RuntimeException e)
		{
			return false;
		}
}
	public Booking getBooking(int bookingId) {
		Booking booking=new Booking();
		Session session = factory.getCurrentSession();
		try
		{
			Criteria criteria = session.createCriteria(Person.class);
			criteria.add(Restrictions.eq("flightId", bookingId));
			booking=(Booking)criteria.uniqueResult();
			return booking;
		}
		catch(RuntimeException e)
		{
			return booking;
		}
	}
}