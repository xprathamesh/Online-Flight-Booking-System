package com.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.LocationMasterDAO;
import com.model.LocationMaster;

public class LocationMasterImplementationTest {

	private static ApplicationContext ctx;
	@Autowired
	private SessionFactory factory;
	@BeforeClass
	public static void fact(){
	
		ctx = new ClassPathXmlApplicationContext("mybeans.xml");
		System.out.println(ctx);
	}
	@Test
 public void testLocation(){
	 LocationMaster locationMaster=new LocationMaster();
		locationMaster.setLocationMasterId(1239);
		locationMaster.setName("Mumbai");
		locationMaster.setCode("In");
		locationMaster.setCountry("India");
		locationMaster.setAirportName("dsdd");
		LocationMasterDAO locationMasterDAO =ctx.getBean(LocationMasterDAO.class);
		System.out.println(locationMasterDAO);
		//locationMasterDAO.createLocation(locationMaster);
		//locationMasterDAO.updateLocation(locationMaster);
		//locationMasterDAO.deleteLocation(1234);
		//fail("Not yet implemented");
				assertEquals(true,locationMasterDAO.createLocation(locationMaster));
		//LocationMaster temp=locationMasterDAO.getLocation(8005);
		
 }
	
	@Test
 public void testUpdateLocation(){
	 LocationMaster locationMaster=new LocationMaster();
		locationMaster.setLocationMasterId(1239);
		locationMaster.setName("Mumbai");
		locationMaster.setCode("In");
		locationMaster.setCountry("India");
		locationMaster.setAirportName("XXX");
		LocationMasterDAO locationMasterDAO =ctx.getBean(LocationMasterDAO.class);
		//locationMasterDAO.createLocation(locationMaster);
		//locationMasterDAO.updateLocation(locationMaster);
		//locationMasterDAO.deleteLocation(1234);
		
		//LocationMaster temp=locationMasterDAO.getLocation(8005);
		
		assertTrue(locationMasterDAO.updateLocation(locationMaster));
 }
	@Test
 public void testDeleteLocation(){
	// LocationMaster locationMaster=new LocationMaster();
		
	//	LocationMaster temp=locationMasterDAO.getLocation(8005);
		LocationMasterDAO locationMasterDAO =ctx.getBean(LocationMasterDAO.class);
		
		assertTrue(locationMasterDAO.deleteLocation(1239));
 }
}
