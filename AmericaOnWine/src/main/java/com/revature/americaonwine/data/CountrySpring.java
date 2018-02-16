package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Country;

@Component
public class CountrySpring implements CountryDao, HibernateSession {

	Logger log = Logger.getLogger(this.getClass());
	private Session s;
	
	
	@Override
	public void setSession(Session session) 
	{
		this.s = session;
	}

	@Override
	public Country save(Country country) {
		log.trace(this.getClass() + " Called:  save(Country country)");
		s.save(country);
		return country;
	}

	@Override
	public List<Country> getAll() {
		log.trace(this.getClass() + " Called: getAll()");
		String query = "from com.revature.americaonwine.beans.Country";
		Query<Country> q = s.createQuery(query, Country.class);
		return q.getResultList();
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
