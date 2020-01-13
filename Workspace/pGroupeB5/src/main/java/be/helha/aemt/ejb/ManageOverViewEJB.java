package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.OverViewDAO;
import be.helha.aemt.entities.OverView;

@Stateless
public class ManageOverViewEJB implements IManageOverViewEJB{
	
	@EJB
	private OverViewDAO dao;
	
	public List<OverView> findAll(){
		return dao.findAll();
	}

}
