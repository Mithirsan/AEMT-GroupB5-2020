package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageAddressEJB;
import be.helha.aemt.ejb.ManageJobOfferEJB;
import be.helha.aemt.entities.Address;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.entities.Offer;
import be.helha.aemt.entities.User;
import be.helha.aemt.model.OfferType;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@SessionScoped
@Named
public class JobOfferController implements Serializable {
	
	@EJB
	private ManageJobOfferEJB beanJO;

	
	private SectionEconomicHELHaMons targetSection;
	
	private JobOffer jobOffer;
	
	public JobOfferController() {
		// TODO Auto-generated constructor stub
		jobOffer = new JobOffer();
	}
	
	
	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}

	
	/* MODELE VENANT DE "UserController", A SUPPRIMER SI "filterOffer()" FONCTIONNE
	public List<User> filterUser()
	{
		List<User> tmp = new ArrayList<User>();
		for (User user : doSelectValidNonAdminUser()) {
			if(user.getGraduationSection()==targetSection)
			{
				tmp.add(user);
			}
		}
		return tmp;
	}*/
	
	public List<JobOffer> filterOffer() {
		List<JobOffer> tmp = new ArrayList<>();
		for (JobOffer offer : doSelectAllJobOfferAsList()) {
			if (offer.getTargetSection()==targetSection) {
				tmp.add(offer);
			}
		}
		return tmp;
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
