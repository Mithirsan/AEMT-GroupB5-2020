package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.UserDAO;
import be.helha.aemt.entities.User;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.AdminDeleteException;

@Stateless
@LocalBean
public class ManageUserEJB{
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
	
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		try {
			dao.delete(user);
			return true;
		} catch (AdminDeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User newUser) {
		try {
			dao.update(newUser);
			return true;
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<User> findUnvalid() {
		return dao.findInvalid();
	}

	public List<User> findValidNoAdmin() {
		return dao.findUsualUsers();
	}
}
