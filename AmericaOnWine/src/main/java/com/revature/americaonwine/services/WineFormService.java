package com.revature.americaonwine.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Brand;
import com.revature.americaonwine.beans.Country;
import com.revature.americaonwine.beans.SubType;
import com.revature.americaonwine.beans.Type;

@Component
public interface WineFormService {
	public List<Country> getCountries();
	public List<Brand> getBrands();
	public List<Type> getTypes();
	public List<SubType> getSubtypes();

}
