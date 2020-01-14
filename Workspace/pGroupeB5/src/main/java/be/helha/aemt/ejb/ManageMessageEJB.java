package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Stateless;

import be.helha.aemt.dao.MessageDAO;
import be.helha.aemt.entities.Message;
import be.helha.aemt.exception.AddDuplicateException;

@Stateless
public class ManageMessageEJB implements IManageMessageEJB{

	private MessageDAO dao;
	
	public List<Message> findAll(){
		return dao.findAll();
	}

	@Override
	public void add(Message message) {
		// TODO Auto-generated method stub
		try {
			dao.add(message);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
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
