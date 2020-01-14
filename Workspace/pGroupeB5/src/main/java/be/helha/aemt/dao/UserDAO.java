package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.User;

@Stateless
@LocalBean
public class UserDAO {
	
	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<User> findAll() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}
	
	public void add(User user) {
		em.persist(user);
	}
}
