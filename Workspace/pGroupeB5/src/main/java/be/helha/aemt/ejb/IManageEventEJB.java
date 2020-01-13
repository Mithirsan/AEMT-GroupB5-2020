package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Event;

@Remote
public interface IManageEventEJB {

		public List<Event> findAll();

}
