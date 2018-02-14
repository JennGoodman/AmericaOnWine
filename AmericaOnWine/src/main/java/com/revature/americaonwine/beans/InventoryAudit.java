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
@Table(name = "aowInventory_audit")
public class InventoryAudit {

	@Id
	@SequenceGenerator(name = "inventory_auditGen", sequenceName = "aowInventory_auditSeq", allocationSize = 1)
	@GeneratedValue(generator = "inventory_auditGen", strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "old_id")
	private int oldId;
	@Column(name = "new_id")
	private int newId;
	@Column(name = "old_name")
	private String oldName;
	@Column(name = "new_name")
	private String newName;
	@Column(name = "old_brand_id")
	private int oldBrandId;
	@Column(name = "new_brand_id")
	private int newBrandId;
	@Column(name = "old_user_id")
	private int oldUserId;
	@Column(name = "new_user_id")
	private int newUserId;
	@Column(name = "old_country_id")
	private int oldCountryId;
	@Column(name = "new_country_id")
	private int newCountryId;
	@Column(name = "old_type_id")
	private int oldTypeId;
	@Column(name = "new_type_id")
	private int newTypeId;
	@Column(name = "old_sub_type_id")
	private int oldSubTypeId;
	@Column(name = "new_sub_type_id")
	private int newSubTypeId;
	@Column(name = "old_volume")
	private float oldVolume;
	@Column(name = "new_volume")
	private float newVolume;
	@Column(name = "old_year")
	private int oldYear;
	@Column(name = "new_year")
	private int newYear;
	@Column(name = "old_price")
	private float oldPrice;
	@Column(name = "new_price")
	private float newPrice;
	@Column(name = "old_submitted")
	private LocalDate oldSubmitted;
	@Column(name = "new_submitted")
	private LocalDate newSubmitted;
	@Column(name = "old_description")
	private String oldDescription;
	@Column(name = "new_description")
	private String newDescription;
	@Column(name = "old_image_url")
	private String oldImageUrl;
	@Column(name = "new_image_url")
	private String newImageUrl;

	public InventoryAudit() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOldId() {
		return oldId;
	}

	public void setOldId(int oldId) {
		this.oldId = oldId;
	}

	public int getNewId() {
		return newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public int getOldBrandId() {
		return oldBrandId;
	}

	public void setOldBrandId(int oldBrandId) {
		this.oldBrandId = oldBrandId;
	}

	public int getNewBrandId() {
		return newBrandId;
	}

	public void setNewBrandId(int newBrandId) {
		this.newBrandId = newBrandId;
	}

	public int getOldUserId() {
		return oldUserId;
	}

	public void setOldUserId(int oldUserId) {
		this.oldUserId = oldUserId;
	}

	public int getNewUserId() {
		return newUserId;
	}

	public void setNewUserId(int newUserId) {
		this.newUserId = newUserId;
	}

	public int getOldCountryId() {
		return oldCountryId;
	}

	public void setOldCountryId(int oldCountryId) {
		this.oldCountryId = oldCountryId;
	}

	public int getNewCountryId() {
		return newCountryId;
	}

	public void setNewCountryId(int newCountryId) {
		this.newCountryId = newCountryId;
	}

	public int getOldTypeId() {
		return oldTypeId;
	}

	public void setOldTypeId(int oldTypeId) {
		this.oldTypeId = oldTypeId;
	}

	public int getNewTypeId() {
		return newTypeId;
	}

	public void setNewTypeId(int newTypeId) {
		this.newTypeId = newTypeId;
	}

	public int getOldSubTypeId() {
		return oldSubTypeId;
	}

	public void setOldSubTypeId(int oldSubTypeId) {
		this.oldSubTypeId = oldSubTypeId;
	}

	public int getNewSubTypeId() {
		return newSubTypeId;
	}

	public void setNewSubTypeId(int newSubTypeId) {
		this.newSubTypeId = newSubTypeId;
	}

	public float getOldVolume() {
		return oldVolume;
	}

	public void setOldVolume(float oldVolume) {
		this.oldVolume = oldVolume;
	}

	public float getNewVolume() {
		return newVolume;
	}

	public void setNewVolume(float newVolume) {
		this.newVolume = newVolume;
	}

	public int getOldYear() {
		return oldYear;
	}

	public void setOldYear(int oldYear) {
		this.oldYear = oldYear;
	}

	public int getNewYear() {
		return newYear;
	}

	public void setNewYear(int newYear) {
		this.newYear = newYear;
	}

	public float getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(float oldPrice) {
		this.oldPrice = oldPrice;
	}

	public float getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(float newPrice) {
		this.newPrice = newPrice;
	}

	public LocalDate getOldSubmitted() {
		return oldSubmitted;
	}

	public void setOldSubmitted(LocalDate oldSubmitted) {
		this.oldSubmitted = oldSubmitted;
	}

	public LocalDate getNewSubmitted() {
		return newSubmitted;
	}

	public void setNewSubmitted(LocalDate newSubmitted) {
		this.newSubmitted = newSubmitted;
	}

	public String getOldDescription() {
		return oldDescription;
	}

	public void setOldDescription(String oldDescription) {
		this.oldDescription = oldDescription;
	}

	public String getNewDescription() {
		return newDescription;
	}

	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
	}

	public String getOldImageUrl() {
		return oldImageUrl;
	}

	public void setOldImageUrl(String oldImageUrl) {
		this.oldImageUrl = oldImageUrl;
	}

