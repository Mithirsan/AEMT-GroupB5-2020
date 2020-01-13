package be.helha.aemt.entities;

public class InternshipOffer extends Offer {
	
	private String lenghtPeriode;
	
	private Boolean pay;
	
	public InternshipOffer() { }

	public InternshipOffer(String lenghtPeriode, Boolean pay) {
		super();
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
