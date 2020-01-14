package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Picture;

@Remote
public interface IManagePictureEJB {

	public List<Picture> findAll();
	
	public void add(Picture picture);
	
	public void delete(Picture picture);
}
