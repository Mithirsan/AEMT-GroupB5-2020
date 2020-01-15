package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageInternshipOfferEJB;
import be.helha.aemt.entities.InternshipOffer;

@SessionScoped
@Named
public class InternshipOfferController implements Serializable {

	@EJB
	private ManageInternshipOfferEJB bean;
	
	public List<InternshipOffer> doSelectAllInternShipOfferAsList(){
		return bean.findAll();
	}
}
