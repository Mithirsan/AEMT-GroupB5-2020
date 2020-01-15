package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.JobOfferDAO;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
public class ManageJobOfferEJB implements IManageJobOfferEJB{
	
	@EJB
	private JobOfferDAO dao;
	
	public List<JobOffer> findAll(){
		return dao.findAll();
	}

	@Override
	public void add(JobOffer toAdd) {
		dao.add(toAdd);
	}

	@Override
	public void update(JobOffer toUpdate) {
		dao.update(toUpdate);
	}

	@Override
	public void delete(JobOffer toDel) {
		try {
			dao.delete(toDel);
		} catch (IDNotFoundException e) {
			e.printStackTrace();
		}		
	}
}