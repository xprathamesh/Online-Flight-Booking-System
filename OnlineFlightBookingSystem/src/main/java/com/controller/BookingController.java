package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Booking;
import com.model.FlightMaster;
import com.model.LocationMaster;
import com.model.Passenger;
import com.model.Person;
import com.service.AdminService;
import com.service.BookingService;
import com.service.FlightService;
import com.service.UserService;

//@Controller
public class BookingController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private FlightService flightService;
	@Autowired
	private UserService userService;
	
	List<Passenger> passengers=new ArrayList();
	Booking booking =new Booking();
	
	@RequestMapping("/bookTicket")
	public void flight(HttpServletRequest request,HttpServletResponse response)
	{
		
		//Passenger passenger=new Passenger();
		FlightMaster flightMaster=new FlightMaster();
		Passenger passenger=new Passenger();
		Person person=new Person();
		person.setPersonId(90001);
		String flightid=request.getParameter("flightId");
		String classType=request.getParameter("classType");
		System.out.println(flightid);
		String s=request.getParameter("seat");
		int seat=Integer.parseInt(s);
		int flightId=Integer.parseInt(flightid);
		flightMaster.setFlightId(flightId);
		booking.setBookingId(268943);
		booking.setSeatClass(classType);
		booking.setSeatsBooked(seat);
		booking.setTravelDate(flightMaster.getFlightTravelDate());
		booking.setBookingNumber("235454");
		int total=seat*flightService.getFare(flightId, classType);
		System.out.println(total);
		booking.setTotalCost(total);
		booking.setFlightMaster(flightMaster);
		for(int i=0;i<seat;i++)
		{
			String userName=request.getParameter("username"+i);
			String middleName=request.getParameter("middlename"+i);
			String lastName=request.getParameter("lastname"+i);
			String gender=request.getParameter("gender"+i);
			String mealPreferences=request.getParameter("meal"+i);
			String passengerType=request.getParameter("passengerType"+i);
			String age=request.getParameter("age"+i);
			String passportNumber=request.getParameter("passport"+i);
			
			passenger.setPassengerId(6000+1);
			passenger.setFirstName(userName);
			passenger.setMiddleName(middleName);
			passenger.setLastName(lastName);
			passenger.setGender(gender);
			passenger.setMealPreferences(mealPreferences);
			passenger.setPassengerType(passengerType);
			passenger.setPassportNumber(passportNumber);
			passenger.setAge(Integer.parseInt(age));
			passengers.add(passenger);
		}
		try
		{
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("modeSelect");
		requestDispatcher.include(request, response);
		}
		catch(Exception e)
		{}
	}
	@RequestMapping("modeSelect")
	public ModelAndView modeSelect(HttpServletRequest request,HttpServletResponse response)
	{
		return new ModelAndView("modeSelect");
	}
	
	@RequestMapping("payment")
	public ModelAndView pay(HttpServletRequest request,HttpServletResponse response)
	{
		return new ModelAndView("payment");
	}
	
	@RequestMapping("donePayment")
	public ModelAndView payed(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView model=new ModelAndView("donePayment");
		model.addObject("passenger",passengers);
		model.addObject("booking",booking);
		return model;
	}
	
	@RequestMapping("paymentFailure")
	public ModelAndView fail(HttpServletRequest request,HttpServletResponse response)
	{
		return new ModelAndView("modeSelect","msg","Payment Failed try again");
	}
	
	@RequestMapping("paymentPass")
	public ModelAndView succ(HttpServletRequest request,HttpServletResponse response)
	{

		if(bookingService.bookTicket(booking, passengers))
		{
			return new ModelAndView("successful","msg","from booking");
		}
		else
		{
			return new ModelAndView("unsuccessful");
		}
	}
}
