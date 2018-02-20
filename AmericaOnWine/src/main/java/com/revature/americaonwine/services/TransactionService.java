package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.Transaction;

public interface TransactionService {
	public int getMax();
	public List<Transaction> getTransByInv(InventoryItem inv);
}
