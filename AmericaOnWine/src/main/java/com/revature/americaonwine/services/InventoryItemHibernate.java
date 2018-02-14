package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.data.InventoryDao;
import com.revature.americaonwine.data.InventoryHibernate;

public class InventoryItemHibernate implements InventoryService {
	
	private InventoryDao id = new InventoryHibernate();

	@Override
	public List<InventoryItem> getAll() {
		return id.getAll();
	}

	@Override
	public InventoryItem add(InventoryItem i) {
		return id.addItem(i);
	}

}
