package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManagePictureEJB;
import be.helha.aemt.entities.Picture;

@SessionScoped
@Named
public class PictureController implements Serializable {
	
	@EJB
	private ManagePictureEJB bean;
	
	public List<Picture> doSelectAllUserAsList() {
		return bean.findAll();
	}
}
