package com.revature.americaonwine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.Transaction;
import com.revature.americaonwine.data.TransactionDao;

@Component
public class TransactionHibernate implements TransactionService {

	@Autowired
	private TransactionDao td;
	
	@Override
	public int getMax() {
		
		return td.nextOrderNum() + 1;
	}


	@Override
	public List<Transaction> getTransByInv(InventoryItem inv) {
		// TODO Auto-generated method stub
		return td.getTransByInv(inv);
	}

}
