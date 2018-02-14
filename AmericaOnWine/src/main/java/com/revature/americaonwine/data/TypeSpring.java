package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.americaonwine.beans.Country;
import com.revature.americaonwine.beans.Type;
import com.revature.americaonwine.util.HibernateUtil;

public class TypeSpring implements TypeDao {

	Logger log = Logger.getLogger(this.getClass());
	Session s = HibernateUtil.getInstance().getSession();

	@Override
	public Type save(Type type) {
		log.trace(this.getClass() + " Called:  save(Type type)");
		s.save(type);
		return type;
	}

	@Override
	public List<Type> getAll() {
		log.trace(this.getClass() + " Called: getAll()");
		String query = "from com.revature.beans.Type";
		Query<Type> q = s.createQuery(query, Type.class);
		return q.getResultList();
	}

	@Override
	public Type update(Type type) {
		log.trace(this.getClass() + " Called:  update(Type type)");
		s.update(type);
		return type;
	}

	@Override
	public void delete(Type type) {
		log.trace(this.getClass() + " Called:  delete(Type type)");
		s.delete(type);
	}
}
