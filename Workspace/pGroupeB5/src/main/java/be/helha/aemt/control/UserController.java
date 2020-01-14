package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageUserEJB;
import be.helha.aemt.ejb.ManageUserEJB;
import be.helha.aemt.entities.User;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@SessionScoped
@Named
public class UserController implements Serializable{
	
	private User user;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserController() {
		// TODO Auto-generated constructor stub
		user = new User();
	}

	public IManageUserEJB getBean() {
		return bean;
	}

	public void setBean(IManageUserEJB bean) {
		this.bean = bean;
	}

	private IManageUserEJB bean;
	
	public List<User> doSelectAllUserAsList() {
		try {
			Context ctx = new InitialContext();
			bean = (IManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public void doAddUser() {
		try {
			Context ctx = new InitialContext();
			bean = (IManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			bean.add(this.user);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doUpdateUSer(User newUser) {
		Context ctx;
		try {
			ctx = new InitialContext();
			bean = (IManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			bean.update(newUser, newUser);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
