package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageAddressEJB;
import be.helha.aemt.ejb.ManageJobOfferEJB;
import be.helha.aemt.entities.Address;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.model.OfferType;

@SessionScoped
@Named
public class JobOfferController implements Serializable {
	
	@EJB
	private ManageJobOfferEJB beanJO;

	
	private JobOffer jobOffer;
	
	public JobOfferController() {
		// TODO Auto-generated constructor stub
		jobOffer = new JobOffer();
	}
	
	
	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}


	public JobOffer getJobOffer() {
		return jobOffer;
	}

	public List<JobOffer> doSelectAllJobOfferAsList(){
		return beanJO.findAll();
	}
	
	public void doAddJobOffer() {
		jobOffer.setOfferType(OfferType.JOB);
		beanJO.add(jobOffer);
		jobOffer = new JobOffer();
	}

}
