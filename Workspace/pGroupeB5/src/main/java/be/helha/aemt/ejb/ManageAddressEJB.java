package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AddressDAO;
import be.helha.aemt.entities.Address;

@Stateless
public class ManageAddressEJB {

	@EJB
	private AddressDAO dao;
	
	public List<Address> findAll(){
		return dao.findAll();
	}
}
