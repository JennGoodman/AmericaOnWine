package com.revature.americaonwine.data;

import java.util.Set;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;

public interface InventoryDao {

	// get items by user
	
	public Set<InventoryItem> getItemsForUser(User user);
	
	// post item by user
	public boolean addItemByUser(User user, InventoryItem item);
	
	// post multiple items by user
	//public int addItemsByUser(User user, Set<InventoryItem>items);

	// update item by user 
	public boolean updateItemByUser(User user, InventoryItem item);
	
}
