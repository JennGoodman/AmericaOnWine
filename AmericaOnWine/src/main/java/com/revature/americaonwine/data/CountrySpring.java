package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Country;

@Component
public class CountrySpring implements CountryDao, HibernateSession {

	private Session s;
	
	@Override
	public void setSession(Session session) 
	{
		this.s = session;
	}

	@Override
	public Country save(Country country) {
		s.save(country);
		return country;
	}

	@Override
	public List<Country> getAll() {
		String query = "from com.revature.americaonwine.beans.Country";
		Query<Country> q = s.createQuery(query, Country.class);
		List<Country> countries = (List<Country>) q.getResultList();
		return countries;
	}

	@Override
	public Country update(Country country) {
		s.update(country);
		return country;
	}

	@Override
	public void delete(Country country) {
		s.delete(country);
	}

}
