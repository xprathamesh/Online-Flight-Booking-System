package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the flight_master database table.
 * 
 */
@Entity
@Table(name="flight_master")
@NamedQuery(name="FlightMaster.findAll", query="SELECT f FROM FlightMaster f")
public class FlightMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name="FLIGHT_ID")
	private int flightId;

	@Column(name="ARRIVAL_TIME")
	private Time arrivalTime;

	@Column(name="DEPARTURE_TIME")
	private Time departureTime;

	@Temporal(TemporalType.DATE)
	@Column(name="FLIGHT_TRAVEL_DATE")
	private Date flightTravelDate;

	@Column(name="REMAINING_BUSINESS_SEATS")
	private int remainingBusinessSeats;

	@Column(name="REMAINING_ECONOMY_SEATS")
	private int remainingEconomySeats;

	@Column(name="REMAINING_PREMIUM_SEATS")
	private int remainingPremiumSeats;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="flightMaster")
	private List<Booking> bookings;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="DEPARTURE_LOC")
	private LocationMaster locationMaster1;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="ARRIVAL_LOC")
	private LocationMaster locationMaster2;

	//bi-directional many-to-one association to FleetMaster
	@ManyToOne
	@JoinColumn(name="FLEET")
	private FleetMaster fleetMaster;

	//bi-directional many-to-one association to FareMaster
	@ManyToOne
	@JoinColumn(name="FARE")
	private FareMaster fareMaster;

	public FlightMaster() {
	}

	public int getFlightId() {
		return this.flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Time getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Time getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Date getFlightTravelDate() {
		return this.flightTravelDate;
	}

	public void setFlightTravelDate(Date flightTravelDate) {
		this.flightTravelDate = flightTravelDate;
	}

	public int getRemainingBusinessSeats() {
		return this.remainingBusinessSeats;
	}

	public void setRemainingBusinessSeats(int remainingBusinessSeats) {
		this.remainingBusinessSeats = remainingBusinessSeats;
	}

	public int getRemainingEconomySeats() {
		return this.remainingEconomySeats;
	}

	public void setRemainingEconomySeats(int remainingEconomySeats) {
		this.remainingEconomySeats = remainingEconomySeats;
	}

	public int getRemainingPremiumSeats() {
		return this.remainingPremiumSeats;
	}

	public void setRemainingPremiumSeats(int remainingPremiumSeats) {
		this.remainingPremiumSeats = remainingPremiumSeats;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setFlightMaster(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setFlightMaster(null);

		return booking;
	}

	public LocationMaster getLocationMaster1() {
		return this.locationMaster1;
	}

	public void setLocationMaster1(LocationMaster locationMaster1) {
		this.locationMaster1 = locationMaster1;
	}

	public LocationMaster getLocationMaster2() {
		return this.locationMaster2;
	}

	public void setLocationMaster2(LocationMaster locationMaster2) {
		this.locationMaster2 = locationMaster2;
	}

	public FleetMaster getFleetMaster() {
		return this.fleetMaster;
	}

	public void setFleetMaster(FleetMaster fleetMaster) {
		this.fleetMaster = fleetMaster;
	}

	public FareMaster getFareMaster() {
		return this.fareMaster;
	}

	public void setFareMaster(FareMaster fareMaster) {
		this.fareMaster = fareMaster;
	}

}