package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.*;
import com.dao.implementation.FareMasterImplementation;
import com.dao.implementation.FleetMasterImplementation;
import com.dao.implementation.FlightMasterImplementation;
import com.dao.implementation.LocationMasterImplementation;
import com.service.AdminService;
import com.model.FareMaster;
import com.model.FleetMaster;
import com.model.FlightMaster;
import com.model.LocationMaster;

//@Service("adminService")
//@Transactional
public class AdminServiceImplementation implements AdminService{
	@Autowired
	private FlightMasterDAO flightMasterDAO=new FlightMasterImplementation();
	@Autowired
	private FleetMasterDAO fleetMasterDAO=new FleetMasterImplementation();
	@Autowired
	private FareMasterDAO fareMasterDAO=new FareMasterImplementation();
	@Autowired
	private LocationMasterDAO locationMasterDAO=new LocationMasterImplementation();
	
	public boolean addFleet(FleetMaster fleetMaster) {
		return fleetMasterDAO.createFleet(fleetMaster);
	}

	
	public boolean modifyFleet(FleetMaster fleetMaster) {
		return fleetMasterDAO.modifyFleet(fleetMaster);
	}

	
	public boolean deleteFleet(int fleetId) {
		return fleetMasterDAO.deleteFleet(fleetId);
	}

	
	public List<FleetMaster> getAllFleetDetail() {
		return fleetMasterDAO.getAllFleet();
	}

	
	public boolean addFare(FareMaster fareMaster) {	
		return fareMasterDAO.newFare(fareMaster);
	}

	
	public boolean modifyFare(FareMaster fareMaster) {	
		return fareMasterDAO.modifyFare(fareMaster);
	}

	
	public boolean deleteFare(int fareId) {
		return fareMasterDAO.deleteFare(fareId);
	}

	
	public List<FareMaster> getAllFareDetail(FareMaster fareMaster) {	
		return fareMasterDAO.getAllFareList();
	}

	
	public boolean addLocation(LocationMaster locationMaster) {
		return locationMasterDAO.createLocation(locationMaster);
	}

	
	public boolean modifyLocation(LocationMaster locationMaster) {
		return locationMasterDAO.updateLocation(locationMaster);
	}

	
	public boolean deleteLocation(int locationId) {
		return locationMasterDAO.deleteLocation(locationId);
	}

	
	public List<LocationMaster> getAllLocationDetail() {
		List<LocationMaster> list=locationMasterDAO.getAllLocation();
		return list;
	}

	
	public boolean addFlight(FlightMaster flightMaster) {
	 return flightMasterDAO.newFlight(flightMaster) ;
	}

	
	public boolean deleteFlight(FlightMaster flightMaster) {
		return flightMasterDAO.updateRemainingSeats(flightMaster);
	}

	public List<FlightMaster> getAllFlightDetail() {
        return flightMasterDAO.getAll();
	}
	

}
