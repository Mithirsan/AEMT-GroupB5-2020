package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.UserDAO;
import be.helha.aemt.entities.User;

@Stateless
public class ManageUser implements IManageUserEJB{

	@EJB
	private UserDAO dao;
	
	@Override
	public List<User> findAll() {
		return dao.findAll();
	}
	
}
