package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.ejb.IManageUserEJB;
import be.helha.aemt.ejb.ManageUserEJB;
import be.helha.aemt.entities.User;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@SessionScoped
@Named
public class UserController implements Serializable{
	
	private String name ="";
	private String surname ="";
	private String email ="";
	private String mdp ="";
	private String anneeDiplome ="";
	private SectionEconomicHELHaMons section = SectionEconomicHELHaMons.ALL;
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
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

	public IManageUserEJB getBean() {
		return bean;
	}

	public void setBean(IManageUserEJB bean) {
		this.bean = bean;
	}

	private IManageUserEJB bean;
	
	public List<User> doSelectAllUserAsList() {
		try {
			Context ctx = new InitialContext();
			bean = (IManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			return bean.findAll();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public void doAddUser() {
		try {
			User user = new User("Admin@helha.be", "helha","Admin", "Admin", "", "", null, "", "2000", true, SectionEconomicHELHaMons.ALL);
			Context ctx = new InitialContext();
			bean = (IManageUserEJB) ctx.lookup("java:global/pGroupeB5/ManageUserEJB");
			bean.add(user);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
