package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.Transaction;
import com.revature.americaonwine.beans.User;

public interface CheckoutService {
	public Transaction newTransaction(Transaction tran);
	public List<Transaction> getTransactionsForUser(User u);
	public Transaction updateTransaction(Transaction t);
}
