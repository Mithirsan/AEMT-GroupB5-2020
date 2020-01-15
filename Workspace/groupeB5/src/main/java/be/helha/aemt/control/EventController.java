package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.ManageEventEJB;
import be.helha.aemt.entities.Event;

@SessionScoped
@Named
public class EventController implements Serializable{
	
	@EJB
	private ManageEventEJB bean;
	
	public List<Event> doSelectAllEventAsList(){
		return bean.findAll();
	}

}
