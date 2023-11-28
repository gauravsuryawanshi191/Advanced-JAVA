package dao;

import pojos.Address;

public interface AddressDao {
	Address addNewAddress(Address address, Long empId);
}
