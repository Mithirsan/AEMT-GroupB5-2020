package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageEventEJB;
import be.helha.aemt.entities.Event;

@SessionScoped
@Named
public class EventController implements Serializable{
	
	private IManageEventEJB bean;
	
	public List<Event> doSelectAllEventAsList(){
		try {
			Context ctx = new InitialContext();
			bean = (IManageEventEJB) ctx.lookup("java:global/pGroupeB5/ManageEventEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
