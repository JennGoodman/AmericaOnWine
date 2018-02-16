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

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.Roles;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.util.HibernateUtil;

@Component
public class InventoryHibernate implements InventoryDao {
	
	private HibernateUtil hu = HibernateUtil.getInstance();
	private Logger log = Logger.getLogger(InventoryHibernate.class);

	@Override
	public List<InventoryItem> getItemsForUser(User user) {
		Session s = hu.getSession();
		
		CriteriaBuilder critBuilder = s.getCriteriaBuilder();
		CriteriaQuery<InventoryItem> query = critBuilder.createQuery(InventoryItem.class);
		Root<InventoryItem> root = query.from(InventoryItem.class);
		if (user.getRole() == Roles.numericalRepresentation(Roles.RETAILER)) {
			log.warn("User is retailer and grabbing it3mz for him");
			query.select(root).where(critBuilder.equal(root.get("userId"), user.getId()));
		}
		Query<InventoryItem> q = s.createQuery(query);
		List<InventoryItem> items = q.getResultList();
		s.close();
		return items;
	}

	@Override
	public boolean addItemByUser(User user, InventoryItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InventoryItem updateItem(InventoryItem item) {
		log.trace(this.getClass() + " Called:  updateItem(item)");
		Session su = hu.getSession();
		Transaction tx = su.getTransaction();
		tx.begin();
		su.update(item);
		tx.commit();
		su.close();
		
		//su.update(item);
		return item;
	}

	@Override
	public InventoryItem addItem(InventoryItem item) {
		log.trace("Saving new inventory item: \n" + item);
		Session s = hu.getSession();
		Transaction t = s.getTransaction();
		t.begin();
		s.save(item);
		t.commit();
		s.close();
		return item;
	}

	@Override
	public List<InventoryItem> getAll() {
		log.trace("Getting all inventory items.");
		Session s = hu.getSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<InventoryItem> query = builder.createQuery(InventoryItem.class);
		Root<InventoryItem> root = query.from(InventoryItem.class);
		query.select(root);
		Query<InventoryItem> q = s.createQuery(query);
		List<InventoryItem> qlist = q.getResultList();
		s.close();
		return qlist;
	}

}
