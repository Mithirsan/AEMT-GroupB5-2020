package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.Event;

@LocalBean
@Stateless
public class EventDAO {
	
	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<Event> findAll() {
		return em.createQuery("SELECT e FROM Event e").getResultList();
	}

}
