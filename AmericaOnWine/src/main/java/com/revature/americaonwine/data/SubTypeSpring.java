package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.SubType;

@Component
public class SubTypeSpring implements SubTypeDao, HibernateSession {

	private Session s;

	@Override
	public void setSession(Session session) 
	{
		this.s = session;
	}
	
	@Override
	public SubType save(SubType subType) {
		s.save(subType);
		return subType;
	}

	@Override
	public List<SubType> getAll() {
		String query = "from com.revature.americaonwine.beans.SubType";
		Query<SubType> q = s.createQuery(query, SubType.class);
		return q.getResultList();
	}

	@Override
	public SubType update(SubType subType) {
		s.update(subType);
		return subType;
	}

	@Override
	public void delete(SubType subType) {
		s.delete(subType);
	}

}
