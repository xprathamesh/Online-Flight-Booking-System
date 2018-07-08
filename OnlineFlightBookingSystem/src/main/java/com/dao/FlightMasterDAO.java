package com.dao;

import java.util.List;

import com.model.FlightMaster;
import com.model.LocationMaster;

public interface FlightMasterDAO {
	
	public boolean newFlight(FlightMaster flightMaster);
	public List<FlightMaster> searchFlight(LocationMaster locationMaster,LocationMaster locationMaster2,java.sql.Date travelDate);
	public boolean updateRemainingSeats(FlightMaster flightMaster);
	public List<FlightMaster> getAll();
	public FlightMaster getFlight(int flightId);
}
