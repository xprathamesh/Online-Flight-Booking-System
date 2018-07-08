package com.dao;

import java.util.List;

import com.model.FareMaster;

public interface FareMasterDAO {
	
	public boolean newFare(FareMaster fareMaster);
	public boolean modifyFare(FareMaster fareMaster);
	public boolean deleteFare(int fareId);
	public FareMaster getFare(int fareMasterId);
	public List<FareMaster> getAllFareList();

}
