package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;

public interface InventoryService {
	public List<InventoryItem> getAll();
	public InventoryItem add(InventoryItem i);
	public Object getForUser(User u);

}
