package com.revature.americaonwine.data;

import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.util.HibernateUtil;

public class InventoryHibernate implements InventoryDao {
	
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public Set<InventoryItem> getItemsForUser(User user) {
		Session s = hu.getSession();
		
		CriteriaBuilder critBuilder = s.getCriteriaBuilder();
		CriteriaQuery<InventoryItem> query = critBuilder.createQuery(InventoryItem.class);
		
		return null;
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

}
