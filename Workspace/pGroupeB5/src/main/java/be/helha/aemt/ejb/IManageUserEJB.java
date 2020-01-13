package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.User;

@Remote
public interface IManageUserEJB {
	public List<User> findAll();
}
