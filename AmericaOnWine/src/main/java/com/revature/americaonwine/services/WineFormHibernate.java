package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.Brand;
import com.revature.americaonwine.beans.Country;
import com.revature.americaonwine.beans.SubType;
import com.revature.americaonwine.beans.Type;
import com.revature.americaonwine.data.BrandDao;
import com.revature.americaonwine.data.BrandSpring;
import com.revature.americaonwine.data.CountryDao;
import com.revature.americaonwine.data.CountrySpring;
import com.revature.americaonwine.data.SubTypeDao;
import com.revature.americaonwine.data.SubTypeSpring;
import com.revature.americaonwine.data.TypeDao;
import com.revature.americaonwine.data.TypeSpring;

public class WineFormHibernate implements WineFormService {
	private SubTypeDao std = new SubTypeSpring();
	private BrandDao bd = new BrandSpring();
	private TypeDao td = new TypeSpring();
	private CountryDao cd = new CountrySpring();
	
	@Override
	public List<Country> getCountries() {
		return cd.getAll();
	}
	@Override
	public List<Brand> getBrands() {
		return bd.getAll();
	}
	@Override
	public List<Type> getTypes() {
		return td.getAll();
	}
	@Override
	public List<SubType> getSubtypes() {
		return std.getAll();
	}

}
