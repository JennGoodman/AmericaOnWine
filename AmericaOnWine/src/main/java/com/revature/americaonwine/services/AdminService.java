package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.User;

import org.springframework.stereotype.Component;
import com.revature.americaonwine.beans.InventoryItem;

@Component
public interface AdminService {
	
	//approval of new Inventory items
	public InventoryItem approval(InventoryItem inv);
	public List<User> getPendingRetailerAccounts();
	public List<User> getActivatedRetailerAccounts();
	public boolean activateRetailerAccount(User u);
	public boolean cancelRetailerAccount(User u);
	public boolean reactivateRetailerAccount(User u);
}
