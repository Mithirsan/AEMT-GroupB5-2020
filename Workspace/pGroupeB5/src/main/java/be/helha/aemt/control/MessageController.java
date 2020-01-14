package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageMessageEJB;
import be.helha.aemt.entities.Message;

@SessionScoped
@Named
public class MessageController implements Serializable {

	private IManageMessageEJB bean;
	
	public List<Message> doSelectAllUserAsList() {
		try {
			InitialContext ctx = new InitialContext();
			bean = (IManageMessageEJB)ctx.lookup("java:global/pGroupeB5/ManageMessageEJB");
			return bean.findAll();
		} catch (NamingException e) {
			e.printStackTrace();
		}		
		return null;
	}
}
