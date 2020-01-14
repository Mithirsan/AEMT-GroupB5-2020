package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageNewsEJB;
import be.helha.aemt.entities.News;

@SessionScoped
@Named
public class NewsController implements Serializable{
	
	private IManageNewsEJB bean;
	
	public List<News> doSelectAllUserAsList() {
		try {
			InitialContext ctx = new InitialContext();
			bean = (IManageNewsEJB)ctx.lookup("java:global/pGroupeB5/ManageNewsEJB");
			return bean.findAll();
		} catch (NamingException e) {
			e.printStackTrace();
		}		
		return null;
	}
}
