package com.test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.FleetMasterDAO;
import com.dao.FlightMasterDAO;
import com.dao.PassengerDAO;
import com.dao.implementation.FlightMasterImplementation;
import com.dao.implementation.PassengerImplementation;
import com.model.FareMaster;
import com.model.FleetMaster;
import com.model.FlightMaster;
import com.model.LocationMaster;
import com.model.Passenger;

public class FlightMasterImplementationTest {
	
	private static ApplicationContext ctx;
	@Autowired
	private SessionFactory factory;
	@BeforeClass
	public static void fact(){
	
		ctx = new ClassPathXmlApplicationContext("mybeans.xml");
		System.out.println(ctx);
	}

	FlightMasterDAO flightMasterDAO=ctx.getBean(FlightMasterDAO.class);
	
	@Test
	public void testFlight(){
	
		LocationMaster locationMaster=(LocationMaster) factory.getCurrentSession().get(LocationMaster.class,8001); 
		LocationMaster locationMaster2=(LocationMaster) factory.getCurrentSession().get(LocationMaster.class, 8005);
		FareMaster fareMaster=(FareMaster) factory.getCurrentSession().get(FareMaster.class, 20001);
		FleetMaster fleetMaster=(FleetMaster) factory.getCurrentSession().get(FleetMaster.class, 3);
		FlightMaster flightMaster = new FlightMaster();
		flightMaster.setFlightId(4545);
		flightMaster.setLocationMaster1(locationMaster);
		flightMaster.setLocationMaster2(locationMaster2);
		flightMaster.setFleetMaster(fleetMaster);
		System.out.println(Time.valueOf("10:65:00"));
		flightMaster.setFlightTravelDate(java.sql.Date.valueOf("2017-5-6"));
		flightMaster.setArrivalTime(java.sql.Time.valueOf("11:38:00"));
		flightMaster.setDepartureTime(java.sql.Time.valueOf("08:40:00"));
		flightMaster.setFareMaster(fareMaster);
		
		assertTrue(flightMasterDAO.newFlight(flightMaster));
	}
	
}
