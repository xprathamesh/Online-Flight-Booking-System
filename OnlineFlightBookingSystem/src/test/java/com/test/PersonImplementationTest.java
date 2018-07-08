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
import com.dao.PersonDAO;
import com.dao.implementation.AddressDetailsImplementation;
import com.dao.implementation.PersonImplementation;
import com.model.Person;

public class PersonImplementationTest {
	private static ApplicationContext ctx;
	@Autowired
	private SessionFactory factory;
	@BeforeClass
	public static void fact(){
	
		ctx = new ClassPathXmlApplicationContext("mybeans.xml");
		System.out.println(ctx);
	}

	PersonDAO personDAO=ctx.getBean(PersonDAO.class);
	@Test
	public void testPerson(){
		Person per = new Person();
		per.setPersonId(1003);
		per.setPassword("qwe");
		per.setEmailAddress("pqr@gmail.com");
	    per.setFirstName("sunil");
	    per.setMiddleName("singh");
	    per.setLastName("abc");
	    per.setGender("M");
	    per.setTitle("Mr.");
	    per.setDateOfBirth(null);
	    per.setPassportNumber("jkl12345");
		per.setMobileNumber(8652373976l);
	    
	    assertTrue(personDAO.addPerson(per));
	}
	
	/*@Test
	public void testModifyPerson(){
		Person per = new Person();
		per.setPersonId(1003);
		per.setPassword("qwe");
		per.setEmailAddress("pqr@gmail.com");
	    per.setFirstName("shreyas");
	    per.setMiddleName("singh");
	    per.setLastName("abc");
	    per.setGender("M");
	    per.setTitle("Mr.");
	    per.setDateOfBirth(null);
	    per.setPassportNumber("jkl12345");
		per.setMobileNumber(8652373976l);
	    
	    assertTrue(personDAO.modifyPersonDetails(per));
	}*/
	
	@Test
	public void testDeletePerson(){	    
	    assertTrue(personDAO.deletePerson("pqr@gmail.com"));
	}
	
}
