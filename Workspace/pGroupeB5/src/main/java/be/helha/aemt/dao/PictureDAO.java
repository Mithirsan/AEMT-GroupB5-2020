package be.helha.aemt.dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Picture;
import be.helha.aemt.entities.User;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.AdminDeleteException;
import be.helha.aemt.exception.IDNotFoundException;
import be.helha.aemt.model.UserGroup;



@LocalBean
@Stateless
public class PictureDAO {

	@PersistenceContext(unitName = "pGroupeB5JTA")
	private EntityManager em;
	
	public List<Picture> findAll() {
		return em.createQuery("SELECT p FROM Picture p").getResultList();
	}
	
	public void add(Picture picture) throws AddDuplicateException {
		if(targetSelect(picture)!=null)throw new AddDuplicateException();
		em.persist(picture);
	
	}
	
	public Picture targetSelect(Picture picture) {
	Query qGet = em.createQuery("SELECT p FROM Picture p WHERE p.base64 = :pictureBase64");
	qGet.setParameter("pictureBase64", picture.getBase64());
	List<Picture> tmp = qGet.getResultList();
	return tmp.size()== 0 ? null : tmp.get(0);
	}
	
	public void delete(Picture picture) throws IDNotFoundException, AdminDeleteException {
		if(targetSelect(picture)==null) 
			throw new IDNotFoundException();
		em.remove(picture);
	}
}
