package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageUserEJB;
import be.helha.aemt.entities.User;

@SessionScoped
@Named
public class UserController implements Serializable{
	
	private User user;
	@EJB
	private ManageUserEJB bean;

	public UserController() {
		user = new User();
	}
	
	public List<User> doSelectAllUserAsList() {
		return bean.findAll();
	}
	
	public List<User> doSelectUnvalidUser(){
		return bean.findUnvalid();
	}
	
	public List<User> doSelectValidNonAdminUser(){
		return bean.findValidNoAdmin();
	}
	
	public void doAddUser() {
		bean.add(this.user);
		user = new User();
	}
	
	public void doUpdateUser(User newUser) {
		bean.update(newUser);
	}
	
	public void doValidateUser(User toVal) {
		toVal.setValidAccount(true);
		bean.update(toVal);
	}
	
	public void doDeletUser(User toDel) {
		bean.delete(toDel);
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
}