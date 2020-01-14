package be.helha.aemt.control;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageJobOfferEJB;
import be.helha.aemt.entities.JobOffer;

@SessionScoped
@Named
public class JobOfferController {
	
	private IManageJobOfferEJB bean;
	
	public List<JobOffer> doSelectAllJobOfferAsList(){
		try {
			Context ctx = new InitialContext();
			bean = (IManageJobOfferEJB) ctx.lookup("java:global/pGroupeB5/ManageJobOfferEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
