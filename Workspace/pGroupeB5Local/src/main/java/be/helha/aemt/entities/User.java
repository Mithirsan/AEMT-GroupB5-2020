package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import be.helha.aemt.model.UserGroup;

@Entity
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email, password, lastName, firstName, career, describtion, picture, birtDate, graduateDate;	
	private boolean validAccount, privateAccount;
	private UserGroup groupName;

	public User() { }
	
	
	public User(String email, String password, String lastName, String firstName, String career,
			String describtion, String picture, String birtDate, String graduateDate, boolean privateAccount) {
		super();
		this.email = email;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.career = career;
		this.describtion = describtion;
		this.picture = picture;
		this.birtDate = birtDate;
		this.graduateDate = graduateDate;
		this.validAccount = false;
		this.privateAccount = privateAccount;
		this.groupName = UserGroup.GRADUATE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(String birtDate) {
		this.birtDate = birtDate;
	}

	public String getGraduateDate() {
		return graduateDate;
	}

	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}

	public boolean isValidAccount() {
		return validAccount;
	}

	public void setValidAccount(boolean validAccount) {
		this.validAccount = validAccount;
	}

	public boolean isPrivateAccount() {
		return privateAccount;
	}

	public void setPrivateAccount(boolean privateAccount) {
		this.privateAccount = privateAccount;
	}

	public UserGroup getGroupName() {
		return groupName;
	}

	public void setGroupName(UserGroup groupName) {
		this.groupName = groupName;
	}

}
