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
	
	@Override
	public boolean update(User oldUser, User newUser) {
		if(oldUser.equals(newUser))
			return false;
		if(oldUser.getId() != newUser.getId())
			return false;
		dao.update(newUser);
		return true;
	}

	@Override
	public User login(String email, String password) {
		return dao.login(email, password);
	}
}
