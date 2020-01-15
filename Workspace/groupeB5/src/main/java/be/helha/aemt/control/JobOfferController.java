package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageJobOfferEJB;
import be.helha.aemt.entities.JobOffer;

@Named
public class JobOfferController {
	
	@EJB
	private ManageJobOfferEJB bean;
	
	public List<JobOffer> doSelectAllJobOfferAsList(){
		return bean.findAll();
	}

}
