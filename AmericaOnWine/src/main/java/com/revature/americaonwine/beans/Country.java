package com.revature.americaonwine.beans;

import javax.persistence.*;

@Entity
@Table(name="aow_country")
public class Country {

	@Id
	@SequenceGenerator(name="countryGen", sequenceName="aow_country_seq", allocationSize=1)
	@GeneratedValue(generator="countryGen", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column
	private String country;

	public Country() {
	}

	public Country(int id, String country) {
		super();
		this.id = id;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
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
		Country other = (Country) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
