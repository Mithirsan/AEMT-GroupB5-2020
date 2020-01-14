package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.OverViewDAO;
import be.helha.aemt.entities.OverView;
import be.helha.aemt.exception.AddDuplicateException;
import be.helha.aemt.exception.IDNotFoundException;

@Stateless
public class ManageOverViewEJB implements IManageOverViewEJB{
	
	@EJB
	private OverViewDAO dao;
	
	public List<OverView> findAll(){
		return dao.findAll();
	}

	@Override
	public void add(OverView overView) {
		// TODO Auto-generated method stub
		try {
			dao.add(overView);
		} catch (AddDuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(OverView overView) {
		// TODO Auto-generated method stub
		try {
			dao.delete(overView);
		} catch (IDNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
