package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManagePictureEJB;
import be.helha.aemt.entities.Picture;

@SessionScoped
@Named
public class PictureController implements Serializable {
	
	private IManagePictureEJB bean;
	
	public List<Picture> doSelectAllUserAsList() {
		try {
			InitialContext ctx = new InitialContext();
			bean = (IManagePictureEJB)ctx.lookup("java:global/pGroupeB5/ManagePictureEJB");
			return bean.findAll();
		} catch (NamingException e) {
			e.printStackTrace();
		}		
		return null;
	}
}
