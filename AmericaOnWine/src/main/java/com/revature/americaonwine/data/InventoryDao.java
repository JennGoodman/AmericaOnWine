package com.revature.americaonwine.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;

@Component
public interface InventoryDao {
	
	public List<InventoryItem> getItemsForUser(User user);
	
	// post item by user
	public boolean addItemByUser(User user, InventoryItem item);
	
	// post multiple items by user
	//public int addItemsByUser(User user, List<InventoryItem>items);

	// update item by user 
	//public boolean updateItemByUser(User user, InventoryItem item);
	public InventoryItem updateItem(InventoryItem item);
	public InventoryItem addItem(InventoryItem item);
	public List<InventoryItem> getAll();
	public InventoryItem removeItem(InventoryItem item);
	
}
