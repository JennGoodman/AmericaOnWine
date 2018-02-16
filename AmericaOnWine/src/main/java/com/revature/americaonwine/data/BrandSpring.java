package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Brand;

@Component
public class BrandSpring implements BrandDao, HibernateSession {

	Logger log = Logger.getLogger(this.getClass());
	private Session s;
	
	@Override
	public void setSession(Session session) 
	{
		this.s = session;
	}
	
	@Override
	public Brand save(Brand brand) {
		log.trace(this.getClass() + " Called:  save(Brand brand)");
		s.save(brand);
		return brand;
	}

	@Override
	public List<Brand> getAll() {
		log.trace(this.getClass() + " Called: getAll()");
		String query = "from com.revature.americaonwine.beans.Brand";
		Query<Brand> q = s.createQuery(query, Brand.class);
		return q.getResultList();
	}

	@Override
	public Brand update(Brand brand) {
		log.trace(this.getClass() + " Called:  update(Brand brand)");
		s.update(brand);
		return brand;
	}

	@Override
	public void delete(Brand brand) {
		log.trace(this.getClass() + " Called:  delete(Brand brand)");
		s.delete(brand);
	}

}
