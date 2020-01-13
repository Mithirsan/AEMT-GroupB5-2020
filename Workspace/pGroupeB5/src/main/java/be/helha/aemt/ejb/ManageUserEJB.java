package be.helha.aemt.ejb;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.UserDAO;
import be.helha.aemt.entities.User;


@Stateless
public class ManageUserEJB implements IManageUserEJB{


	@EJB
	private UserDAO dao;
	
	public List<User> findAll() {
		return dao.findAll();
	}
	
	public void add(User user) {
		dao.add(user);
	}
	
	
	
}
