package com.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.PersonDAO;
import com.dao.implementation.PersonImplementation;
import com.model.AddressDetail;
import com.model.LocationMaster;
import com.model.Person;
import com.service.UserService;
import com.service.UserServiceImplementation;

//@Controller  
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkLogin")  
    public ModelAndView checkLogin(HttpServletRequest request,HttpServletResponse response) {   
		String emailId=request.getParameter("email");  
	    String password=request.getParameter("password");
	    Boolean isUser = userService.checkLogin(emailId, password);
	    if(isUser) {	      	    
	    	String firstName = userService.getPerson(emailId).getFirstName();
	    	String lastName = userService.getPerson(emailId).getLastName();
	    	request.getSession().setAttribute("emailId", emailId);
	    	request.getSession().setAttribute("firstName", firstName);
	    	request.getSession().setAttribute("lastName", lastName);
	    	System.out.println("Session saved: "+firstName+" "+lastName);	
	        return new ModelAndView("homepage","message","Logged in successfully!"); 
	    }
	    else {	        
	    	String message="Please enter correct credentials";
        	return new ModelAndView("unsuccessfulLogin","message",message);
	    }
	}
	
	@RequestMapping("/register")  
    public ModelAndView register() {   
	        return new ModelAndView("register"); 
	}
	
	@RequestMapping("/login")  
    public ModelAndView login() {   		 
	        return new ModelAndView("login"); 
	}
	
	@RequestMapping(value="/registrationDetails",method=RequestMethod.POST)
	public ModelAndView registrationDetails(HttpServletRequest request,HttpServletResponse res) {
	        	Person person=new Person();	        
		        person.setPersonId(1234);
		        String emailId = request.getParameter("emailAddress");
		        person.setEmailAddress(emailId);
		        person.setFirstName(request.getParameter("firstName"));
		        person.setMiddleName(request.getParameter("middleName"));
		        person.setLastName(request.getParameter("lastName"));
		        person.setPassword(request.getParameter("password"));
		        person.setGender(request.getParameter("gender"));
		        person.setMobileNumber(Long.parseLong(request.getParameter("mobileNumber")));
		        person.setPassportNumber(request.getParameter("passportNumber"));
		        person.setDateOfBirth(java.sql.Date.valueOf(request.getParameter("dateOfBirth")));
	   		
	   		boolean ifUserExists=userService.checkIfUserExists(person.getEmailAddress());
	   		 if(ifUserExists)
	   		 {
	   			 userService.registerPerson(person);
	   			 System.out.println("User registered successfully");
	   			 return new ModelAndView("homepage"); 
	   		 }
	   		 else
	   		 {
	   			String message=emailId+" already exists";
	   			return new ModelAndView("unsuccessfulRegistration", "message",message); 
	   		 }  
	  }
	 
	 @RequestMapping("/logout")  
	 public ModelAndView logout(HttpServletRequest request,
			 HttpServletResponse response) {  
		 request.getSession().invalidate();
		 System.out.println("Logged out...");
	     return new ModelAndView("homepage");  
	 }
	 
	 @RequestMapping("/user")
	 public ModelAndView viewUserProfile(HttpServletRequest request,
			 HttpServletResponse response) {  
		 	String emailId = (String) request.getSession().getAttribute("emailId");
		 	Person person = userService.getPerson(emailId);
		 	return new ModelAndView("userProfile","person",person);
	 }
	 
	 @RequestMapping("/editUser")
	 public ModelAndView editUserProfile(HttpServletRequest request,
			 HttpServletResponse response) {   		 	
		 	String emailId = (String) request.getSession().getAttribute("emailId");
		 	Person person = userService.getPerson(emailId);		 
		 	return new ModelAndView("userProfileEdit","person",person);
	 }
	 
	 @RequestMapping(value="/addAddressDetails",method=RequestMethod.GET)
	 public ModelAndView addAddressDetails (HttpServletRequest request,
			 HttpServletResponse response) {       	
     	AddressDetail addressDetail=new AddressDetail();
     	addressDetail.setAddressId(3);
     	addressDetail.setType(request.getParameter("type"));
     	addressDetail.setLine1(request.getParameter("line1"));
     	addressDetail.setLine2(request.getParameter("line2"));
     	addressDetail.setLine3(request.getParameter("line3"));
     	addressDetail.setCity(request.getParameter("city"));
     	addressDetail.setPincode(Integer.parseInt(request.getParameter("pincode")));
     	addressDetail.setCountry(request.getParameter("country"));
     	String personEmailId = (String) request.getSession().getAttribute("emailId");
     	Person person = userService.getPerson(personEmailId);    
     	addressDetail.setPerson(person);
     	userService.addAddress(addressDetail);	         	
     	return new ModelAndView("userProfile","message","address added successfully");  
	}
	 
	 @RequestMapping("/bookingDetails")
	 public ModelAndView bookingDetails (HttpServletRequest request,HttpServletResponse response) {   		 	
	        return new ModelAndView("bookingdetails");  
	 }
	 
	 @RequestMapping("/cancelBooking")
	 public ModelAndView cancelBooking() {   			
	        return new ModelAndView("welcomepage");  
	    }
	 
	 @RequestMapping("/getHistory")
	 public ModelAndView getHistory() {   	
		 	
	        return new ModelAndView("welcomepage");  
	    }
	 
	 @RequestMapping("/homepage")  
	    public ModelAndView homepage() {   
		 List<LocationMaster> list=new ArrayList();
		 for(LocationMaster aa:list)
			{
				String name=aa.getAirportName()+"("+aa.getCode()+")";
				int id=aa.getLocationMasterId();
				System.out.println(id+" "+name);
			}
	        return new ModelAndView("homepage","total",list);  
	    } 
}
