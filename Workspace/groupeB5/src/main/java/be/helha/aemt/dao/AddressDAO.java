package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Address;
import be.helha.aemt.exception.AddDuplicateException;


public class AddressDAO {
	
	
	public static Address targetSelect(Address address, EntityManager em) {
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
}