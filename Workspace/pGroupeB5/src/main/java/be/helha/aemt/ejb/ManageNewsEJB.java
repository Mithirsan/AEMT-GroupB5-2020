package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.NewsDAO;
import be.helha.aemt.entities.News;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
public class ManageNewsEJB implements IManageNewsEJB{

	@EJB
	private NewsDAO dao;
	
	public List<News> findAll(){
		return dao.findAll();
	}

	@Override
	public void add(News news) {
		// TODO Auto-generated method stub
		try {
			dao.add(news);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(News news) {
		// TODO Auto-generated method stub
		try {
			dao.delete(news);
		} catch (IDNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
