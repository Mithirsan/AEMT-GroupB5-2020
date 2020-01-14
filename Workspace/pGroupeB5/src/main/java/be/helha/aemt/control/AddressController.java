package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageAddressEJB;
import be.helha.aemt.entities.Address;

@SessionScoped
@Named
public class AddressController implements Serializable{
	
	private IManageAddressEJB bean;
	
	public List<Address> doSelectAllAddressAsList(){
		try {
			Context ctx = new InitialContext();
			bean = (IManageAddressEJB) ctx.lookup("java:global/pGroupeB5/ManageAddressEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
