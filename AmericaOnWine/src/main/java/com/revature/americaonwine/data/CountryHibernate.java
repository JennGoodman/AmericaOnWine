package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.americaonwine.beans.Country;
import com.revature.americaonwine.util.HibernateUtil;

public class CountryHibernate implements CountryDao {

	Logger log = Logger.getLogger(this.getClass());

	@Override
	public int addCountry(String country) {
		log.debug(this.getClass() + " - addCountry(String country) Not yet Implemented!");
		return 0;
	}

	@Override
	public List<Country> getAllCountries() {
		log.trace(this.getClass() + " Called: getAllCountries()");
		Session s = HibernateUtil.getInstance().getSession();
		Query<Country> q = s.createQuery("from aow_country", Country.class);
		List<Country> countryList = q.getResultList();
		s.close();
		log.debug(this.getClass() + "getAllCountries() Result: " + countryList);
		return countryList;
	}

	@Override
	public boolean updateCountry(int id) {
		log.debug(this.getClass() + " - updateCountry(int id) Not yet Implemented!");
		return false;
	}

	@Override
	public boolean deleteCountry(int id) {
		log.debug(this.getClass() + " - deleteCountry(int id) Not yet Implemented!");
		return false;
	}

}
