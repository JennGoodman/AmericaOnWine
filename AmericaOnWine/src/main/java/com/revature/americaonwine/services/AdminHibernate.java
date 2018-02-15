package com.revature.americaonwine.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.data.InventoryDao;

@Component
public class AdminHibernate implements AdminService {
	
	private Logger log = Logger.getLogger(AdminHibernate.class);
	@Autowired
	private InventoryDao ud;

	@Override
	public InventoryItem approve(InventoryItem inv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryItem deny(InventoryItem inv) {
		// TODO Auto-generated method stub
		return null;
	}

}
