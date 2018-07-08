package com.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the passenger database table.
 * 
 */
@Entity
@NamedQuery(name="Passenger.findAll", query="SELECT p FROM Passenger p")
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PASSENGER_ID")
	private int passengerId;

	private int age;

	@Column(name="FIRST_NAME")
	private String firstName;

	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MEAL_PREFERENCES")
	private String mealPreferences;

	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="PASSENGER_TYPE")
	private String passengerType;

	@Column(name="PASSPORT_NUMBER")
	private String passportNumber;

	//bi-directional many-to-one association to Booking
	@ManyToOne
	@JoinColumn(name="BOOKING_ID")
	private Booking booking;

	public Passenger() {
	}

	public int getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMealPreferences() {
		return this.mealPreferences;
	}

	public void setMealPreferences(String mealPreferences) {
		this.mealPreferences = mealPreferences;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassengerType() {
		return this.passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Booking getBooking() {
		return this.booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}