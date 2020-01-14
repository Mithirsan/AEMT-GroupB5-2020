package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.OverView;

@Remote
public interface IManageOverViewEJB {

	public List<OverView> findAll();
	
	public void add(OverView overView);
	
	public void delete(OverView overView);
}
