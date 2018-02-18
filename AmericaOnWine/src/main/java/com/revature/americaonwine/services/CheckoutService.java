package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.Transaction;

public interface CheckoutService {
	public Transaction newTransaction(Transaction tran);
	public List<Transaction> getTransaction();

}
