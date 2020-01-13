package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;
import be.helha.aemt.entities.Event;

@Stateless
public class ManagerEventEJB implements IManageEventEJB{

	@EJB
	private EventDAO dao;
	
	public List<Event> findAll(){
		return dao.findAll();
	}
}
