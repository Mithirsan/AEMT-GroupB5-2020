package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Address;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.exception.AddDuplicateException;

@LocalBean
@Stateless
public class JobOfferDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<JobOffer> findAll(){
		return em.createQuery("SELECT jo FROM JobOffer jo").getResultList();
	}
	

	public void add(JobOffer toAdd) throws AddDuplicateException{
		if(targetSelect(toAdd)!=null)throw new AddDuplicateException();
		Address a = AddressDAO.targetSelect(toAdd.getAdress(),em);
		if(a!=null)toAdd.setAdress(a);;
		em.persist(toAdd);
	}

	public void update(JobOffer toUpdate) throws AddDuplicateException {
		if(targetSelect(toUpdate)!=null)throw new AddDuplicateException();
		Address a = AddressDAO.targetSelect(toUpdate.getAdress(),em);
		if(a!=null)toUpdate.setAdress(a);;
		em.merge(toUpdate);
	}

	public void delete(JobOffer toDel){
		em.createQuery("DELETE FROM JobOffer jo WHERE jo.id = " + toDel.getId()).executeUpdate();
	}
	
	public JobOffer targetSelect(JobOffer entity) {
		//company, title, contact, email, offerDescription, publishingDate, adress, offerType, targetSection, salary, contractType
		Query qGet = em.createQuery("SELECT o FROM JobOffer o WHERE "
				+ "o.company = :oCompany AND "
				+ "o.title = :oTitle AND "
				+ "o.contact = :oContact AND "
				+ "o.email = :oEmail AND "
				+ "o.offerDescription = :oODescription AND "
				+ "o.publishingDate = :oPubDate AND "
				+ "o.adress = :oAddress AND "
				+ "o.offerType = :oOType AND "
				+ "o.targetSection = :oTSection");
		qGet.setParameter("oCompany", entity.getCompany());
		qGet.setParameter("oTitle", entity.getTitle());
		qGet.setParameter("oContact", entity.getContact());
		qGet.setParameter("oEmail", entity.getEmail());
		qGet.setParameter("oODescription", entity.getOfferDescription());
		qGet.setParameter("oPubDate", entity.getPublishingDate());
		qGet.setParameter("oAddress", entity.getAdress());
		qGet.setParameter("oOType", entity.getOfferType());
		qGet.setParameter("oTSection", entity.getTargetSection());
	
		List<JobOffer> tmp = qGet.getResultList();
		
		return tmp.size()== 0 ? null : tmp.get(0);
	}
}
