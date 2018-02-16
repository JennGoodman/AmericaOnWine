package com.revature.americaonwine.data;

import org.springframework.stereotype.Component;

@Component
public interface TransactionDao {
	public int nextOrderNum();

}
