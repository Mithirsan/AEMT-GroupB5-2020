package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import be.helha.aemt.model.SectionEconomicHELHaMons;

@Entity
public class Event implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String eventName;
	private String planner;
	@OneToMany
	private List<Picture> pictures;
	private String describe;
	private SectionEconomicHELHaMons sectionVise;
	private String date;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String eventName, String planner, String describe, SectionEconomicHELHaMons sectionVise,String date) {
		super();
		this.eventName = eventName;
		this.planner = planner;
		this.describe = describe;
		this.sectionVise = sectionVise;
		this.date = date;
		
		this.pictures = new ArrayList<Picture>();
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getPlanner() {
		return planner;
	}

	public void setPlanner(String planner) {
		this.planner = planner;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public SectionEconomicHELHaMons getSectionVise() {
		return sectionVise;
	}

	public void setSectionVise(SectionEconomicHELHaMons sectionVise) {
		this.sectionVise = sectionVise;
	}

	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", planner=" + planner + ", pictures=" + pictures
				+ ", describe=" + describe + ", sectionVise=" + sectionVise + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((planner == null) ? 0 : planner.hashCode());
		result = prime * result + ((sectionVise == null) ? 0 : sectionVise.hashCode());
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
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (planner == null) {
			if (other.planner != null)
				return false;
		} else if (!planner.equals(other.planner))
			return false;
		if (sectionVise != other.sectionVise)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
