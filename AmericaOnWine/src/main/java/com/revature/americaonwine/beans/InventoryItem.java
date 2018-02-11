package com.revature.americaonwine.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="aow_inventory")
public class InventoryItem {
	@Id
	@SequenceGenerator(name="inventoryItemGen", sequenceName="aow_inventory_seq", allocationSize=1)
	@GeneratedValue(generator="inventoryItemGen", strategy=GenerationType.SEQUENCE)
	private int ID;
	@Column
	private String name;
	private int brand_id;
	private int user_id;
	private int country_id;
	private int type_id;
	private int sub_type_id;
	private int year;
	private double price;
	private LocalDate submitted;
	private String description;
	private String image_url;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getSub_type_id() {
		return sub_type_id;
	}
	public void setSub_type_id(int sub_type_id) {
		this.sub_type_id = sub_type_id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getSubmitted() {
		return submitted;
	}
	public void setSubmitted(LocalDate submitted) {
		this.submitted = submitted;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + brand_id;
		result = prime * result + country_id;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image_url == null) ? 0 : image_url.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sub_type_id;
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + type_id;
		result = prime * result + user_id;
		result = prime * result + year;
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
		InventoryItem other = (InventoryItem) obj;
		if (ID != other.ID)
			return false;
		if (brand_id != other.brand_id)
			return false;
		if (country_id != other.country_id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (image_url == null) {
			if (other.image_url != null)
				return false;
		} else if (!image_url.equals(other.image_url))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (sub_type_id != other.sub_type_id)
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (type_id != other.type_id)
			return false;
		if (user_id != other.user_id)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InventoryItem [ID=");
		builder.append(ID);
		builder.append(", name=");
		builder.append(name);
		builder.append(", brand_id=");
		builder.append(brand_id);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", country_id=");
		builder.append(country_id);
		builder.append(", type_id=");
		builder.append(type_id);
		builder.append(", sub_type_id=");
		builder.append(sub_type_id);
		builder.append(", year=");
		builder.append(year);
		builder.append(", price=");
		builder.append(price);
		builder.append(", submitted=");
		builder.append(submitted);
		builder.append(", description=");
		builder.append(description);
		builder.append(", image_url=");
		builder.append(image_url);
		builder.append("]");
		return builder.toString();
	}
	public InventoryItem(int iD, String name, int brand_id, int user_id, int country_id, int type_id, int sub_type_id,
			int year, double price, LocalDate submitted, String description, String image_url) {
		super();
		ID = iD;
		this.name = name;
		this.brand_id = brand_id;
		this.user_id = user_id;
		this.country_id = country_id;
		this.type_id = type_id;
		this.sub_type_id = sub_type_id;
		this.year = year;
		this.price = price;
		this.submitted = submitted;
		this.description = description;
		this.image_url = image_url;
	}
	public InventoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
