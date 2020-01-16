package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageJobOfferEJB;
import be.helha.aemt.entities.InternshipOffer;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.entities.Offer;
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
	
	
	public SectionEconomicHELHaMons getTargetSection() {
		return targetSection;
	}




	public void setTargetSection(SectionEconomicHELHaMons targetSection) {
		this.targetSection = targetSection;
	}




	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}
	
	public void doResetOffer() {
		this.jobOffer = new JobOffer();
	}
	
	public List<Offer> filterOffer() {
		List<Offer> tmp = new ArrayList<>();
		for (JobOffer j : doSelectAllJobOfferAsList()) {
			if (j.getTargetSection()==targetSection) {
					tmp.add(j);
			}
		}
		return tmp;
	}
	
	public void doSelectJobOffer(JobOffer offer)
	{
		this.jobOffer = offer;
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
