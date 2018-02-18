package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Type;

@Component
public class TypeSpring implements TypeDao, HibernateSession {

	private Session s;

	@Override
	public void setSession(Session session)
	{
		this.s = session;
	}
	
	@Override
	public Type save(Type type) {
		s.save(type);
		return type;
	}

	@Override
	public List<Type> getAll() {
		String query = "from com.revature.americaonwine.beans.Type";
		Query<Type> q = s.createQuery(query, Type.class);
		return q.getResultList();
	}

	@Override
	public Type update(Type type) {
		s.update(type);
		return type;
	}

	@Override
	public void delete(Type type) {
		s.delete(type);
	}
}
