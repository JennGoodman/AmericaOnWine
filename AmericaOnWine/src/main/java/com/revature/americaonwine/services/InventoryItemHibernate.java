package com.revature.americaonwine.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.data.InventoryDao;
import com.revature.americaonwine.data.InventoryHibernate;

@Component
public class InventoryItemHibernate implements InventoryService {
	
	private Logger log = Logger.getLogger(InventoryItemHibernate.class);
	private InventoryDao id = new InventoryHibernate();

	@Override
	public List<InventoryItem> getAll() {
		return id.getAll();
	}

	@Override
	public InventoryItem add(InventoryItem i) {
		return id.addItem(i);
	}

	@Override
	public Object getForUser(User u) {
		return id.getItemsForUser(u);
	}

	@Override
	public InventoryItem updateInventoryItem(InventoryItem item) {
		return id.updateItemByUser(item);
	}

	@Override
	public InventoryItem removeInventoryItem(InventoryItem item) {
		return id.removeItemByUser(item);
	}
	
	

}
