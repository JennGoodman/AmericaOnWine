package com.revature.americaonwine.services;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.User;


public interface LoginService {
	public User login(String username, String password);
	public User register(User u);
	public boolean logout();
}
