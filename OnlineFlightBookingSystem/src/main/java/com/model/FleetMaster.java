package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the fleet_master database table.
 * 
 */
@Entity
@Table(name="fleet_master")
@NamedQuery(name="FleetMaster.findAll", query="SELECT f FROM FleetMaster f")
public class FleetMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FLEET_MASTER_ID")
	private int fleetMasterId;

	private String code;

	private String model;

	@Column(name="TOTAL_BUSINESS_SEATS")
	private int totalBusinessSeats;

	@Column(name="TOTAL_ECONOMY_SEATS")
	private int totalEconomySeats;

	@Column(name="TOTAL_PREMIUM_SEATS")
	private int totalPremiumSeats;

	//bi-directional many-to-one association to FlightMaster
	@OneToMany(mappedBy="fleetMaster")
	private List<FlightMaster> flightMasters;

	public FleetMaster() {
	}

	public int getFleetMasterId() {
		return this.fleetMasterId;
	}

	public void setFleetMasterId(int fleetMasterId) {
		this.fleetMasterId = fleetMasterId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTotalBusinessSeats() {
		return this.totalBusinessSeats;
	}

	public void setTotalBusinessSeats(int totalBusinessSeats) {
		this.totalBusinessSeats = totalBusinessSeats;
	}

	public int getTotalEconomySeats() {
		return this.totalEconomySeats;
	}

	public void setTotalEconomySeats(int totalEconomySeats) {
		this.totalEconomySeats = totalEconomySeats;
	}

	public int getTotalPremiumSeats() {
		return this.totalPremiumSeats;
	}

	public void setTotalPremiumSeats(int totalPremiumSeats) {
		this.totalPremiumSeats = totalPremiumSeats;
	}

	public List<FlightMaster> getFlightMasters() {
		return this.flightMasters;
	}

	public void setFlightMasters(List<FlightMaster> flightMasters) {
		this.flightMasters = flightMasters;
	}

	public FlightMaster addFlightMaster(FlightMaster flightMaster) {
		getFlightMasters().add(flightMaster);
		flightMaster.setFleetMaster(this);

		return flightMaster;
	}

	public FlightMaster removeFlightMaster(FlightMaster flightMaster) {
		getFlightMasters().remove(flightMaster);
		flightMaster.setFleetMaster(null);

		return flightMaster;
	}

}