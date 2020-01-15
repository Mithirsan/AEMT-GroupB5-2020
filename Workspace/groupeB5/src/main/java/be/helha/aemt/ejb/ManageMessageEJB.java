package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.MessageDAO;
import be.helha.aemt.entities.Message;
import be.helha.aemt.exception.AddDuplicateException;

@Stateless
@LocalBean
public class ManageMessageEJB{

	private MessageDAO dao;
	
	public List<Message> findAll(){
		return dao.findAll();
	}

	public void add(Message message) {
		// TODO Auto-generated method stub
		try {
			dao.add(message);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void delete(Message message) {
		// TODO Auto-generated method stub
		try {
			dao.add(message);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
