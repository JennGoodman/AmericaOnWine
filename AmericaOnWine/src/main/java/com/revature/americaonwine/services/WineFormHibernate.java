package com.revature.americaonwine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Brand;
import com.revature.americaonwine.beans.Country;
import com.revature.americaonwine.beans.SubType;
import com.revature.americaonwine.beans.Type;
import com.revature.americaonwine.data.BrandDao;
import com.revature.americaonwine.data.CountryDao;
import com.revature.americaonwine.data.SubTypeDao;
import com.revature.americaonwine.data.TypeDao;

@Component
public class WineFormHibernate implements WineFormService {
	@Autowired
	private SubTypeDao std;
	@Autowired
	private BrandDao bd;
	@Autowired
	private TypeDao td;
	@Autowired
	private CountryDao cd;
	
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
	public WineFormHibernate() {
		super();
	}

}
