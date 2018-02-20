package com.revature.americaonwine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Transaction;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.data.TransactionDao;

@Component
public class CheckoutHibernate implements CheckoutService {
	
	@Autowired
	private TransactionDao td;

	@Override
	public Transaction newTransaction(Transaction tran) {
		Transaction result = td.addTransaction(tran);
		if(result != null) {
			return result;
		}else {
			return null;
		}	
	}
	
	@Override
	public List<Transaction> getTransactionsForUser(User u) {
		return td.getForUser(u);
	}
	
}
