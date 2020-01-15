package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.PictureDAO;
import be.helha.aemt.entities.Picture;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
@LocalBean
public class ManagePictureEJB{
	
	@EJB
	private PictureDAO dao;
	
	public List<Picture> findAll(){
		return dao.findAll();
	}

	public void add(Picture picture) {
		// TODO Auto-generated method stub
		try {
			dao.add(picture);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void delete(Picture picture) {
		// TODO Auto-generated method stub
		try {
			dao.delete(picture);
		} catch (IDNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
