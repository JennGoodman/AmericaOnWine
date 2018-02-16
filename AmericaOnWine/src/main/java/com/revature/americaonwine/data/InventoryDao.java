package com.revature.americaonwine.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;

@Component
public interface InventoryDao {

	// get items by user
	
	public List<InventoryItem> getItemsForUser(User user);
	
	// post item by user
	public boolean addItemByUser(User user, InventoryItem item);
	
	// update item by user 
	public InventoryItem updateItem(InventoryItem item);
	
	public InventoryItem addItem(InventoryItem item);
	
	public List<InventoryItem> getAll();
	
	public InventoryItem removeItem(InventoryItem item);
	
}
