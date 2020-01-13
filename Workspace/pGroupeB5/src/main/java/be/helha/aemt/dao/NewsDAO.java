package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.News;

@LocalBean
@Stateless
public class NewsDAO {
	
	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<News> findAll(){
		return em.createQuery("SELECT n FROM News n").getResultList();
	}

}
