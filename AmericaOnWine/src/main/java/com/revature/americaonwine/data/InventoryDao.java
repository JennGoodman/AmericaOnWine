package com.revature.americaonwine.data;

import java.util.List;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;

public interface InventoryDao {
	
	public List<InventoryItem> getItemsForUser(User user);
	public InventoryItem updateItem(InventoryItem item);
	public InventoryItem addItem(InventoryItem item);
	public List<InventoryItem> getAll();
	public InventoryItem removeItem(InventoryItem item);
	
}
