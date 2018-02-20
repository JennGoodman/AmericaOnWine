package com.revature.americaonwine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.data.TransactionDao;

@Component
public class TransactionHibernate implements TransactionService {

	@Autowired
	private TransactionDao td;
	
	@Override
	public int getMax() {
		
		return td.nextOrderNum() + 1;
	}

}
