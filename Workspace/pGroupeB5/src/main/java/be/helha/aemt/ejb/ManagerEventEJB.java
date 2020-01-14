package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;
import be.helha.aemt.entities.Event;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
public class ManagerEventEJB implements IManageEventEJB{

	@EJB
	private EventDAO dao;
	
	public List<Event> findAll(){
		return dao.findAll();
	}

	@Override
	public void add(Event toAdd) {
		dao.add(toAdd);
	}

	@Override
	public void update(Event toUpdate) {
		dao.update(toUpdate);
	}

	@Override
	public void delete(Event toDel) {
		try {
			dao.delete(toDel);
		} catch (IDNotFoundException e) {
			e.printStackTrace();
		}
	}
}
