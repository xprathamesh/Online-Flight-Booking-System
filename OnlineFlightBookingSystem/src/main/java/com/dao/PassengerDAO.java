package com.dao;

import java.util.List;

import com.model.Passenger;


public interface PassengerDAO {
		
	public boolean newPassenger(Passenger passenger);
	public List<Passenger> getPassenger(int bookingId);

}