	public String getNewImageUrl() {
		return newImageUrl;
	}

	public void setNewImageUrl(String newImageUrl) {
		this.newImageUrl = newImageUrl;
	}

	@Override
	public String toString() {
		return "InventoryAudit [id=" + id + ", oldId=" + oldId + ", newId=" + newId + ", oldName=" + oldName
				+ ", newName=" + newName + ", oldBrandId=" + oldBrandId + ", newBrandId=" + newBrandId + ", oldUserId="
				+ oldUserId + ", newUserId=" + newUserId + ", oldCountryId=" + oldCountryId + ", newCountryId="
				+ newCountryId + ", oldTypeId=" + oldTypeId + ", newTypeId=" + newTypeId + ", oldSubTypeId="
				+ oldSubTypeId + ", newSubTypeId=" + newSubTypeId + ", oldVolume=" + oldVolume + ", newVolume="
				+ newVolume + ", oldYear=" + oldYear + ", newYear=" + newYear + ", oldPrice=" + oldPrice + ", newPrice="
				+ newPrice + ", oldSubmitted=" + oldSubmitted + ", newSubmitted=" + newSubmitted + ", oldDescription="
				+ oldDescription + ", newDescription=" + newDescription + ", oldImageUrl=" + oldImageUrl
				+ ", newImageUrl=" + newImageUrl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + newBrandId;
		result = prime * result + newCountryId;
		result = prime * result + ((newDescription == null) ? 0 : newDescription.hashCode());
		result = prime * result + newId;
		result = prime * result + ((newImageUrl == null) ? 0 : newImageUrl.hashCode());
		result = prime * result + ((newName == null) ? 0 : newName.hashCode());
		result = prime * result + Float.floatToIntBits(newPrice);
		result = prime * result + newSubTypeId;
		result = prime * result + ((newSubmitted == null) ? 0 : newSubmitted.hashCode());
		result = prime * result + newTypeId;
		result = prime * result + newUserId;
		result = prime * result + Float.floatToIntBits(newVolume);
		result = prime * result + newYear;
		result = prime * result + oldBrandId;
		result = prime * result + oldCountryId;
		result = prime * result + ((oldDescription == null) ? 0 : oldDescription.hashCode());
		result = prime * result + oldId;
		result = prime * result + ((oldImageUrl == null) ? 0 : oldImageUrl.hashCode());
		result = prime * result + ((oldName == null) ? 0 : oldName.hashCode());
		result = prime * result + Float.floatToIntBits(oldPrice);
		result = prime * result + oldSubTypeId;
		result = prime * result + ((oldSubmitted == null) ? 0 : oldSubmitted.hashCode());
		result = prime * result + oldTypeId;
		result = prime * result + oldUserId;
		result = prime * result + Float.floatToIntBits(oldVolume);
		result = prime * result + oldYear;
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
		InventoryAudit other = (InventoryAudit) obj;
		if (id != other.id)
			return false;
		if (newBrandId != other.newBrandId)
			return false;
		if (newCountryId != other.newCountryId)
			return false;
		if (newDescription == null) {
			if (other.newDescription != null)
				return false;
		} else if (!newDescription.equals(other.newDescription))
			return false;
		if (newId != other.newId)
			return false;
		if (newImageUrl == null) {
			if (other.newImageUrl != null)
				return false;
		} else if (!newImageUrl.equals(other.newImageUrl))
			return false;
		if (newName == null) {
			if (other.newName != null)
				return false;
		} else if (!newName.equals(other.newName))
			return false;
		if (Float.floatToIntBits(newPrice) != Float.floatToIntBits(other.newPrice))
			return false;
		if (newSubTypeId != other.newSubTypeId)
			return false;
		if (newSubmitted == null) {
			if (other.newSubmitted != null)
				return false;
		} else if (!newSubmitted.equals(other.newSubmitted))
			return false;
		if (newTypeId != other.newTypeId)
			return false;
		if (newUserId != other.newUserId)
			return false;
		if (Float.floatToIntBits(newVolume) != Float.floatToIntBits(other.newVolume))
			return false;
		if (newYear != other.newYear)
			return false;
		if (oldBrandId != other.oldBrandId)
			return false;
		if (oldCountryId != other.oldCountryId)
			return false;
		if (oldDescription == null) {
			if (other.oldDescription != null)
				return false;
		} else if (!oldDescription.equals(other.oldDescription))
			return false;
		if (oldId != other.oldId)
			return false;
		if (oldImageUrl == null) {
			if (other.oldImageUrl != null)
				return false;
		} else if (!oldImageUrl.equals(other.oldImageUrl))
			return false;
		if (oldName == null) {
			if (other.oldName != null)
				return false;
		} else if (!oldName.equals(other.oldName))
			return false;
		if (Float.floatToIntBits(oldPrice) != Float.floatToIntBits(other.oldPrice))
			return false;
		if (oldSubTypeId != other.oldSubTypeId)
			return false;
		if (oldSubmitted == null) {
			if (other.oldSubmitted != null)
				return false;
		} else if (!oldSubmitted.equals(other.oldSubmitted))
			return false;
		if (oldTypeId != other.oldTypeId)
			return false;
		if (oldUserId != other.oldUserId)
			return false;
		if (Float.floatToIntBits(oldVolume) != Float.floatToIntBits(other.oldVolume))
			return false;
		return (oldYear == other.oldYear);
	}
}
