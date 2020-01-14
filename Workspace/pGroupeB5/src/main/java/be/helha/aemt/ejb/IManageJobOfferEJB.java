package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.JobOffer;

@Remote
public interface IManageJobOfferEJB {
	
	public List<JobOffer> findAll();

	public void add(JobOffer toAdd);
	
	public void update(JobOffer toUpdate);
	
	public void delete(JobOffer toDel);
}
