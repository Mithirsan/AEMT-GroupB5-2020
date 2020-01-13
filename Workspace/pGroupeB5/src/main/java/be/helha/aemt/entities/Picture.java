package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Picture implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String base64;
	
	public Picture() {
		// TODO Auto-generated constructor stub
	}
	
	public Picture(String base64) {
		super();
		this.base64 = base64;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", base64=" + base64 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base64 == null) ? 0 : base64.hashCode());
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
		Picture other = (Picture) obj;
		if (base64 == null) {
			if (other.base64 != null)
				return false;
		} else if (!base64.equals(other.base64))
			return false;
		return true;
	}
	
	

}
