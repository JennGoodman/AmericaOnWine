package com.revature.americaonwine.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "aow_Inventory")
public class InventoryItem {
	@Id
	@SequenceGenerator(name = "inventoryItemGen", sequenceName = "aow_inventory_seq", allocationSize = 1)
	@GeneratedValue(generator = "inventoryItemGen", strategy = GenerationType.SEQUENCE)
	private int id;
	@Column
	private String name;
	@Column(name = "brand_id")
	private int brandId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "country_id")
	private int countryId;
	@Column(name = "type_id")
	private int typeId;
	@Column(name = "sub_type_id")
	private int subTypeId;
	private int year;
	private double price;
	private LocalDate submitted;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(int subTypeId) {
		this.subTypeId = subTypeId;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + brandId;
		result = prime * result + countryId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + subTypeId;
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + typeId;
		result = prime * result + userId;
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
		if (id != other.id)
			return false;
		if (brandId != other.brandId)
			return false;
		if (countryId != other.countryId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (subTypeId != other.subTypeId)
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (typeId != other.typeId)
			return false;
		if (userId != other.userId)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InventoryItem [ID=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", brandId=");
		builder.append(brandId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", countryId=");
		builder.append(countryId);
		builder.append(", typeId=");
		builder.append(typeId);
		builder.append(", subTypeId=");
		builder.append(subTypeId);
		builder.append(", year=");
		builder.append(year);
		builder.append(", price=");
		builder.append(price);
		builder.append(", submitted=");
		builder.append(submitted);
		builder.append(", description=");
		builder.append(description);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append("]");
		return builder.toString();
	}

	public InventoryItem(int id, String name, int brandId, int userId, int countryId, int typeId, int subTypeId,
			int year, double price, LocalDate submitted, String description, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.brandId = brandId;
		this.userId = userId;
		this.countryId = countryId;
		this.typeId = typeId;
		this.subTypeId = subTypeId;
		this.year = year;
		this.price = price;
		this.submitted = submitted;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public InventoryItem() {
		super();
		// TODO Auto-generated constructor stub
		/*
		 * Not yet Implemented
		 */
	}
}
