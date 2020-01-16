package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import be.helha.aemt.ejb.ManageUserEJB;
import be.helha.aemt.entities.User;


@SessionScoped
@Named
public class SessionController implements Serializable {
	
	@EJB
	private ManageUserEJB bean;
	private User user;
	
	public void doDeletUser() {
		bean.delete(bean.targetUser(user.getEmail()));
		this.doLogout();
	}

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	public SessionController() {
		// TODO Auto-generated constructor stub
		this.user = new User();
	}
	
	public String doLogout() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		this.user = new User();
	    return "index.xhtml";
	}
	
	public boolean doIsLogin() {
		if(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser() != null) {
			this.user = bean.targetUser(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
			return true;
		}
		return false;
	}
	
	public boolean doIsRoleAdmin() {
		return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser().equals("admin");
	}
	
	
}
