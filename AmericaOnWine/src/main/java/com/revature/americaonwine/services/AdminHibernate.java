package com.revature.americaonwine.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.Roles;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.data.InventoryHibernate;
import com.revature.americaonwine.data.UserDao;

@Component
public class AdminHibernate implements AdminService {
	
	@Autowired
	private UserDao ud;
	@Autowired
	private InventoryDao id;
	
	@Override
	public List<User> getPendingRetailerAccounts() {
		List<User> users = ud.getAll();
		List<User> retailers = new ArrayList<>();
		for (User u : users)
			if (u.getRole() == Roles.numericalRepresentation(Roles.RETAILER) && u.getActive() == 0)
				retailers.add(u);
		return retailers;
	}

	@Override
	public List<User> getActivatedRetailerAccounts() {
		List<User> users = ud.getAll();
		List<User> retailers = new ArrayList<>();
		for (User u : users)
			if (u.getRole() == Roles.numericalRepresentation(Roles.RETAILER) && u.getActive() == 1)
				retailers.add(u);
		return retailers;
	}

	@Override
	public boolean activateRetailerAccount(User u) {
		u.setActive(1);
		return ud.updateUser(u);
	}

	@Override
	public boolean cancelRetailerAccount(User u) {
		return ud.cancelUser(u);
	}

	@Override
	public boolean reactivateRetailerAccount(User u) {
		u.setCancelled(0);
		return ud.updateUser(u);
	}
	@Override
	public InventoryItem approval(InventoryItem inv) {
		id.updateItem(inv);
		return inv;
	}
}
