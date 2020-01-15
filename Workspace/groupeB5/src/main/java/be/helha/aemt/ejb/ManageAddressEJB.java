package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AddressDAO;
import be.helha.aemt.entities.Address;
import be.helha.aemt.exception.AddDuplicateException;

@Stateless
@LocalBean
public class ManageAddressEJB{

	@EJB
	private AddressDAO dao;
	
	public List<Address> findAll(){
		return dao.findAll();
	}

	public void add(Address address) {
		try {
			dao.add(address);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Object targetSelect(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Address newAddress) {
		dao.update(newAddress);
	}

	public void delete(Address toDel) {
		dao.delete(toDel);
	}
}
