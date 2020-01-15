package be.helha.aemt.model;

public enum OfferType {
	JOB("Job Offer"),
	TRAINEE("Internship Offer");
	
	private String type;
	
	private OfferType(String type) {
		this.type = type;
	}

	public String getOfferType() {
		return type;
	}
}
