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

@Component
public class InventoryHibernate implements InventoryDao, HibernateSession {
	
	private Session s;
	
	@Override
	public void setSession(Session session) 
	{
		this.s = session;
	}

	@Override
	public List<InventoryItem> getItemsForUser(User user) 
	{
		CriteriaBuilder critBuilder = s.getCriteriaBuilder();
		CriteriaQuery<InventoryItem> query = critBuilder.createQuery(InventoryItem.class);
		Root<InventoryItem> root = query.from(InventoryItem.class);
		if (user.getRole() == Roles.numericalRepresentation(Roles.RETAILER)) 
		{
			query.select(root).where(critBuilder.and(critBuilder.greaterThanOrEqualTo(root.get("quantity"), 0), 
					critBuilder.equal(root.get("userId"), user.getId())));
		} 
		if (user.getRole() == Roles.numericalRepresentation(Roles.CUSTOMER))
		{
			query.select(root).where(critBuilder.and(critBuilder.greaterThan(root.get("quantity"), 0),
					critBuilder.equal(root.get("status"), 2)));
		}
		
		Query<InventoryItem> q = s.createQuery(query);
		List<InventoryItem> items = q.getResultList();
		return items;
	}

	@Override
	public boolean addItemByUser(User user, InventoryItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InventoryItem updateItem(InventoryItem item) 
	{
		s.update(item);
		return item;
	}

	@Override
	public InventoryItem addItem(InventoryItem item) {
		s.save(item);
		return item;
	}

	@Override
	public List<InventoryItem> getAll() {
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<InventoryItem> query = builder.createQuery(InventoryItem.class);
		Root<InventoryItem> root = query.from(InventoryItem.class);
		query.select(root);
		Query<InventoryItem> q = s.createQuery(query);
		List<InventoryItem> qlist = q.getResultList();
		return qlist;
	}

	@Override
	public InventoryItem removeItem(InventoryItem item) {
		item.setQuantity(-1);
		return updateItem(item);
	}

}
