package be.helha.aemt.ejb;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.UserDAO;
import be.helha.aemt.entities.User;

@LocalBean
@Stateless
<<<<<<< HEAD:Workspace/pGroupeB5/src/main/java/be/helha/aemt/ejb/ManageUser.java
public class ManageUser{
=======
public class ManageUserEJB implements IManageUserEJB{
>>>>>>> master:Workspace/pGroupeB5/src/main/java/be/helha/aemt/ejb/ManageUserEJB.java

	@EJB
	private UserDAO dao;
	
	public List<User> findAll() {
		return dao.findAll();
	}
	
	public void addUser(User user) {
		dao.add(user);
	}
	
	
	
}
