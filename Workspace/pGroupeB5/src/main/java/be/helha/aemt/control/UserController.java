package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageUserEJB;
import be.helha.aemt.entities.User;

public class UserController implements Serializable{
	
	private IManageUserEJB bean;
	
	public List<User> doSelectAllUserAsList() {
		Context ctx;
		try {
			ctx = new InitialContext();
			bean = (IManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

}
