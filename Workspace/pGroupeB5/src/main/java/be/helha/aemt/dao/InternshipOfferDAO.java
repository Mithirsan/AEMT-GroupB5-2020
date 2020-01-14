package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class InternshipOffer {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<InternshipOffer> findAll(){
		return em.createQuery("SELECT jo FROM InternshipOffer jo").getResultList();
	}
}
