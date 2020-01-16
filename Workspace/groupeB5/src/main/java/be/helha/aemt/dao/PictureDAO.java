package be.helha.aemt.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import be.helha.aemt.entities.Picture;




public class PictureDAO {

	public static Picture targetSelect(Picture picture,EntityManager em) {
	Query qGet = em.createQuery("SELECT p FROM Picture p WHERE p.base64 = :pictureBase64");
	qGet.setParameter("pictureBase64", picture.getBase64());
	List<Picture> tmp = qGet.getResultList();
	return tmp.size()== 0 ? null : tmp.get(0);
	}
	
}
