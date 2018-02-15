package com.revature.americaonwine.services;

import org.springframework.stereotype.Component;
import com.revature.americaonwine.beans.InventoryItem;

public interface AdminService {
	
	//approval of new Inventory items
	public InventoryItem approve(InventoryItem inv);
	public InventoryItem deny(InventoryItem inv);
	

}
