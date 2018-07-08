package com.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AddressDetailsDAO;
import com.dao.PersonDAO;
import com.dao.implementation.AddressDetailsImplementation;
import com.dao.implementation.PersonImplementation;
import com.model.AddressDetail;
import com.model.Person;
import com.utility.HashPassword;

//@Service("userService")
//@Transactional
public class UserServiceImplementation implements UserService{
	@Autowired
	private PersonDAO personDAO=new PersonImplementation();
	@Autowired
	private AddressDetailsDAO addressDetailsDAO=new AddressDetailsImplementation();

	public boolean checkLogin(String emailId, String password) {
		
		Person person = personDAO.getUser(emailId);
		if(person!=null)
		{
			String userPass=person.getPassword();
			//if(userPass.equals(HashPassword.generateHash(password)))
			if(userPass.equals(password))
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public boolean checkIfUserExists(String emailId) {
		Person person = personDAO.getUser(emailId);
		if (person != null)
			return false;
		else
			return true;
	}

	/*public boolean verifyEmail(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}*/

	public List<HashMap<String, String>> getHistory(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean registerPerson(Person person) {
		// TODO Auto-generated method stub
		personDAO.addPerson(person);
		System.out.println("yoyo");		
		return false;
	}

	public boolean modifyUser(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean resetPassword(String emailAddress, String newPassword) {
		Person person = personDAO.getUser(emailAddress);
		if(person!=null)
		{
			person.setPassword(HashPassword.generateHash(newPassword));
			return personDAO.modifyPersonDetails(person);
		}
		else 
			return false;
	}
	
	public Person getPerson(String emailId) {
		return personDAO.getUser(emailId);
	}
	
	public boolean addAddress(AddressDetail addressDetail) {
		// TODO Auto-generated method stub
		addressDetailsDAO.addNewAddress(addressDetail);
		return false;
	}

	/*public List<HashMap<String, String>> getHistory(int personId) {
		HashMap<String, String> hash = new HashMap<String, String>();
		List<HashMap<String, String>> userAllHistory = new ArrayList<HashMap<String, String>>();
		List<Booking> allBooking = bookingImplementation.getBookedDetails(personId);
		for (Booking booking : allBooking) {
			List<Passenger> passengers = new ArrayList<Passenger>();
			FlightMaster flightMaster = booking.getFlightMaster();
			LocationMaster source = flightMaster.getLocationMaster1();
			LocationMaster destination = flightMaster.getLocationMaster2();
			hash.put("Booking Number", booking.getBookingNumber());
			hash.put("Source", source.getCode());
			hash.put("Source Name", source.getAirportName());
			hash.put("Destination", destination.getCode());
			hash.put("Destiantion Name", destination.getAirportName());
			hash.put("Date", String.valueOf(flightMaster.getFlightTravelDate()));
			hash.put("Departure Time", flightMaster.getDepartureTime()
					.toString());
			hash.put("Arrival Time", flightMaster.getArrivalTime().toString());
			hash.put("Total Cost", String.valueOf(booking.getTotalCost()));
			hash.put("Seat ", String.valueOf(booking.getSeatsBooked()));
			hash.put("Class ", booking.getSeatClass());
			for (Passenger passenger : passengers) {
				hash.put("Passenger Detail", passenger.getFirstName() + " "
						+ passenger.getLastName() + " " + passenger.getAge()
						+ " " + passenger.getGender() + "");
			}
			userAllHistory.add(hash);
		}
		return userAllHistory;
	}

	public List<AddressDetail> getAllAddress(int personId) {
		List<AddressDetail> addetails = addressDetailsImplementation.getAddressList(personId);
		return addetails;
	}

	public boolean registerPerson(Person person) {
		return personImplementation.addPerson(person);

	}

	public boolean modifyUser(Person person) {
		return personImplementation.modifyPersonDetails(person);
	}

	public boolean addAddress(AddressDetail addressDetail) {
		return addressDetailsImplementation.addNewAddress(addressDetail);
	}

	public boolean modifyAddress(AddressDetail addressDetail) {
		return addressDetailsImplementation.modifyAddress(addressDetail);

	}

	public boolean forgotPassword(String emailAddress, String newPassword) {
		Person person = personImplementation.getUser(emailAddress);
		if (person != null) {
			person.setPassword(newPassword);
			return personImplementation.modifyPersonDetails(person);
		} else
			return false;
	}

	public boolean forgotPassword(String emailAddress) {
		// TODO Auto-generated method stub
		return false;
	}*/

}