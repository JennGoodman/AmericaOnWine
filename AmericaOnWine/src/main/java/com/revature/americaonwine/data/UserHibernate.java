package com.revature.americaonwine.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.util.HibernateUtil;

@Component
public class UserHibernate implements UserDao {

	private static Logger log = Logger.getLogger(UserHibernate.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public boolean insertUser(User u) {
		Session session = hu.getSession();
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
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public User getUser(int id) {
		Session su = hu.getSession();
		User u = su.get(User.class, id);
		su.close();
		return u;
	}

	@Override
	public User getUserByUsername(String username) {
		Session su = hu.getSession();
		CriteriaBuilder builder = su.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("username"), username));
		Query<User> q = su.createQuery(query);
		List<User> users = q.getResultList();
		if (users != null && users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public User getUserByEmail(String email) {
		Session su = hu.getSession();
		CriteriaBuilder builder = su.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("email"), email));
		Query<User> q = su.createQuery(query);
		List<User> users = q.getResultList();
		if (users != null && users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public List<User> getAll() {
		Session su = hu.getSession();
		CriteriaBuilder builder = su.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		Query<User> q = su.createQuery(query);
		List<User> users = q.getResultList();
		return users;
	}

	@Override
	public boolean updateUser(User u) {
		Session su = hu.getSession();
		Transaction tx = su.beginTransaction();
		try {
			su.update(u);
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
