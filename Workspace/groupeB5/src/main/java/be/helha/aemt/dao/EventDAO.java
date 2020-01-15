package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Event;
import be.helha.aemt.exception.IDNotFoundException;

@LocalBean
@Stateless
public class EventDAO {
	
	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<Event> findAll() {
		return em.createQuery("SELECT e FROM Event e").getResultList();
	}

	public void add(Event toAdd) {
		em.persist(toAdd);
	}
	
	public Event targetSelect(Event entity) {
		Query qGet = em.createQuery("SELECT e FROM Event e WHERE "
				+ "e.date = :eDate AND "
				+ "e.description = :eDesc AND "
				+ "e.eventName = :eEventName AND "
				+ "e.planer = :ePlanner AND "
				+ "e.sectionVise = :eSectionVise");
		qGet.setParameter("eDate", entity.getDate());
		qGet.setParameter("eDesc", entity.getDescribe());
		qGet.setParameter("eEventName", entity.getEventName());
		qGet.setParameter("ePlaner", entity.getPlanner());
		qGet.setParameter("eSectionVise", entity.getSectionVise());

		List<Event> tmp = qGet.getResultList();
		
		return tmp.size()== 0 ? null : tmp.get(0);
	}
		
	public void delete(Event toDel) throws IDNotFoundException {
		if(targetSelect(toDel)==null) 
			throw new IDNotFoundException();
		em.remove(toDel);
	}
		
	public void update(Event toUpdate) {
		em.merge(toUpdate);
	} 
}
