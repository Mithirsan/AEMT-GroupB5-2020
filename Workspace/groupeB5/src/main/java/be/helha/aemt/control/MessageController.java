package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageMessageEJB;
import be.helha.aemt.entities.Message;

@SessionScoped
@Named
public class MessageController implements Serializable {

	@EJB
	private ManageMessageEJB bean;
	
	public List<Message> doSelectAllUserAsList() {
		return bean.findAll();
	}
}
