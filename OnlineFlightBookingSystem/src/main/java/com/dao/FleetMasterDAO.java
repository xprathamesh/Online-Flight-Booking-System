package com.dao;

import java.util.List;

import com.model.FleetMaster;

public interface FleetMasterDAO {

	public boolean createFleet(FleetMaster fleetMaster);
	public boolean modifyFleet(FleetMaster fleetMaster);
	public boolean deleteFleet(int fleetId);
	public FleetMaster getFleet(int fleetId);
	public List<FleetMaster> getAllFleet();
}
