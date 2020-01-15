package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Address;
import be.helha.aemt.exception.AddDuplicateException;

@Stateless
@LocalBean
public class AddressDAO {
	
	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<Address> findAll() {
		return em.createQuery("SELECT a FROM Adress a").getResultList();
	}
	
	public void add(Address address) throws AddDuplicateException{
		if(targetSelect(address)!=null)throw new AddDuplicateException();
		em.persist(address);
	}
	
	public Address targetSelect(Address address) {
		Query qGet = em.createQuery("SELECT a FROM Address a WHERE "
				+ "a.road = :aRoad AND "
				+ "a.number = :aNum AND "
				+ "a.box = :aBox AND "
				+ "a.postCode = :aPCode AND "
				+ "a.city = :aCity AND "
				+ "a.country = :aCountry");
		qGet.setParameter("aRoad", address.getRoad());
		qGet.setParameter("aNum", address.getNumber());
		qGet.setParameter("aBox", address.getBox());
		qGet.setParameter("aPCode", address.getPostCode());
		qGet.setParameter("aCity", address.getCity());
		qGet.setParameter("aCountry", address.getCountry());
		
		List<Address> tmp = qGet.getResultList();
		
		return tmp.size()== 0 ? null : tmp.get(0);
	}
		
	public void delete(Address address) {
		em.createQuery("DELETE FROM Address a WHERE a.id = " + address.getId()).executeUpdate();
	}
		
	public void update(Address newAddress) {
		em.merge(newAddress);
	} 
}