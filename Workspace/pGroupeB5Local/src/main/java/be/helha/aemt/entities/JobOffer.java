package be.helha.aemt.entities;

import javax.persistence.Entity;

@Entity
public class JobOffer extends Offer {
	private Double salary;
	
	private String contractType;
	
	public JobOffer() { }

	public JobOffer(Double salary, String contractType) {
		super();
		this.salary = salary;
		this.contractType = contractType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contractType == null) ? 0 : contractType.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof JobOffer))
			return false;
		JobOffer other = (JobOffer) obj;
		if (contractType == null) {
			if (other.contractType != null)
				return false;
		} else if (!contractType.equals(other.contractType))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	@Override
	public String toString() {
		return "JobOffer [salary=" + salary + ", contractType=" + contractType + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
