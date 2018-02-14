package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.Brand;
import com.revature.americaonwine.beans.Country;
import com.revature.americaonwine.beans.SubType;
import com.revature.americaonwine.beans.Type;

public interface WineFormService {
	public List<Country> getCountries();
	public List<Brand> getBrands();
	public List<Type> getTypes();
	public List<SubType> getSubtypes();

}
