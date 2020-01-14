package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.dao.InternshipOfferDAO;
import be.helha.aemt.entities.InternshipOffer;

@Remote
public interface IManageInternshipOfferEJB {
	
	public List<InternshipOffer> findAll();

}
