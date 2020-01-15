package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AddressDAO;
import be.helha.aemt.entities.Address;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
@LocalBean
public class ManageAddressEJB{

	@EJB
	private AddressDAO dao;
	
	public List<Address> findAll(){
		return dao.findAll();
	}

	public void add(Address address) {
		dao.add(address);
	}

	public void update(Address newAddress) {
		dao.update(newAddress);
	}

	public void delete(Address toDel) {
		try {
			dao.delete(toDel);
		} catch (IDNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Address targetSelect(Address address)
	{
		return dao.targetSelect(address);
	}
}
