package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.OverView;
import be.helha.aemt.entities.Picture;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.AdminDeleteException;
import be.helha.aemt.exception.IDNotFoundException;

@LocalBean
@Stateless
public class OverViewDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<OverView> findAll(){
		return em.createQuery("SELECT o FROM OverView o").getResultList();
	}
	
	public void add(OverView overView) throws AddDuplicateException {
		if(targetSelect(overView)!=null)throw new AddDuplicateException();
		em.persist(overView);
	
	}
	
	public OverView targetSelect(OverView overView) {
	Query qGet = em.createQuery("SELECT o FROM OverView o WHERE o.picture = :oPicture AND o.description = :oDescription");
	qGet.setParameter("oPicture", overView.getPicture());
	qGet.setParameter("oDescription", overView.getDescribe());
	List<OverView> tmp = qGet.getResultList();
	return tmp.size()== 0 ? null : tmp.get(0);
	}
	
	public void delete(OverView overView) throws IDNotFoundException{
		if(targetSelect(overView)==null) 
			throw new IDNotFoundException();
		em.remove(overView);
	}
	
}
