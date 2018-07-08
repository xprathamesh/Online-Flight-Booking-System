package com.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.*;
import com.dao.implementation.*;
import com.model.FareMaster;
import com.model.FlightMaster;
import com.model.LocationMaster;
import com.service.FlightService;

//@Service("flightService")
//@Transactional
public class FlightServiceImplementation implements FlightService {
	@Autowired
	private FlightMasterDAO flightMasterDAO=new FlightMasterImplementation();
	@Autowired
	private LocationMasterDAO locationMasterDAO=new LocationMasterImplementation();
	@Autowired
	private FareMasterDAO fareMasterDAO=new FareMasterImplementation();
	
	public List<FlightMaster> getSearchDetails(int sourceId, int destinationId, Date date) {
		//get locations
		LocationMaster source = locationMasterDAO.getLocation(sourceId);
		LocationMaster destination = locationMasterDAO.getLocation(destinationId);
		//get all available flights
		List<FlightMaster> flights = flightMasterDAO.searchFlight(source, destination, (java.sql.Date) date);
		return flights;
	}

	
	public List<FlightMaster> getSearchDetails(int sourceId, int destinationId, Date date, String classType) {
		//get all available flights
		List<FlightMaster> flights = getSearchDetails(sourceId, destinationId, date);
		//get all required flights
		List<FlightMaster> requiredFlights = new ArrayList<FlightMaster>();
		for(FlightMaster f: flights){
			if(f.getClass().equals(classType))
				requiredFlights.add(f);
		}
		return requiredFlights;
	}
	
	
	public List<FlightMaster> getSearchDetails(int sourceId, int destinationId, Date date, int seatsRequired,
			String classType) {
		List<FlightMaster> flights = getSearchDetails(sourceId, destinationId, date);
		List<FlightMaster> requiredFlights = new ArrayList<FlightMaster>();
		for(FlightMaster f: flights){
			//check seat type
			int seats = 0;
			if(classType.equals("Economy"))
				seats = f.getRemainingEconomySeats();
			if(classType.equals("Business"))
				seats = f.getRemainingBusinessSeats();
			if(classType.equals("Premium"))
				seats = f.getRemainingPremiumSeats();
			//check seats
			if(seatsRequired < seats)
				requiredFlights.add(f);
		}
		return requiredFlights;
	}

	
	public TreeMap<Integer,FlightMaster> filterByPrice(List<FlightMaster> flights, String type) {
        FareMaster fareMaster;
        TreeMap<Integer,FlightMaster> flightMap = new TreeMap<Integer,FlightMaster>();
        for(FlightMaster flight : flights)
        {
            fareMaster = fareMasterDAO.getFare(flight.getFareMaster().getFareMasterId());
            if(type.equalsIgnoreCase("Business"))
            {
            	flightMap.put(fareMaster.getBusinessClass(), flight);
            }
            else if(type.equalsIgnoreCase("Economy"))
            {
            	flightMap.put(fareMaster.getEconomyClass(), flight);
            }
            else
            {
            	flightMap.put(fareMaster.getPremiumClass(), flight);
            }
        }
        return flightMap;
	}
	
	public FlightMaster getFlightForDisplay(int flightMasterId) {
		return flightMasterDAO.getFlight(flightMasterId);
	}

	public int getFare(int flightMasterId,String classType)
	{
		FlightMaster flightMaster=flightMasterDAO.getFlight(flightMasterId);
		if(classType.equalsIgnoreCase("economy"))
			return flightMaster.getFareMaster().getEconomyClass();
		else if(classType.equalsIgnoreCase("premium"))
			return flightMaster.getFareMaster().getPremiumClass();
		else
			return flightMaster.getFareMaster().getBusinessClass();
	}

}