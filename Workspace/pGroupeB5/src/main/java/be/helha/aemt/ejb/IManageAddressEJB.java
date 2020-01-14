package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Address;

@Remote
public interface IManageAddressEJB {

	public List<Address> findAll();
	
	public void add(Address address);
	
	public void update(Address newAddress);
	
	public void delete(Address toDel);
}
