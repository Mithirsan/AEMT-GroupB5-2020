package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.JobOffer;

@LocalBean
@Stateless
public class JobOfferDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<JobOffer> findAll(){
		return em.createQuery("SELECT jo FROM JobOffert jo").getResultList();
	}
}
