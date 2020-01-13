package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import be.helha.aemt.model.OfferType;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String company, email, contact, describtion;
	
	@ManyToOne
	private Address adress;
	
	private SectionEconomicHELHaMons targetSection;
	
	private OfferType offerType;
	
	public Offer() { }

	public Offer(String company, String email, String contact, String describtion, Address adress,
			SectionEconomicHELHaMons targetSection, OfferType offerType) {
		super();
		this.company = company;
		this.email = email;
		this.contact = contact;
		this.describtion = describtion;
		this.adress = adress;
		this.targetSection = targetSection;
		this.offerType = offerType;
	}

	public Offer(Integer id, String company, String email, String contact, String describtion, Address adress,
			SectionEconomicHELHaMons targetSection, OfferType offerType) {
		super();
		this.id = id;
		this.company = company;
		this.email = email;
		this.contact = contact;
		this.describtion = describtion;
		this.adress = adress;
		this.targetSection = targetSection;
		this.offerType = offerType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Offer other = (Offer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public SectionEconomicHELHaMons getTargetSection() {
		return targetSection;
	}

	public void setTargetSection(SectionEconomicHELHaMons targetSection) {
		this.targetSection = targetSection;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", company=" + company + ", email=" + email + ", contact=" + contact
				+ ", describtion=" + describtion + ", adress=" + adress + ", targetSection=" + targetSection
				+ ", offerType=" + offerType + "]";
	}
}
