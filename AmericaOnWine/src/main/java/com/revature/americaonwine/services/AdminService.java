package com.revature.americaonwine.services;

import java.util.List;

import com.revature.americaonwine.beans.User;

public interface AdminService {
	public List<User> getPendingRetailerAccounts();
	public List<User> getActivatedRetailerAccounts();
	public boolean activateRetailerAccount(User u);
	public boolean cancelRetailerAccount(User u);
	public boolean reactivateRetailerAccount(User u);
}
