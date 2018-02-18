package com.revature.americaonwine.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.data.InventoryDao;
import com.revature.americaonwine.data.InventoryHibernate;

public class HibernateService implements Service {

	private InventoryDao invD = new InventoryHibernate();
	@Override
	public List<InventoryItem> getInventoryForUser(User user) {
		return invD.getItemsForUser(user);
	}

}
