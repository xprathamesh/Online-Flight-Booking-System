package com.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookingDAO;
import com.dao.FleetMasterDAO;
import com.dao.implementation.FleetMasterImplementation;
import com.model.FleetMaster;

public class FleetMasterImplementationTest {
	private static ApplicationContext ctx;
	@Autowired
	private SessionFactory factory;
	@BeforeClass
	public static void fact(){
	
		ctx = new ClassPathXmlApplicationContext("mybeans.xml");
		System.out.println(ctx);
	}

	FleetMasterDAO fleetMasterDAO=ctx.getBean(FleetMasterDAO.class);

	@Test
	public void testFleet(){
		
		FleetMaster fleetMaster = new FleetMaster();
		fleetMaster.setFleetMasterId(6);
		fleetMaster.setCode("A1004");
		fleetMaster.setModel("Z1004");
		fleetMaster.setTotalBusinessSeats(80);
		fleetMaster.setTotalPremiumSeats(100);
		fleetMaster.setTotalEconomySeats(70);
		
		assertTrue(fleetMasterDAO.createFleet(fleetMaster));
	}
	
	/*	@Test
	public void testModifyFleet(){
		
		FleetMaster fleetMaster = new FleetMaster();
		fleetMaster.setFleetMasterId(6);
		fleetMaster.setCode("A1004");
		fleetMaster.setModel("XXXXX");
		fleetMaster.setTotalBusinessSeats(80);
		fleetMaster.setTotalPremiumSeats(100);
		fleetMaster.setTotalEconomySeats(70);
		
		assertTrue(fleetMasterDAO.modifyFleet(fleetMaster));
	}

	
	@Test
	public void testModifyFleetTrue(){
		
		FleetMaster fleetMaster = new FleetMaster();
		fleetMaster.setFleetMasterId(3);
		fleetMaster.setCode("A1004");
		fleetMaster.setModel("XXXXX");
		fleetMaster.setTotalBusinessSeats(80);
		fleetMaster.setTotalPremiumSeats(100);
		fleetMaster.setTotalEconomySeats(70);
		
		assertTrue(fleetMasterDAO.modifyFleet(fleetMaster));
	}*/
	@Test
	public void testDeleteFleet(){	
		assertTrue(fleetMasterDAO.deleteFleet(6));
	}
	
}
