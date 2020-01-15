package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;
import be.helha.aemt.entities.Event;
import be.helha.aemt.exception.AddDuplicateException;

@Stateless
@LocalBean
public class ManageEventEJB{

	@EJB
	private EventDAO dao;
	
	public List<Event> findAll(){
		return dao.findAll();
	}

	public void add(Event toAdd) {
		try {
			dao.add(toAdd);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Event toUpdate) {
		dao.update(toUpdate);
	}

	public void delete(Event toDel) {
		dao.delete(toDel);
	}
}
