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
import com.dao.LocationMasterDAO;
import com.dao.implementation.AddressDetailsImplementation;
import com.model.AddressDetail;

public class AddressDetailsImplementationTest {

	private static ApplicationContext ctx;
	@Autowired
	private SessionFactory factory;
	@BeforeClass
	public static void fact(){
	
		ctx = new ClassPathXmlApplicationContext("mybeans.xml");
		System.out.println(ctx);
	}

	AddressDetailsDAO addressDetailsDAO=ctx.getBean(AddressDetailsDAO.class);
	@Test
	public void testAddressInsert()
	{
		AddressDetail addressDetail=new AddressDetail();
		addressDetail.setAddressId(1236);
		addressDetail.setLine1("Yoo");
		addressDetail.setLine2("second line DOne");
		addressDetail.setLine3("line 3");
		addressDetail.setType("office");
		addressDetail.setCountry("India");
		addressDetail.setPincode(400037);
		addressDetail.setCity("Mumbai");
		
		assertTrue(addressDetailsDAO.addNewAddress(addressDetail));
	}
	
	@Test
	public void testModifyAddressInsert()
	{
		AddressDetail addressDetail=new AddressDetail();
		addressDetail.setAddressId(1236);
		addressDetail.setLine1("fedfedfXXX");
		addressDetail.setLine2("second line DOne");
		addressDetail.setLine3("line 3");
		addressDetail.setType("office");
		addressDetail.setCountry("India");
		addressDetail.setPincode(400037);
		addressDetail.setCity("Mumbai");
		
		assertTrue(addressDetailsDAO.modifyAddress(addressDetail));
	}
	
	@Test
	public void testDeleteAddress(){
	//	AddressDetail addressDetail=new AddressDetail();
		
		assertTrue(addressDetailsDAO.deleteAddress(1236));

	}
	

}
