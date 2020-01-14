package be.helha.aemt.ejb;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.UserDAO;
import be.helha.aemt.entities.User;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.AdminDeleteException;
import be.helha.aemt.exception.IDNotFoundException;


@Stateless
public class ManageUserEJB implements IManageUserEJB{
	@EJB
	private UserDAO dao;
	
	public List<User> findAll() {
		return dao.findAll();
	}
	
	public void add(User user) {
		try {
			dao.add(user);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean update(User oldUser, User newUser) {
		if(oldUser.equals(newUser))
			return false;
		if(oldUser.getId() != newUser.getId())
			return false;
		dao.update(newUser);
		return true;
	}


	public void delete(User user) {
		// TODO Auto-generated method stub
		try {
			dao.delete(user);
		} catch (IDNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdminDeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
