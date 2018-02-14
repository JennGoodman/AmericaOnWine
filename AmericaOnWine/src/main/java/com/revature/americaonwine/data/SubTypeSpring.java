package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.americaonwine.beans.Country;
import com.revature.americaonwine.beans.SubType;
import com.revature.americaonwine.util.HibernateUtil;

public class SubTypeSpring implements SubTypeDao {

	Logger log = Logger.getLogger(this.getClass());
	Session s = HibernateUtil.getInstance().getSession();

	@Override
	public SubType save(SubType subType) {
		log.trace(this.getClass() + " Called:  save(SubType subType)");
		s.save(subType);
		return subType;
	}

	@Override
	public List<SubType> getAll() {
		log.trace(this.getClass() + " Called: getAll()");
		String query = "from com.revature.americaonwine.beans.SubType";
		Query<SubType> q = s.createQuery(query, SubType.class);
		return q.getResultList();
	}

	@Override
	public SubType update(SubType subType) {
		log.trace(this.getClass() + " Called:  update(SubType subType)");
		s.update(subType);
		return subType;
	}

	@Override
	public void delete(SubType subType) {
		log.trace(this.getClass() + " Called:  delete(SubType subType)");
		s.delete(subType);
	}
}
