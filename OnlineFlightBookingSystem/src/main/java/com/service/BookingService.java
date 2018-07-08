package com.service;
import java.util.List;

import com.model.Booking;
import com.model.Passenger;

public interface BookingService {
	
	public boolean checkSeatAvailability(int flightId, int seatsRequired, String classType);
	public boolean bookTicket(Booking booking,List<Passenger> passengers);
	public boolean cancelTicket(int bookingId);
	public boolean updateSeat(int flightMasterId,int seat,String classType);
}