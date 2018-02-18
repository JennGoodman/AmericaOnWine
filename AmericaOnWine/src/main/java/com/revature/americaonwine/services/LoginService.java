package com.revature.americaonwine.services;

import com.revature.americaonwine.beans.User;


public interface LoginService {
	public User login(String username, String password);
	public User register(User u);
}
