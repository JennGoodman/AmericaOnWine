package com.revature.americaonwine.beans;

import java.time.LocalDate;

public class InventoryItem {
	private int ID;
	private String NAME;
	private int BRAND_ID;
	private int USER_ID;
	private int COUNTRY_ID;
	private int TYPE_ID;
	private int SUB_TYPE_ID;
	private int YEAR;
	private double PRICE;
	private LocalDate SUBMITTED;
	private String DESCRIPTION;
	private String IMAGE_URL;

	public InventoryItem(int iD, String nAME, int bRAND_ID, int uSER_ID, int cOUNTRY_ID, int tYPE_ID, int sUB_TYPE_ID,
			int yEAR, double pRICE, LocalDate sUBMITTED, String dESCRIPTION, String iMAGE_URL) {
		super();
		ID = iD;
		NAME = nAME;
		BRAND_ID = bRAND_ID;
		USER_ID = uSER_ID;
		COUNTRY_ID = cOUNTRY_ID;
		TYPE_ID = tYPE_ID;
		SUB_TYPE_ID = sUB_TYPE_ID;
		YEAR = yEAR;
		PRICE = pRICE;
		SUBMITTED = sUBMITTED;
		DESCRIPTION = dESCRIPTION;
		IMAGE_URL = iMAGE_URL;
	}
	public InventoryItem() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InventoryItem [ID=");
		builder.append(ID);
		builder.append(", NAME=");
		builder.append(NAME);
		builder.append(", BRAND_ID=");
		builder.append(BRAND_ID);
		builder.append(", USER_ID=");
		builder.append(USER_ID);
		builder.append(", COUNTRY_ID=");
		builder.append(COUNTRY_ID);
		builder.append(", TYPE_ID=");
		builder.append(TYPE_ID);
		builder.append(", SUB_TYPE_ID=");
		builder.append(SUB_TYPE_ID);
		builder.append(", YEAR=");
		builder.append(YEAR);
		builder.append(", PRICE=");
		builder.append(PRICE);
		builder.append(", SUBMITTED=");
		builder.append(SUBMITTED);
		builder.append(", DESCRIPTION=");
		builder.append(DESCRIPTION);
		builder.append(", IMAGE_URL=");
		builder.append(IMAGE_URL);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + BRAND_ID;
		result = prime * result + COUNTRY_ID;
		result = prime * result + ((DESCRIPTION == null) ? 0 : DESCRIPTION.hashCode());
		result = prime * result + ID;
		result = prime * result + ((IMAGE_URL == null) ? 0 : IMAGE_URL.hashCode());
		result = prime * result + ((NAME == null) ? 0 : NAME.hashCode());
		long temp;
		temp = Double.doubleToLongBits(PRICE);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((SUBMITTED == null) ? 0 : SUBMITTED.hashCode());
		result = prime * result + SUB_TYPE_ID;
		result = prime * result + TYPE_ID;
		result = prime * result + USER_ID;
		result = prime * result + YEAR;
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
		if (BRAND_ID != other.BRAND_ID)
			return false;
		if (COUNTRY_ID != other.COUNTRY_ID)
			return false;
		if (DESCRIPTION == null) {
			if (other.DESCRIPTION != null)
				return false;
		} else if (!DESCRIPTION.equals(other.DESCRIPTION))
			return false;
		if (ID != other.ID)
			return false;
		if (IMAGE_URL == null) {
			if (other.IMAGE_URL != null)
				return false;
		} else if (!IMAGE_URL.equals(other.IMAGE_URL))
			return false;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		if (Double.doubleToLongBits(PRICE) != Double.doubleToLongBits(other.PRICE))
			return false;
		if (SUBMITTED == null) {
			if (other.SUBMITTED != null)
				return false;
		} else if (!SUBMITTED.equals(other.SUBMITTED))
			return false;
		if (SUB_TYPE_ID != other.SUB_TYPE_ID)
			return false;
		if (TYPE_ID != other.TYPE_ID)
			return false;
		if (USER_ID != other.USER_ID)
			return false;
		if (YEAR != other.YEAR)
			return false;
		return true;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getBRAND_ID() {
		return BRAND_ID;
	}
	public void setBRAND_ID(int bRAND_ID) {
		BRAND_ID = bRAND_ID;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getCOUNTRY_ID() {
		return COUNTRY_ID;
	}
	public void setCOUNTRY_ID(int cOUNTRY_ID) {
		COUNTRY_ID = cOUNTRY_ID;
	}
	public int getTYPE_ID() {
		return TYPE_ID;
	}
	public void setTYPE_ID(int tYPE_ID) {
		TYPE_ID = tYPE_ID;
	}
	public int getSUB_TYPE_ID() {
		return SUB_TYPE_ID;
	}
	public void setSUB_TYPE_ID(int sUB_TYPE_ID) {
		SUB_TYPE_ID = sUB_TYPE_ID;
	}
	public int getYEAR() {
		return YEAR;
	}
	public void setYEAR(int yEAR) {
		YEAR = yEAR;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}
	public LocalDate getSUBMITTED() {
		return SUBMITTED;
	}
	public void setSUBMITTED(LocalDate sUBMITTED) {
		SUBMITTED = sUBMITTED;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getIMAGE_URL() {
		return IMAGE_URL;
	}
	public void setIMAGE_URL(String iMAGE_URL) {
		IMAGE_URL = iMAGE_URL;
	}
}
