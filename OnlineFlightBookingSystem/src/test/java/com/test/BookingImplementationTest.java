package com.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookingDAO;
import com.model.Booking;

public class BookingImplementationTest {
	private static ApplicationContext ctx;
	@Autowired
	private SessionFactory factory;
	@BeforeClass
	public static void fact(){
	
		ctx = new ClassPathXmlApplicationContext("mybeans.xml");
		System.out.println(ctx);
	}

	BookingDAO bookingDAO=ctx.getBean(BookingDAO.class);

	@Test
	public void testBooking(){
		Booking booking=new Booking();
		booking.setBookingId(3008);
		booking.setBookingNumber("AZ10");
		booking.setTotalCost(5000);
		
		
		assertTrue(bookingDAO.newBooking(booking));
	}

	
	@Test
	public void testDeleteBooking(){	
		//Booking booking=new Booking();
		assertTrue(bookingDAO.deleteBooking(3008));		
	}
}
