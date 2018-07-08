package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the location_master database table.
 * 
 */
@Entity
@Table(name="location_master")
@NamedQuery(name="LocationMaster.findAll", query="SELECT l FROM LocationMaster l")
public class LocationMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_MASTER_ID")
	private int locationMasterId;

	@Column(name="AIRPORT_NAME")
	private String airportName;

	private String code;

	private String country;

	private String name;

	//bi-directional many-to-one association to FlightMaster
	@OneToMany(mappedBy="locationMaster1")
	private List<FlightMaster> flightMasters1;

	//bi-directional many-to-one association to FlightMaster
	@OneToMany(mappedBy="locationMaster2")
	private List<FlightMaster> flightMasters2;

	public LocationMaster() {
	}

	public int getLocationMasterId() {
		return this.locationMasterId;
	}

	public void setLocationMasterId(int locationMasterId) {
		this.locationMasterId = locationMasterId;
	}

	public String getAirportName() {
		return this.airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FlightMaster> getFlightMasters1() {
		return this.flightMasters1;
	}

	public void setFlightMasters1(List<FlightMaster> flightMasters1) {
		this.flightMasters1 = flightMasters1;
	}

	public FlightMaster addFlightMasters1(FlightMaster flightMasters1) {
		getFlightMasters1().add(flightMasters1);
		flightMasters1.setLocationMaster1(this);

		return flightMasters1;
	}

	public FlightMaster removeFlightMasters1(FlightMaster flightMasters1) {
		getFlightMasters1().remove(flightMasters1);
		flightMasters1.setLocationMaster1(null);

		return flightMasters1;
	}

	public List<FlightMaster> getFlightMasters2() {
		return this.flightMasters2;
	}

	public void setFlightMasters2(List<FlightMaster> flightMasters2) {
		this.flightMasters2 = flightMasters2;
	}

	public FlightMaster addFlightMasters2(FlightMaster flightMasters2) {
		getFlightMasters2().add(flightMasters2);
		flightMasters2.setLocationMaster2(this);

		return flightMasters2;
	}

	public FlightMaster removeFlightMasters2(FlightMaster flightMasters2) {
		getFlightMasters2().remove(flightMasters2);
		flightMasters2.setLocationMaster2(null);

		return flightMasters2;
	}

}