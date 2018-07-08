package com.dao;

import java.util.List;

import com.model.LocationMaster;

public interface LocationMasterDAO {
	
	public boolean createLocation(LocationMaster locationMaster);
	public boolean updateLocation(LocationMaster locationMaster);
	public boolean deleteLocation(int locationId);
	public LocationMaster getLocation(int locationMasterId);
	public List<LocationMaster> getAllLocation();

}
