package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String road, number, box, postCode, city, country;
	
	public Address() { 
		this.road = "unkwnow";
		this.number = "unkwnow";
		this.box = "unkwnow";
		this.postCode = "unkwnow";
		this.city = "unkwnow";
		this.country = "unkwnow";
	}
	
	
	public Address(Integer id,String road, String number, String box, String postCode, String city, String country) {
		super();
		this.id = id;
		this.road = road;
		this.number = number;
		this.box = box;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
	}

	public Address(String road, String number, String box, String postCode, String city, String country) {
		super();
		this.road = road;
		this.number = number;
		this.box = box;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((box == null) ? 0 : box.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((road == null) ? 0 : road.hashCode());
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
		Address other = (Address) obj;
		if (box == null) {
			if (other.box != null)
				return false;
		} else if (!box.equals(other.box))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (road == null) {
			if (other.road != null)
				return false;
		} else if (!road.equals(other.road))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return road +" n° "+ number + "\n" + postCode
				+ " " + city + "\n" + country;
	}
}
