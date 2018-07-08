package com.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the address_details database table.
 * 
 */
@Entity
@Table(name="address_details")
@NamedQuery(name="AddressDetail.findAll", query="SELECT a FROM AddressDetail a")
public class AddressDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ADDRESS_ID")
	private int addressId;

	private String city;

	private String country;

	@Column(name="LINE_1")
	private String line1;

	@Column(name="LINE_2")
	private String line2;

	@Column(name="LINE_3")
	private String line3;

	private int pincode;

	private String type;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_DETAILS")
	private Person person;

	public AddressDetail() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLine1() {
		return this.line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return this.line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return this.line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public int getPincode() {
		return this.pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}