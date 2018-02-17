package com.revature.americaonwine.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.User;

@Component
public class UserHibernate implements UserDao, HibernateSession {

	private Session session;
	
	@Override
	public void setSession(Session session)
	{
		this.session = session;
	}
	
	@Override
	public boolean insertUser(User u) {
		int id = (int) session.save(u);
		if (session.get(User.class, id) != null)
			return true;
		return false;
	}

	@Override
	public User getUser(int id) {
		User u = session.get(User.class, id);
		return u;
	}

	@Override
	public User getUserByUsername(String username) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("username"), username));
		Query<User> q = session.createQuery(query);
		List<User> users = q.getResultList();
		for (User user : users) {
		}
		if (users != null && users.size() > 0) {
			User user = (User) Hibernate.unproxy(users.get(0));
			return user;
		}
		else {
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("email"), email));
		Query<User> q = session.createQuery(query);
		List<User> users = q.getResultList();
		if (users != null && !users.isEmpty())
			return users.get(0);
		else
			return null;
	}

	@Override
	public List<User> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		Query<User> q = session.createQuery(query);
		return q.getResultList();
	}

	@Override
	public boolean updateUser(User u) {
		session.update(u);
		if(u.equals(session.get(User.class, u.getId())))
			return true;
		return false;
	}

	@Override
	public boolean cancelUser(User u) {
		u.setCancelled(1);
		return updateUser(u);
	}

	@Override
	public boolean cancelUser(int id) {
		User u = getUser(id);
		u.setCancelled(1);
		return updateUser(u);
	}

}
