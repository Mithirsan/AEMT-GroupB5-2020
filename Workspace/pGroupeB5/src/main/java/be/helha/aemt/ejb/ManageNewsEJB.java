package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.NewsDAO;
import be.helha.aemt.entities.News;

@Stateless
public class ManageNewsEJB implements IManageNewsEJB{

	@EJB
	private NewsDAO dao;
	
	public List<News> findAll(){
		return dao.findAll();
	}
}
