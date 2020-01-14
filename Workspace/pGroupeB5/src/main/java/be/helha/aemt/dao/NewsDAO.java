package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.News;
import be.helha.aemt.entities.Picture;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.AdminDeleteException;
import be.helha.aemt.exception.IDNotFoundException;

@LocalBean
@Stateless
public class NewsDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<News> findAll(){
		return em.createQuery("SELECT n FROM News n").getResultList();
	}

	public void add(News news) throws AddDuplicateException {
		if(targetSelect(news)!=null)throw new AddDuplicateException();
		em.persist(news);
	
	}
	
	public News targetSelect(News news) {
	Query qGet = em.createQuery("SELECT n FROM News n WHERE n.content = :nContent AND n.author = :nAuthor");
	qGet.setParameter("nContent",news.getContent());
	qGet.setParameter("nAuthor", news.getAuthor());
	List<News> tmp = qGet.getResultList();
	return tmp.size()== 0 ? null : tmp.get(0);
	}
	
	public void delete(News news) throws IDNotFoundException{
		if(targetSelect(news)==null) 
			throw new IDNotFoundException();
		em.remove(news);
	}
}
