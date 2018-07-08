package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="BOOKING_ID")
	private int bookingId;

	@Column(name="BOOKING_DATE")
	private Timestamp bookingDate;

	@Column(name="BOOKING_NUMBER")
	private String bookingNumber;

	@Column(name="SEAT_CLASS")
	private String seatClass;

	@Column(name="SEATS_BOOKED")
	private int seatsBooked;

	@Column(name="TOTAL_COST")
	private int totalCost;

	@Temporal(TemporalType.DATE)
	@Column(name="TRAVEL_DATE")
	private Date travelDate;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="BOOKING_DONE_BY")
	private Person person;

	//bi-directional many-to-one association to FlightMaster
	@ManyToOne
	@JoinColumn(name="FLIGHT_MASTER_ID")
	private FlightMaster flightMaster;

	//bi-directional many-to-one association to Passenger
	@OneToMany(mappedBy="booking")
	private List<Passenger> passengers;

	public Booking() {
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Timestamp getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingNumber() {
		return this.bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public String getSeatClass() {
		return this.seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public int getSeatsBooked() {
		return this.seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public int getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public Date getTravelDate() {
		return this.travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public FlightMaster getFlightMaster() {
		return this.flightMaster;
	}

	public void setFlightMaster(FlightMaster flightMaster) {
		this.flightMaster = flightMaster;
	}

	public List<Passenger> getPassengers() {
		return this.passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Passenger addPassenger(Passenger passenger) {
		getPassengers().add(passenger);
		passenger.setBooking(this);

		return passenger;
	}

	public Passenger removePassenger(Passenger passenger) {
		getPassengers().remove(passenger);
		passenger.setBooking(null);

		return passenger;
	}

}