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

	public boolean add(JobOffer toAdd) {
		try {
			dao.add(toAdd);
			return true;
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(JobOffer toUpdate) {
		try {
			dao.update(toUpdate);
			return true;
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
	}

	public void delete(JobOffer toDel) {
		dao.delete(toDel);	
	}
}