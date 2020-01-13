package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.OverView;

@LocalBean
@Stateless
public class OverViewDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<OverView> findAll(){
		return em.createQuery("SELECT o FROM OverView o").getResultList();
	}
}
