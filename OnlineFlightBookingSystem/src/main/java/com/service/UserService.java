package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.AddressDetail;
import com.model.Person;

	public interface UserService {
		
		public boolean checkLogin(String emailId,String password);
		public boolean checkIfUserExists(String emailId);
		//public boolean verifyEmail(String emailId);
		public List<HashMap<String,String>> getHistory(int personId);
		//public List<AddressDetail> getAllAddress(int personId);
		public boolean registerPerson(Person person);
		public boolean modifyUser(Person person);
		public boolean addAddress(AddressDetail addressDetail);
		//public boolean modifyAddress(AddressDetail addressDetail);
		public boolean resetPassword(String emailAddress,String newPassword);
		public Person getPerson(String emailId);

	}