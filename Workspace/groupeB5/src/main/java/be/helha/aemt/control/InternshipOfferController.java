package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageAddressEJB;
import be.helha.aemt.ejb.ManageInternshipOfferEJB;
import be.helha.aemt.entities.Address;
import be.helha.aemt.entities.InternshipOffer;
import be.helha.aemt.model.OfferType;

@SessionScoped
@Named
public class InternshipOfferController implements Serializable {

	@EJB
	private ManageInternshipOfferEJB beanIO;

	
	private InternshipOffer internshipOffer;
	
	public InternshipOfferController() {
		// TODO Auto-generated constructor stub
		internshipOffer = new InternshipOffer();
	}
	
	public InternshipOffer getInternshipOffer() {
		return internshipOffer;
	}


	public void setInternshipOffer(InternshipOffer internshipOffer) {
		this.internshipOffer = internshipOffer;
	}


	public List<InternshipOffer> doSelectAllInternShipOfferAsList(){
		return beanIO.findAll();
	}
	
	public void doAddInterShipOffer() {
		internshipOffer.setOfferType(OfferType.TRAINEE);

		beanIO.add(internshipOffer);

		internshipOffer = new InternshipOffer();
	}
}
