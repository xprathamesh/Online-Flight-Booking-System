package com.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.AddressDetailsDAO;
import com.dao.PassengerDAO;
import com.dao.implementation.AddressDetailsImplementation;
import com.dao.implementation.PassengerImplementation;
import com.model.AddressDetail;
import com.model.Passenger;

public class PassengerImplementationTest {
	private static ApplicationContext ctx;
	@Autowired
	private SessionFactory factory;
	@BeforeClass
	public static void fact(){
	
		ctx = new ClassPathXmlApplicationContext("mybeans.xml");
		System.out.println(ctx);
	}

	PassengerDAO passengerDAO=ctx.getBean(PassengerDAO.class);
	@Test
	public void testPassenger()
	{
		Passenger passenger=new Passenger();
		passenger.setPassengerId(9);
		passenger.setPassengerType("child");
		passenger.setFirstName("sunil");
		passenger.setMiddleName("babu");
		passenger.setLastName("xyz");
		passenger.setPassportNumber("PA318722");
		passenger.setMealPreferences("NVG");

		assertTrue(passengerDAO.newPassenger(passenger));
	}
}
