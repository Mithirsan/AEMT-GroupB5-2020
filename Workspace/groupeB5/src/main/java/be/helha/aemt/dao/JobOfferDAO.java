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
	
	public List<JobOffer> findUnValid(){
		return em.createQuery("SELECT jo FROM JobOffer jo WHERE jo.validOffer = 0").getResultList();
	}
	
	public List<JobOffer> findValid(){
		return em.createQuery("SELECT jo FROM JobOffer jo WHERE jo.validOffer = 1").getResultList();
	}

	//m?thode permettant la persistence d'une offre de job
	public void add(JobOffer toAdd) throws AddDuplicateException{
		//test permettant d'emp?cher les doublons en db
		if(targetSelect(toAdd)!=null)throw new AddDuplicateException();
		//Instance temporaire de l'adresse r?cup?rant l'id en plus des attributs de l'adresse de l'offre de job
		Address a = AddressDAO.targetSelect(toAdd.getAdress(),em);
		//Test emp?chant les doublons en db mais la liaison des adresses existente au offre de job par rapport ? l'id de l'adresse
		if(a!=null)toAdd.setAdress(a);
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
				+ "o.targetSection = :oTSection AND "
				+ "o.validOffer = :oVOffer");
		qGet.setParameter("oCompany", entity.getCompany());
		qGet.setParameter("oTitle", entity.getTitle());
		qGet.setParameter("oContact", entity.getContact());
		qGet.setParameter("oEmail", entity.getEmail());
		qGet.setParameter("oODescription", entity.getOfferDescription());
		qGet.setParameter("oPubDate", entity.getPublishingDate());
		qGet.setParameter("oAddress", entity.getAdress());
		qGet.setParameter("oOType", entity.getOfferType());
		qGet.setParameter("oTSection", entity.getTargetSection());
		qGet.setParameter("oVOffer", entity.getValidOffer());
	
		List<JobOffer> tmp = qGet.getResultList();
		
		return tmp.size()== 0 ? null : tmp.get(0);
	}
}
