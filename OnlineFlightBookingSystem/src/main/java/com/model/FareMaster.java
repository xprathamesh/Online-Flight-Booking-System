package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the fare_master database table.
 * 
 */
@Entity
@Table(name="fare_master")
@NamedQuery(name="FareMaster.findAll", query="SELECT f FROM FareMaster f")
public class FareMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FARE_MASTER_ID")
	private int fareMasterId;

	@Column(name="BUSINESS_CLASS")
	private int businessClass;

	@Column(name="ECONOMY_CLASS")
	private int economyClass;

	@Column(name="PREMIUM_CLASS")
	private int premiumClass;

	//bi-directional many-to-one association to FlightMaster
	@OneToMany(mappedBy="fareMaster")
	private List<FlightMaster> flightMasters;

	public FareMaster() {
	}

	public int getFareMasterId() {
		return this.fareMasterId;
	}

	public void setFareMasterId(int fareMasterId) {
		this.fareMasterId = fareMasterId;
	}

	public int getBusinessClass() {
		return this.businessClass;
	}

	public void setBusinessClass(int businessClass) {
		this.businessClass = businessClass;
	}

	public int getEconomyClass() {
		return this.economyClass;
	}

	public void setEconomyClass(int economyClass) {
		this.economyClass = economyClass;
	}

	public int getPremiumClass() {
		return this.premiumClass;
	}

	public void setPremiumClass(int premiumClass) {
		this.premiumClass = premiumClass;
	}

	public List<FlightMaster> getFlightMasters() {
		return this.flightMasters;
	}

	public void setFlightMasters(List<FlightMaster> flightMasters) {
		this.flightMasters = flightMasters;
	}

	public FlightMaster addFlightMaster(FlightMaster flightMaster) {
		getFlightMasters().add(flightMaster);
		flightMaster.setFareMaster(this);

		return flightMaster;
	}

	public FlightMaster removeFlightMaster(FlightMaster flightMaster) {
		getFlightMasters().remove(flightMaster);
		flightMaster.setFareMaster(null);

		return flightMaster;
	}

}