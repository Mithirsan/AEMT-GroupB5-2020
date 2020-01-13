package be.helha.aemt.model;

public enum SectionEconomicHELHaMons {
	AD("Assistant(e) de Direction"),
	IG("Informatique de Gestion"),
	CG("Comptabilité de Gestion"),
	ALL("Section Economique");
	
	private String section;
	
	private SectionEconomicHELHaMons(String section) {
		this.section = section;
	}

	public String getSection() {
		return section;
	}
}
