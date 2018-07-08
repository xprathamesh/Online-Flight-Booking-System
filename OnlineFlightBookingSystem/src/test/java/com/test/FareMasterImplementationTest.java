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
import com.dao.FareMasterDAO;
import com.dao.implementation.FareMasterImplementation;
import com.model.FareMaster;

public class FareMasterImplementationTest {

	private static ApplicationContext ctx;
	@Autowired
	private SessionFactory factory;
	@BeforeClass
	public static void fact(){
	
		ctx = new ClassPathXmlApplicationContext("mybeans.xml");
		System.out.println(ctx);
	}

	FareMasterDAO fareMasterDAO=ctx.getBean(FareMasterDAO.class);

	@Test
	public void testFare(){
		 FareMaster fareMaster = new FareMaster();
		 
	        fareMaster.setFareMasterId(12);
	        fareMaster.setEconomyClass(110);
	        fareMaster.setBusinessClass(300);
	        fareMaster.setPremiumClass(500);
	       
	        assertTrue(fareMasterDAO.newFare(fareMaster));
	}

	@Test
	public void testModifyFare(){
		 FareMaster fareMaster = new FareMaster();
	        fareMaster.setFareMasterId(12);
	        fareMaster.setEconomyClass(110);
	        fareMaster.setBusinessClass(300);
	        fareMaster.setPremiumClass(500);
	        
	        assertTrue(fareMasterDAO.modifyFare(fareMaster));
	}
	
	@Test
	public void testDeleteFare(){
	        
	        assertTrue(fareMasterDAO.deleteFare(12));
		
	}


}
