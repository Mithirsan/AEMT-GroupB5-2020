package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Stateless;

import be.helha.aemt.dao.MessageDAO;
import be.helha.aemt.entities.Message;

@Stateless
public class ManageMessageEJB implements IManageMessageEJB{

	private MessageDAO dao;
	
	public List<Message> findAll(){
		return dao.findAll();
	}
}
