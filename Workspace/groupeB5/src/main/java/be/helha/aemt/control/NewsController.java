package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageNewsEJB;
import be.helha.aemt.entities.News;

@SessionScoped
@Named
public class NewsController implements Serializable{
	
	@EJB
	private ManageNewsEJB bean;
	
	public List<News> doSelectAllUserAsList() {
		return bean.findAll();
	}
}
