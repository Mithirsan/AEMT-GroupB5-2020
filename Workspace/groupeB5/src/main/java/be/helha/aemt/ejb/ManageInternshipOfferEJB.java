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

	public boolean add(InternshipOffer toAdd) {
		try {
			dao.add(toAdd);
			return true;
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(InternshipOffer toUpdate) {
		try {
			dao.update(toUpdate);
			return true;
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void delete(InternshipOffer toDel) {
		dao.delete(toDel);
	}

	public List<InternshipOffer> findUnvalid() {
		return dao.findUnValid();
	}

	public List<InternshipOffer> findValid() {
		return dao.findValid();
	}
}
