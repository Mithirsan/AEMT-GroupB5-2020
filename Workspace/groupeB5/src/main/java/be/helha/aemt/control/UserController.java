package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ManageUserEJB;
import be.helha.aemt.entities.User;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@SessionScoped
@Named
public class UserController implements Serializable{
	
	private User user;
	
	private String year;
	
	private SectionEconomicHELHaMons targetSection;
	
	@EJB
	private ManageUserEJB bean;

	public UserController() {
		user = new User();
	}
	
	
	
	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public SectionEconomicHELHaMons getTargetSection() {
		return targetSection;
	}

	public void setTargetSection(SectionEconomicHELHaMons targetSection) {
		this.targetSection = targetSection;
	}

	public List<User> filterUser()
	{
		List<User> tmp = new ArrayList<User>();
		for (User user : doSelectValidNonAdminUser()) {
			if(user.getGraduationSection()==targetSection)
			{
				if(!year.equals("ALL")) {
					if(user.getGraduateDate().equals(year))
					{
						tmp.add(user);
					}
				}
				if(year.equals("ALL"))
				{
					tmp.add(user);
				}
			}
		}
		return tmp;
	}
	
	public void doResetUser() {
		this.user = new User();
	}
	
	public void doSelectUser(User user) {
		this.user = user;
	}
	
	public List<User> doSelectAllUserAsList() {
		return bean.findAll();
	}
	
	public List<User> doSelectUnvalidUser(){
		return bean.findUnvalid();
	}
	
	public List<User> doSelectValidNonAdminUser(){
		return bean.findValidNoAdmin();
	}
	
	public void doAddUser() {
		bean.add(this.user);
		user = new User();
	}
	
	public void doUpdateUser(User newUser) {
		bean.update(newUser);
	}
	
	public void doValidateUser(User toVal) {
		toVal.setValidAccount(true);
		bean.update(toVal);
	}
	
	public void doDeletUser(User toDel) {
		bean.delete(toDel);
	}

	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
	
	
}