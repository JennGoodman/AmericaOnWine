package com.revature.americaonwine.services;

import org.springframework.stereotype.Component;
import com.revature.americaonwine.beans.InventoryItem;

@Component
public interface AdminService {
	
	//approval of new Inventory items
	public InventoryItem approval(InventoryItem inv);
	

}
