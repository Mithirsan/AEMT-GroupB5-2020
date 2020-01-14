package be.helha.aemt.control;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import be.helha.aemt.ejb.IManageUserEJB;
import be.helha.aemt.entities.User;

public class LoginController implements Serializable{
	
	private IManageUserEJB bean;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void doCheckLoginForm() {
		User tmp = bean.login(username, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if(tmp != null){
	        context.getExternalContext().getSessionMap().put("user", tmp);
	        try {
				context.getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    else  {
	        context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));
	
	    }
	}
	
	public void doLogout() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().invalidateSession();
        try {
			context.getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
