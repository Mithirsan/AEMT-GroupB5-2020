package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.PictureDAO;
import be.helha.aemt.entities.Picture;

@Stateless
public class ManagePictureEJB implements IManagePictureEJB {
	
	@EJB
	private PictureDAO dao;
	
	public List<Picture> findAll(){
		return dao.findAll();
	}

	
}
