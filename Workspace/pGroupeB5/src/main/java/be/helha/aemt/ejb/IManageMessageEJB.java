package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Message;

@Remote
public interface IManageMessageEJB {

	public List<Message> findAll();
	
	public void add(Message message);
	
	public void delete(Message message);
}
