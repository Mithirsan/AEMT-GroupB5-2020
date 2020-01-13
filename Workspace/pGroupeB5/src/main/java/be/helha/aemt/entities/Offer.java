package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import be.helha.aemt.model.OfferType;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String company, title, contact, email, offerDescription, publishingDate;
	
	@ManyToOne
	private Address adress;
	
	private OfferType offerType;
	
	private SectionEconomicHELHaMons targetSection;
	
	public Offer() { }

	public Offer(String company, String title, String contact, String email, String offerDescription,
			String publishingDate, Address adress, OfferType offerType, SectionEconomicHELHaMons targetSection) {
		super();
		this.company = company;
		this.title = title;
		this.contact = contact;
		this.email = email;
		this.offerDescription = offerDescription;
		this.publishingDate = publishingDate;
		this.adress = adress;
		this.offerType = offerType;
		this.targetSection = targetSection;
	}

	public Offer(Integer id, String company, String title, String contact, String email, String offerDescription,
			String publishingDate, Address adress, OfferType offerType, SectionEconomicHELHaMons targetSection) {
		super();
		this.id = id;
		this.company = company;
		this.title = title;
		this.contact = contact;
		this.email = email;
		this.offerDescription = offerDescription;
		this.publishingDate = publishingDate;
		this.adress = adress;
		this.offerType = offerType;
		this.targetSection = targetSection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((offerDescription == null) ? 0 : offerDescription.hashCode());
		result = prime * result + ((offerType == null) ? 0 : offerType.hashCode());
		result = prime * result + ((publishingDate == null) ? 0 : publishingDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((targetSection == null) ? 0 : targetSection.hashCode());
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
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (offerDescription == null) {
			if (other.offerDescription != null)
				return false;
		} else if (!offerDescription.equals(other.offerDescription))
			return false;
		if (offerType != other.offerType)
			return false;
		if (targetSection != other.targetSection)
			return false;
		if (publishingDate == null) {
			if (other.publishingDate != null)
				return false;
		} else if (!publishingDate.equals(other.publishingDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public String getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	public SectionEconomicHELHaMons getTargetSection() {
		return targetSection;
	}

	public void setTargetSection(SectionEconomicHELHaMons targetSection) {
		this.targetSection = targetSection;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", company=" + company + ", title=" + title + ", contact=" + contact + ", email="
				+ email + ", offerDescription=" + offerDescription + ", publishingDate=" + publishingDate + ", adress="
				+ adress + ", offerType=" + offerType + ", targetSection=" + targetSection + "]";
	}
}