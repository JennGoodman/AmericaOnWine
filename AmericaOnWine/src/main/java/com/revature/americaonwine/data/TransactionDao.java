package com.revature.americaonwine.data;

import java.util.List;

import com.revature.americaonwine.beans.Transaction;
import com.revature.americaonwine.beans.User;

public interface TransactionDao {
	public int nextOrderNum();
	public Transaction addTransaction(Transaction tran);
	public List<Transaction> getForUser(User u);

}
