package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.JobOfferDAO;
import be.helha.aemt.entities.JobOffer;

@Stateless
public class ManageJobOfferEJB {
	
	@EJB
	private JobOfferDAO dao;
	
	public List<JobOffer> findAll(){
		return dao.findAll();
	}
	
	

}
