package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.JobOfferDAO;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.exception.AddDuplicateException;

@Stateless
@LocalBean
public class ManageJobOfferEJB{
	
	@EJB
	private JobOfferDAO dao;
	
	public List<JobOffer> findAll(){
		return dao.findAll();
	}

	public void add(JobOffer toAdd) {
		try {
			dao.add(toAdd);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(JobOffer toUpdate) {
		dao.update(toUpdate);
	}

	public void delete(JobOffer toDel) {
		dao.delete(toDel);	
	}
}