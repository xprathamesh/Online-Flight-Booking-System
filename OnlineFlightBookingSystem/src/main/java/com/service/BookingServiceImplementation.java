package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Booking;
import com.model.FlightMaster;
import com.model.Passenger;
import com.model.Person;
import com.service.BookingService;
import com.dao.*;
import com.dao.implementation.BookingImplementation;
import com.dao.implementation.FlightMasterImplementation;
import com.dao.implementation.PassengerImplementation;


//@Service("bookingService")
//@Transactional
public class BookingServiceImplementation implements BookingService {

	@Autowired
	private FlightMasterDAO flightMasterDAO=new FlightMasterImplementation();
	@Autowired
	private BookingDAO bookingDAO=new BookingImplementation();
	@Autowired
	private PassengerDAO passengerDAO=new PassengerImplementation();
	
	public boolean checkSeatAvailability(int flightId, int seatsRequired, String seatType) {
		FlightMaster f = flightMasterDAO.getFlight(flightId);
		if(f != null) {
			//economy class
			if(seatType.equals("Economy")){
				if(f.getRemainingEconomySeats() < seatsRequired)
					return false;
				else
					return true;
			}
			//business class
			if(seatType.equals("Business")){
				if(f.getRemainingBusinessSeats() < seatsRequired)
					return false;
				else
					return true;
			}
			//premium class
			if(seatType.equals("Premium")){
				if(f.getRemainingPremiumSeats() < seatsRequired)
					return false;
				else
					return true;
			}
		}
		//if null
		return false;
	}

	
	public boolean bookTicket(Booking booking, List<Passenger> passengers) {
//		System.out.println("Booking details from service "+booking.getBookingNumber()+" "+booking.getSeatsBooked());
		
		if(updateSeat(booking.getFlightMaster().getFlightId(), booking.getSeatsBooked(), booking.getSeatClass()))
		{
			for(Passenger p: passengers){
				if(!passengerDAO.newPassenger(p))
					return false;
				}
			if(!bookingDAO.newBooking(booking))
				return false;

			return true;
		}
		else
			return false;
		
	}

	
	public boolean updateSeat(int flightMasterId, int seats, String classType) {
		FlightMaster f = flightMasterDAO.getFlight(flightMasterId);
		if(f != null) {
			//economy class
			if(classType.equals("Economy"))
				f.setRemainingEconomySeats(f.getRemainingEconomySeats() - seats);
			//business class
			if(classType.equals("Business"))
				f.setRemainingBusinessSeats(f.getRemainingBusinessSeats() - seats);
			//premium class
			if(classType.equals("Premium"))
				f.setRemainingPremiumSeats(f.getRemainingPremiumSeats() - seats);
			//update seats in flight
			flightMasterDAO.updateRemainingSeats(f);
			return true;
		}
		//if null
		return false;
	}

	
	public boolean cancelTicket(int bookingId) {
		Booking booking = bookingDAO.getBooking(bookingId);
		FlightMaster flightMaster = flightMasterDAO.getFlight(booking.getFlightMaster().getFlightId());
		//update seats
		if(bookingDAO.getBooking(bookingId) != null){
			if(flightMaster != null) {
				String classType = booking.getSeatClass();
				int seats = booking.getSeatsBooked();
				if(classType.equals("Economy"))
					flightMaster.setRemainingEconomySeats(flightMaster.getRemainingEconomySeats() + seats);
				//business class
				if(classType.equals("Business"))
					flightMaster.setRemainingBusinessSeats(flightMaster.getRemainingBusinessSeats() + seats);
				//premium class
				if(classType.equals("Premium"))
					flightMaster.setRemainingPremiumSeats(flightMaster.getRemainingPremiumSeats() + seats);
				//update seats in flight
				flightMasterDAO.updateRemainingSeats(flightMaster);
			}
			bookingDAO.deleteBooking(bookingId);
			return true;
		}
		return false;
	}

}