package com.revature.americaonwine.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Tag;

@Component
public class TagSpring implements TagDao, HibernateSession {

	Logger log = Logger.getLogger(this.getClass());
	Session s;

	@Override
	public void setSession(Session session)
	{
		this.s = session;
	}
	
	@Override
	public Tag save(Tag tag) {
		log.trace(this.getClass() + " Called:  save(Tag tag)");
		s.save(tag);
		return tag;
	}

	@Override
	public List<?> getAll() {
		log.trace(this.getClass() + " Called: getAll()");
		return s.createQuery("From com.revature.beans.Tag").list();
	}

	@Override
	public List<?> getAllByInventory(int inventoryId) {
		log.trace(this.getClass() + " Called: getAll()");
		String q = "From com.revature.beans.Tag Where inventory_id = " + inventoryId;
		return s.createQuery(q).list();
	}

	@Override
	public Tag update(Tag tag) {
		log.trace(this.getClass() + " Called:  update(Tag tag)");
		s.update(tag);
		return tag;
	}

	@Override
	public void delete(Tag tag) {
		log.trace(this.getClass() + " Called:  delete(Tag tag)");
		s.delete(tag);
	}
}
