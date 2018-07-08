package com.dao;
import java.util.List;

import com.model.*;
public interface AddressDetailsDAO {
	
	
	public boolean modifyAddress(AddressDetail addressDetail);
	public boolean addNewAddress(AddressDetail addressDetail);
	public List<AddressDetail> getAddressList(int personId);
	public boolean deleteAddress(int addressId);
}
