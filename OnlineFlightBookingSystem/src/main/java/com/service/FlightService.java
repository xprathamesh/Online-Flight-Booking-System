package com.service;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import com.model.FlightMaster;

public interface FlightService {
	
	public List<FlightMaster> getSearchDetails(int sourceId, int destinationId,Date date , int seatsRequired, String classType);
	public List<FlightMaster> getSearchDetails(int sourceId,int destinationId,Date date);
	public List<FlightMaster> getSearchDetails(int sourceId,int destinationId,Date date,String classType);
	public TreeMap<Integer, FlightMaster> filterByPrice(List<FlightMaster> flightMaster, String type);
	public FlightMaster getFlightForDisplay(int flightMasterId);
	public int getFare(int flightMasterId,String classType);
}