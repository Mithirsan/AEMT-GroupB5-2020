package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import be.helha.aemt.model.SectionEconomicHELHaMons;
import be.helha.aemt.model.UserGroup;

@Entity
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String email, password, lastName, firstName, career, describtion, birtDate, graduateDate;
	
	private Boolean validAccount, privateAccount;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Address adress;
	
	@OneToOne (cascade = CascadeType.PERSIST)
	private Picture picture;

	private UserGroup groupName;
	
	private SectionEconomicHELHaMons graduationSection;

	public User() { 
		this.validAccount = false;
		this.groupName = UserGroup.GRADUATE;
		this.privateAccount = false;
		this.career = " ";
		this.describtion = " ";
		this.birtDate = " ";
	}
	
	public User(String email, String password, String lastName, String firstName, String career,
			String describtion, Picture picture, String birtDate, String graduateDate, Boolean privateAccountBoolean, SectionEconomicHELHaMons sectionEconomicHELHaMons) {
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
		this.privateAccount = privateAccountBoolean;
		this.graduationSection = sectionEconomicHELHaMons;
		this.groupName = UserGroup.GRADUATE;
	}
	
	public User(Integer id, String email, String password, String lastName, String firstName, String career,
			String describtion, Picture picture, String birtDate, String graduateDate, Boolean privateAccount, SectionEconomicHELHaMons sectionEconomicHELHaMons) {
		super();
		this.id = id;
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
		this.graduationSection = sectionEconomicHELHaMons;
		this.groupName = UserGroup.GRADUATE;
	}
	
	public User(Integer id, String email, String password, String lastName, String firstName, String career,
			String describtion, String birtDate, String graduateDate, Boolean validAccount, Boolean privateAccount,
			Address adress, Picture picture, UserGroup groupName, SectionEconomicHELHaMons graduationSection) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.career = career;
		this.describtion = describtion;
		this.birtDate = birtDate;
		this.graduateDate = graduateDate;
		this.validAccount = validAccount;
		this.privateAccount = privateAccount;
		this.adress = adress;
		this.picture = picture;
		this.groupName = groupName;
		this.graduationSection = graduationSection;
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

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
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

	public Boolean isValidAccount() {
		return validAccount;
	}

	public void setValidAccount(Boolean validAccount) {
		this.validAccount = validAccount;
	}

	public Boolean isPrivateAccount() {
		return privateAccount;
	}

	public void setPrivateAccount(Boolean privateAccount) {
		this.privateAccount = privateAccount;
	}

	public UserGroup getGroupName() {
		return groupName;
	}

	public void setGroupName(UserGroup groupName) {
		this.groupName = groupName;
	}

	public SectionEconomicHELHaMons getGraduationSection() {
		return graduationSection;
	}

	public void setGraduationSection(SectionEconomicHELHaMons graduationSection) {
		this.graduationSection = graduationSection;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", career=" + career + ", describtion=" + describtion + ", birtDate="
				+ birtDate + ", graduateDate=" + graduateDate + ", validAccount=" + validAccount + ", privateAccount="
				+ privateAccount + ", adress=" + adress + ", picture=" + picture + ", groupName=" + groupName
				+ ", graduationSection=" + graduationSection + "]";
	}
	
	
}
