package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.JobOfferDAO;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
@LocalBean
public class ManageJobOfferEJB{
	
	@EJB
	private JobOfferDAO dao;
	
	public List<JobOffer> findAll(){
		return dao.findAll();
	}

	public void add(JobOffer toAdd) {
		dao.add(toAdd);
	}

	public void update(JobOffer toUpdate) {
		dao.update(toUpdate);
	}

	public void delete(JobOffer toDel) {
		try {
			dao.delete(toDel);
		} catch (IDNotFoundException e) {
			e.printStackTrace();
		}		
	}
}