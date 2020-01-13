package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.Message;

@LocalBean
@Stateless
public class MessageDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<Message> findAll() {
		return em.createQuery("SELECT m FROM Message m").getResultList();
	}
	
}
