package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.dao.InternshipOfferDAO;

@Remote
public interface IManageInternshipOfferEJB {
	
	public List<InternshipOfferDAO> findAll();

}
