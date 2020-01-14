package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;
import be.helha.aemt.dao.InternshipOfferDAO;
import be.helha.aemt.entities.InternshipOffer;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
public class ManageInternshipOfferEJB implements IManageInternshipOfferEJB{

	@EJB
	private InternshipOfferDAO dao;
	
	public List<InternshipOffer> findAll(){
		return dao.findAll();
	}

	@Override
	public void add(InternshipOffer toAdd) {
		dao.add(toAdd);
	}

	@Override
	public void update(InternshipOffer toUpdate) {
		dao.update(toUpdate);
	}

	@Override
	public void delete(InternshipOffer toDel) {
		try {
			dao.delete(toDel);
		} catch (IDNotFoundException e) {
			e.printStackTrace();
		}
	}
}
