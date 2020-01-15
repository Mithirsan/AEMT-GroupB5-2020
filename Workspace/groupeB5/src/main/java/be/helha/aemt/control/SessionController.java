package be.helha.aemt.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@SessionScoped
@Named
public class SessionController implements Serializable {
/*	private String username;
	private String password;

	public String getUsername() {
	  return this.username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login () {
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
	    try {
	    	request.login(this.username, this.password);
	    } catch (ServletException e) {
	    	context.addMessage(null, new FacesMessage("Login failed."));
	    	return "error";
	    }
	    return "admin";
	} */

	public String doLogout() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
	    return "index.xhtml";
	}
	
}
