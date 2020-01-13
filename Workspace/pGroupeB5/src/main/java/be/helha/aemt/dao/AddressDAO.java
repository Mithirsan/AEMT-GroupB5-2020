package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.Address;

@Stateless
@LocalBean
public class AddressDAO {
	
	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<Address> findAll() {
		return em.createQuery("SELECT a FROM Adress a").getResultList();
	}
}
