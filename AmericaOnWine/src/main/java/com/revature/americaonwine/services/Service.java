package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;


public interface Service {

	public List<InventoryItem> getInventoryForUser(User user);
}
