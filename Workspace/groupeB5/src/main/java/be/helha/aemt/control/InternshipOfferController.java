package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.resource.cci.InteractionSpec;

import be.helha.aemt.ejb.ManageInternshipOfferEJB;
import be.helha.aemt.entities.InternshipOffer;
import be.helha.aemt.entities.JobOffer;
import be.helha.aemt.entities.Offer;
import be.helha.aemt.model.OfferType;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@SessionScoped
@Named
public class InternshipOfferController implements Serializable {

	@EJB
	private ManageInternshipOfferEJB beanIO;
	
	private SectionEconomicHELHaMons targetSection;

	private InternshipOffer internshipOffer;
	
	public InternshipOfferController() {
		internshipOffer = new InternshipOffer();
	}
	
	public SectionEconomicHELHaMons getTargetSection() {
		return targetSection;
	}
	
	public List<InternshipOffer> doSelectUnvalidOffer(){
		return beanIO.findUnvalid();
	}
	
	public List<InternshipOffer> doSelectValidOffer(){
		return beanIO.findValid();
	}

	public void setTargetSection(SectionEconomicHELHaMons targetSection) {
		this.targetSection = targetSection;
	}

	public InternshipOffer getInternshipOffer() {
		return internshipOffer;
	}

	public void setInternshipOffer(InternshipOffer internshipOffer) {
		this.internshipOffer = internshipOffer;
	}
	
	public void doResetOffer() {
		this.internshipOffer = new InternshipOffer();
	}
	
	public List<InternshipOffer> filterOffer(){
		List<InternshipOffer> tmp = new ArrayList<>();
		for(InternshipOffer i : doSelectValidOffer()) {
			if(i.getTargetSection() == targetSection) {
				tmp.add(i);
			}
		}
		return tmp;
	}
	
	public void doSelectIntershipOffer(InternshipOffer offer) {
		this.internshipOffer = offer;
	}


	public List<InternshipOffer> doSelectAllInternShipOfferAsList(){
		return beanIO.findAll();
	}
	
	public boolean doAddInterShipOffer() {
		internshipOffer.setOfferType(OfferType.TRAINEE);

		boolean tmp = beanIO.add(internshipOffer);

		internshipOffer = new InternshipOffer();
		
		return tmp;
	}
	
	public void doValidateOffer(InternshipOffer toUpdate) {
		toUpdate.setValidOffer(true);
		beanIO.update(toUpdate);
	}
	
	public void doDeleteIOffer(InternshipOffer toDel) {
		beanIO.delete(toDel);
	}
}
