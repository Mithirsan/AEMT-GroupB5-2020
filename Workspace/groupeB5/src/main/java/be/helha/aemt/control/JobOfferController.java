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
		targetSection = SectionEconomicHELHaMons.ALL;
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
		for (JobOffer j : doSelectValidOffer()) {
			if (j.getTargetSection()==targetSection || targetSection == SectionEconomicHELHaMons.ALL) {
					tmp.add(j);
			}
		}
		return tmp;
	}
	
	public void doSelectJobOffer(JobOffer offer)
	{
		this.jobOffer = offer;
	}

	public List<JobOffer> doSelectUnvalidOffer(){
		return beanJO.findUnvalid();
	}
	
	public List<JobOffer> doSelectValidOffer(){
		return beanJO.findValid();
	}
	
	public JobOffer getJobOffer() {
		return jobOffer;
	}

	public List<JobOffer> doSelectAllJobOfferAsList(){
		return beanJO.findAll();
	}
	
	public String doAddJobOffer() {
		jobOffer.setOfferType(OfferType.JOB);
		beanJO.add(jobOffer);
		jobOffer = new JobOffer();
		return "index.xhtml";
	}
	
	public void doValidateOffer(JobOffer toUpdate) {
		toUpdate.setValidOffer(true);
		beanJO.update(toUpdate);
	}
	
	public void doDeleteIOffer(JobOffer toDel) {
		beanJO.delete(toDel);
	}
}
