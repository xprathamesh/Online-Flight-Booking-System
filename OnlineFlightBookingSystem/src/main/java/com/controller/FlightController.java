package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.service.AdminService;
import com.service.AdminServiceImplementation;
import com.service.FlightService;
import com.service.FlightServiceImplementation;
import com.service.UserService;
import com.service.UserServiceImplementation;
import com.model.AddressDetail;
import com.model.FlightMaster;
import com.model.LocationMaster;

import java.util.ArrayList;
//@Controller
public class FlightController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private FlightService flightService=new FlightServiceImplementation();
	
	
	@RequestMapping("/flightResult")
	public ModelAndView flight(HttpServletRequest request,HttpServletResponse res)
	{
		ModelAndView model=new ModelAndView("flightResult");
		List<LocationMaster> list=new ArrayList();
		list=adminService.getAllLocationDetail();
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());
		for(LocationMaster aa:list)
		{
			String name=aa.getAirportName()+"("+aa.getCode()+")";
			int id=aa.getLocationMasterId();
			System.out.println(id+" "+name);
		}

		return new ModelAndView("flightResult","total",list);
	}
	@RequestMapping("/bookflight")
	public ModelAndView bookTicket(HttpServletRequest request,HttpServletResponse response)
	{
		String flightId=request.getParameter("flightId");
		int id=Integer.parseInt(flightId);
		FlightMaster f=flightService.getFlightForDisplay(id);
		//System.out.println(f.getFlightId()+" "+f.getRemainingBusinessSeats()+" ");
		System.out.println(request.getRequestURI());
		return new ModelAndView("ticketForm","flight",f);
	}
	
	@RequestMapping("/flightList")
	public ModelAndView flightList(HttpServletRequest request,HttpServletResponse response)
	{
		String source=request.getParameter("source"); 
		String destination=request.getParameter("destination");
		String date=request.getParameter("dateOfJourney");
		//String classType=request.getParameter("classType");
		//String s=request.getParameter("seat");
		//int seat=Integer.parseInt(s);
		int src=Integer.parseInt(source);
		int dst=Integer.parseInt(destination);
		java.sql.Date dt=java.sql.Date.valueOf(date);
		System.out.println(request.getRequestURI()+"?"+request.getQueryString());
		List<FlightMaster> list=flightService.getSearchDetails(src,dst,dt);
		for(FlightMaster f:list)
			System.out.println(f.getFlightId()+" "+f.getRemainingBusinessSeats()+" "+f.getArrivalTime());
		if(list.size()>0)
			return new ModelAndView("flightList","lists",list);
		else
			return new ModelAndView("noresult");
		
	}
}