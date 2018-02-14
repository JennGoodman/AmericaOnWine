package com.revature.americaonwine.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;

@Component
public interface InventoryService {
	public List<InventoryItem> getAll();
	public InventoryItem add(InventoryItem i);

}
