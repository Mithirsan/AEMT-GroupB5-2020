package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.InternshipOffer;

@LocalBean
@Stateless
public class InternshipOfferDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<InternshipOffer> findAll(){
		return em.createQuery("SELECT jo FROM InternshipOffer jo").getResultList();
	}
}
