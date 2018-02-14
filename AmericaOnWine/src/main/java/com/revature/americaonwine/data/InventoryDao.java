package com.revature.americaonwine.data;

import java.util.List;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;

public interface InventoryDao {

	// get items by user
	
	public List<InventoryItem> getItemsForUser(User user);
	
	// post item by user
	public boolean addItemByUser(User user, InventoryItem item);
	
	// post multiple items by user
	//public int addItemsByUser(User user, List<InventoryItem>items);

	// update item by user 
	public boolean updateItemByUser(User user, InventoryItem item);
	
	public InventoryItem addItem(InventoryItem item);
	
	public List<InventoryItem> getAll();
	
}
