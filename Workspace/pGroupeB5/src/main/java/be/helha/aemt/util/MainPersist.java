package be.helha.aemt.util;

import be.helha.aemt.control.UserController;
import be.helha.aemt.entities.User;

public class MainPersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserController user = new UserController();
		user.doAddUser(new User(null, "admin", "helha", "helha", "mons", "admin", " ", " ", "20/12/12", "12/02/12", false));
	}

}
