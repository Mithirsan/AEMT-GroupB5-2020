package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;
import be.helha.aemt.dao.InternshipOfferDAO;
import be.helha.aemt.entities.InternshipOffer;

@Stateless
public class ManageInternshipOfferEJB {

	@EJB
	private InternshipOfferDAO dao;
	
	public List<InternshipOffer> findAll(){
		return dao.findAll();
	}
}
