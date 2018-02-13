package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.americaonwine.beans.Country;
import com.revature.americaonwine.util.HibernateUtil;

public class CountrySpring implements CountryDao {

	Logger log = Logger.getLogger(this.getClass());
	Session s = HibernateUtil.getInstance().getSession();

	@Override
	public Country save(Country country) {
		log.trace(this.getClass() + " Called:  save(Country country)");
		s.save(country);
		return country;
	}

	@Override
	public List<?> getAll() {
		log.trace(this.getClass() + " Called: getAll()");
		return s.createQuery("From com.revature.beans.Country").list();
	}

	@Override
	public Country update(Country country) {
		log.trace(this.getClass() + " Called:  update(Country country)");
		s.update(country);
		return country;
	}

	@Override
	public void delete(Country country) {
		log.trace(this.getClass() + " Called:  delete(Country country)");
		s.delete(country);
	}
}
