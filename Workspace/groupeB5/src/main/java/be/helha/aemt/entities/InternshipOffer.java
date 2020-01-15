package be.helha.aemt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import be.helha.aemt.model.OfferType;
import be.helha.aemt.model.SectionEconomicHELHaMons;

@Entity
public class InternshipOffer extends Offer {
	
	private String lenghtPeriode;
	
	private Boolean pay;
	
	public InternshipOffer() {
		this.pay = false;
	}

	public InternshipOffer(String company, String title, String contact, String email, String offerDescription,
			String publishingDate, Address adress, OfferType offerType, SectionEconomicHELHaMons targetSection,String lenghtPeriode, Boolean pay) {
		super(company,title,contact,email,offerDescription,publishingDate,adress,offerType,targetSection);
		this.lenghtPeriode = lenghtPeriode;
		this.pay = pay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lenghtPeriode == null) ? 0 : lenghtPeriode.hashCode());
		result = prime * result + ((pay == null) ? 0 : pay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof InternshipOffer))
			return false;
		InternshipOffer other = (InternshipOffer) obj;
		if (lenghtPeriode == null) {
			if (other.lenghtPeriode != null)
				return false;
		} else if (!lenghtPeriode.equals(other.lenghtPeriode))
			return false;
		if (pay == null) {
			if (other.pay != null)
				return false;
		} else if (!pay.equals(other.pay))
			return false;
		return true;
	}

	public String getLenghtPeriode() {
		return lenghtPeriode;
	}

	public void setLenghtPeriode(String lenghtPeriode) {
		this.lenghtPeriode = lenghtPeriode;
	}

	public Boolean getPay() {
		return pay;
	}

	public void setPay(Boolean pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "InternshipOffer [lenghtPeriode=" + lenghtPeriode + ", pay=" + pay + ", toString()=" + super.toString()
				+ "]";
	}
}
