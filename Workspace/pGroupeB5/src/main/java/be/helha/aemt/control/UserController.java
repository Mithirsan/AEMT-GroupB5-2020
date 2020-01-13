package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.ManageUserEJB;
import be.helha.aemt.entities.User;

@SessionScoped
@Named
public class UserController implements Serializable{
	
	@EJB
	private  ManageUserEJB bean;
	
	public List<User> doSelectAllUserAsList() {
		Context ctx;
		try {
			ctx = new InitialContext();
			bean = (ManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public void doAddUser(User user) {
		Context ctx;
		try {
			ctx = new InitialContext();
			bean = (ManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			bean.addUser(user);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
