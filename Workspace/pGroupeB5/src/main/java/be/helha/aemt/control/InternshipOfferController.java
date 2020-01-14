package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageInternshipOfferEJB;
import be.helha.aemt.entities.InternshipOffer;

@SessionScoped
@Named
public class InternshipOfferController implements Serializable {

	private IManageInternshipOfferEJB bean;
	
	public List<InternshipOffer> doSelectAllInternShipOfferAsList(){
		try {
			Context ctx = new InitialContext();
			bean = (IManageInternshipOfferEJB) ctx.lookup("java:global/pGroupeB5/ManageInternshipOfferEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
