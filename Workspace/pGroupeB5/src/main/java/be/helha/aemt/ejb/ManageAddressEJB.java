package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AddressDAO;
import be.helha.aemt.entities.Address;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
public class ManageAddressEJB implements IManageAddressEJB{

	@EJB
	private AddressDAO dao;
	
	public List<Address> findAll(){
		return dao.findAll();
	}

	@Override
	public void add(Address address) {
		dao.add(address);
	}

	@Override
	public void update(Address newAddress) {
		dao.update(newAddress);
	}

	@Override
	public void delete(Address toDel) {
		try {
			dao.delete(toDel);
		} catch (IDNotFoundException e) {
			e.printStackTrace();
		}
	}
}
