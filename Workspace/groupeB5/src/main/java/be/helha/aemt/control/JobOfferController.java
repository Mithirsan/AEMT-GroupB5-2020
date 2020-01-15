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

@SessionScoped
@Named
public class JobOfferController implements Serializable {
	
	@EJB
	private ManageJobOfferEJB beanJO;
	@EJB
	private ManageAddressEJB beanAD;
	
	private JobOffer jobOffer = new JobOffer();
	private Address address;
	
	public JobOfferController() {
		// TODO Auto-generated constructor stub
		jobOffer = new JobOffer();
		address = new Address();
	}
	
	
	public JobOffer getJobOffer() {
		return jobOffer;
	}



	public Address getAddress() {
		return address;
	}



	public List<JobOffer> doSelectAllJobOfferAsList(){
		return beanJO.findAll();
	}
	
	public void doAddJobOffer() {
		beanAD.add(address);
		address = beanAD.targetSelect(address);
		jobOffer.setAdress(address);
		beanJO.add(jobOffer);
	}

}
