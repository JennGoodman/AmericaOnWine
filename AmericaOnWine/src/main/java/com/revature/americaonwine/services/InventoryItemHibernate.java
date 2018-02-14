package com.revature.americaonwine.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.data.InventoryDao;
import com.revature.americaonwine.data.InventoryHibernate;

@Component
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
