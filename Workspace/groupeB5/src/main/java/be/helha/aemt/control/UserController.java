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

import be.helha.aemt.dao.UserDAO;
import be.helha.aemt.ejb.ManageUserEJB;
import be.helha.aemt.entities.User;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@SessionScoped
@Named
public class UserController implements Serializable{
	
	private User user;

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}

	public UserController() {
		// TODO Auto-generated constructor stub
		user = new User();
	}

	@EJB
	private ManageUserEJB bean;
	
	public List<User> doSelectAllUserAsList() {
		return bean.findAll();
	}
	
	public void doAddUser() {
		bean.add(this.user);
		user = new User();
	}
	
	public void doUpdateUSer(User newUser) {
		bean.update(newUser);
	}

}
