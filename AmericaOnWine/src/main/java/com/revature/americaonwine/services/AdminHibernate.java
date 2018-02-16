package com.revature.americaonwine.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.data.InventoryDao;
import com.revature.americaonwine.data.InventoryHibernate;

@Component
public class AdminHibernate implements AdminService {
	
	private Logger log = Logger.getLogger(AdminHibernate.class);
	@Autowired
	private InventoryHibernate id;

	@Override
	public InventoryItem approval(InventoryItem inv) {
		id.updateItem(inv);
		log.trace("approving item");
		return inv;
	}

}
