package com.revature.americaonwine.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.Roles;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.util.HibernateUtil;

public class InventoryHibernate implements InventoryDao {
	
	private HibernateUtil hu = HibernateUtil.getInstance();
	Session s = HibernateUtil.getInstance().getSession();
	Logger log = Logger.getLogger(InventoryHibernate.class);

	@Override
	public List<InventoryItem> getItemsForUser(User user) 
	{
		log.trace(".... get items for user is called ...---...");
		Session s = hu.getSession();
		
		CriteriaBuilder critBuilder = s.getCriteriaBuilder();
		CriteriaQuery<InventoryItem> query = critBuilder.createQuery(InventoryItem.class);
		Root<InventoryItem> root = query.from(InventoryItem.class);
		if (user.getRole() == Roles.numericalRepresentation(Roles.RETAILER)) {
			log.trace("----- get's inside the if block");
			query.select(root).where(critBuilder.equal(root.get("userId"), user.getId()));
		}
		// query.select(root).where(critBuilder.greaterThanOrEqualTo(root.get("quantity"), 0));
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
	public boolean updateItemByUser(User user, InventoryItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InventoryItem addItem(InventoryItem item) {
		log.trace("Saving new inventory item: \n" + item);
		s.save(item);
		return item;
	}

	@Override
	public List<InventoryItem> getAll() {
		log.trace("Getting all inventory items.");		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<InventoryItem> query = builder.createQuery(InventoryItem.class);
		Root<InventoryItem> root = query.from(InventoryItem.class);
		query.select(root);
		Query<InventoryItem> q = s.createQuery(query);
		return q.getResultList();
	}

	@Override
	public boolean removeItemByUser(User user, InventoryItem item) {
		// TODO Auto-generated method stub
		Transaction tx = s.getTransaction();
		if (item.getUserId() == user.getId()) {
			item.setQuantity(-1);
			
		}
		else {
			
		}
			
		return false;
	}

}
