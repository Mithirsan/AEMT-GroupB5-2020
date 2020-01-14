package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.dao.UserDAO;
import be.helha.aemt.ejb.IManageUserEJB;
import be.helha.aemt.ejb.ManageUserEJB;
import be.helha.aemt.entities.User;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@SessionScoped
@Named
public class UserController implements Serializable{
	
	private User user;
	
	public String getName() {
		return name;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserController() {
		// TODO Auto-generated constructor stub
		user = new User();
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAnneeDiplome() {
		return anneeDiplome;
	}

	public void setAnneeDiplome(String anneeDiplome) {
		this.anneeDiplome = anneeDiplome;
	}

	public SectionEconomicHELHaMons getSection() {
		return section;
	}

	public void setSection(SectionEconomicHELHaMons section) {
		this.section = section;
	}

	public ManageUserEJB getBean() {
		return bean;
	}

	public void setBean(ManageUserEJB bean) {
		this.bean = bean;
	}

	private ManageUserEJB bean;
	
	public List<User> doSelectAllUserAsList() {
		try {
			Context ctx = new InitialContext();
			bean = (ManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public void doAddUser() {
		User user = new User("admin@helha.be", "helha","Admin", "Admin", "webAdmin", "", null, "12/03/12", "2000", true, SectionEconomicHELHaMons.ALL);
		try {
			Context ctx = new InitialContext();
			bean = (ManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			bean.add(user);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void doUpdateUSer(User newUser) {
		Context ctx;
		try {
			ctx = new InitialContext();
			bean = (ManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			bean.update(newUser, newUser);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
