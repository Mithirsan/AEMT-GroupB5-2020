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
	
	
	public Address targetSelect(Address address)
	{
		return dao.targetSelect(address);
	}
}
