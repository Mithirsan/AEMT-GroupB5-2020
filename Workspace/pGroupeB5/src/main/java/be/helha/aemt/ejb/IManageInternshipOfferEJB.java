package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.InternshipOffer;

@Remote
public interface IManageInternshipOfferEJB {
	
	public List<InternshipOffer> findAll();
	
	public void add(InternshipOffer toAdd);
	
	public void update(InternshipOffer toUpdate);
	
	public void delete(InternshipOffer toDel);
}
