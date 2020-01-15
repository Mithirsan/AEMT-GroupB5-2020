package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;
import be.helha.aemt.dao.InternshipOfferDAO;
import be.helha.aemt.entities.InternshipOffer;
import be.helha.aemt.exception.AddDuplicateException;

@Stateless
@LocalBean
public class ManageInternshipOfferEJB {

	@EJB
	private InternshipOfferDAO dao;
	
	public List<InternshipOffer> findAll(){
		return dao.findAll();
	}

	public void add(InternshipOffer toAdd) {
		try {
			dao.add(toAdd);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(InternshipOffer toUpdate) {
		dao.update(toUpdate);
	}

	public void delete(InternshipOffer toDel) {
		dao.delete(toDel);
	}
}
