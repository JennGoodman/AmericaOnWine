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

	private static Logger log = Logger.getLogger(UserHibernate.class);
	private Session session;
	
	@Override
	public void setSession(Session session)
	{
		this.session = session;
	}
	
	@Override
	public boolean insertUser(User u) {
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			int i = (Integer) session.save(u);
			
			StringBuilder sb = new StringBuilder();
			sb.append("User ");
			sb.append(sb.toString());
			sb.append(" added to db with id ");
			sb.append(i);
			log.info(sb.toString());
			
			tx.commit();
			
			return true;
			
		} catch(Exception e) {
			if (tx != null)
				tx.rollback();
			log.warn(e.getMessage());
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public User getUser(int id) {
		User u = session.get(User.class, id);
		session.close();
		return u;
	}

	@Override
	public User getUserByUsername(String username) {
		log.trace("Attempting to search for user with username " + username);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("username"), username));
		Query<User> q = session.createQuery(query);
		List<User> users = q.getResultList();
		for (User user : users) {
			log.trace(user.getUsername() + " is in users");
		}
		if (users != null && users.size() > 0) {
			log.trace("Found at least one user");
			log.trace("Getting user " + Hibernate.getClass(users.get(0)));
			User user = (User) Hibernate.unproxy(users.get(0));
			session.close();
			return user;
		}
		else {
			log.trace("Found nothing. NOTHING");
			session.close();
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
		Transaction tx = session.beginTransaction();
		try {
			session.update(u);
			tx.commit();
			return true;
		} catch (NonUniqueObjectException e) {
			if (tx != null)
				tx.rollback();
			return false;
		}
		
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
