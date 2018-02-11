package com.revature.americaonwine.beans;

public enum Roles {
	ADMIN, RETAILER, CUSTOMER;
	
	public static int numericalRepresentation(Roles r) {
		if (r == ADMIN)
			return 0;
		else if (r == RETAILER)
			return 1;
		else if (r == CUSTOMER)
			return 2;
		else
			return -1;
	}
}
