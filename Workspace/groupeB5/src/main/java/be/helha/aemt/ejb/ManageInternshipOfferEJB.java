package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;
import be.helha.aemt.dao.InternshipOfferDAO;
import be.helha.aemt.entities.InternshipOffer;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
@LocalBean
public class ManageInternshipOfferEJB {

	@EJB
	private InternshipOfferDAO dao;
	
	public List<InternshipOffer> findAll(){
		return dao.findAll();
	}

	public void add(InternshipOffer toAdd) {
		dao.add(toAdd);
	}

	public void update(InternshipOffer toUpdate) {
		dao.update(toUpdate);
	}

	public void delete(InternshipOffer toDel) {
		try {
			dao.delete(toDel);
		} catch (IDNotFoundException e) {
			e.printStackTrace();
		}
	}
}
