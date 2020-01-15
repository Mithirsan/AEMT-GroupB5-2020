package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageAddressEJB;
import be.helha.aemt.entities.Address;

@SessionScoped
@Named
public class AddressController implements Serializable{
	
	@EJB
	private ManageAddressEJB bean;
	
	public List<Address> doSelectAllAddressAsList(){
		return bean.findAll();
	}

}
