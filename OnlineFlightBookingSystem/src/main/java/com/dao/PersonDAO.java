package com.dao;


import com.model.Person;

public interface PersonDAO {
	

	public boolean addPerson(Person person);
	public boolean modifyPersonDetails(Person person);
	public Person getUser(String emailAddress);
	public boolean deletePerson(String emailAddress);

}
