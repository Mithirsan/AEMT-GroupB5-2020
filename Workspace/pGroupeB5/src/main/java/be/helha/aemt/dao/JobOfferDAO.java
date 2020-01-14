package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.exception.IDNotFoundException;

@LocalBean
@Stateless
public class JobOfferDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<JobOffer> findAll(){
		return em.createQuery("SELECT jo FROM JobOffert jo").getResultList();
	}
	

	public void add(JobOffer toAdd) {
		em.persist(toAdd);
	}

	public void update(JobOffer toUpdate) {
		em.merge(toUpdate);
	}

	public void delete(JobOffer toDel) throws IDNotFoundException {
		if(targetSelect(toDel)==null) 
			throw new IDNotFoundException();
		em.remove(toDel);
	}
	
	public JobOffer targetSelect(JobOffer entity) {
		//company, title, contact, email, offerDescription, publishingDate, adress, offerType, targetSection, salary, contractType
		Query qGet = em.createQuery("SELECT o FROM Event o WHERE "
				+ "o.company = :oCompany AND "
				+ "o.title = :oTitle AND "
				+ "o.contact = :oContact AND "
				+ "o.email = :oEmail AND "
				+ "o.offerDescription = :oODescription AND "
				+ "o.publishingDate = :oPubDate AND "
				+ "o.adress = :oAddress AND "
				+ "o.offerType = :oOType AND "
				+ "o.targetSection = :oTSection AND "
				+ "o.salary = :oSalary AND "
				+ "o.contractType = :oCType");
		qGet.setParameter("oCompany", entity.getCompany());
		qGet.setParameter("oTittle", entity.getTitle());
		qGet.setParameter("oContact", entity.getContact());
		qGet.setParameter("oEmail", entity.getEmail());
		qGet.setParameter("oODescription", entity.getOfferDescription());
		qGet.setParameter("oPubDate", entity.getPublishingDate());
		qGet.setParameter("oAddress", entity.getAdress());
		qGet.setParameter("oOType", entity.getOfferType());
		qGet.setParameter("oTsection", entity.getTargetSection());
		qGet.setParameter("oSalary", entity.getSalary());
		qGet.setParameter("oCType", entity.getContractType());
	
		List<JobOffer> tmp = qGet.getResultList();
		
		return tmp.size()== 0 ? null : tmp.get(0);
	}
}
