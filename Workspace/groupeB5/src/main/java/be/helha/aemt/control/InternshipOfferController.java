package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageAddressEJB;
import be.helha.aemt.ejb.ManageInternshipOfferEJB;
import be.helha.aemt.entities.Address;
import be.helha.aemt.entities.InternshipOffer;

@Named
public class InternshipOfferController implements Serializable {

	@EJB
	private ManageInternshipOfferEJB beanIO;
	@EJB
	private ManageAddressEJB beanAD;
	
	private InternshipOffer internshipOffer;
	private Address address;
	
	public InternshipOfferController() {
		// TODO Auto-generated constructor stub
		internshipOffer = new InternshipOffer();
		address = new Address();
	}
	
	public InternshipOffer getInternshipOffer() {
		return internshipOffer;
	}

	public Address getAddress() {
		return address;
	}

	public List<InternshipOffer> doSelectAllInternShipOfferAsList(){
		return beanIO.findAll();
	}
	
	public void doAddInterShipOffer() {
		beanAD.add(address);
		address = beanAD.targetSelect(address);
		internshipOffer.setAdress(address);
		beanIO.add(internshipOffer);
	}
}
