package com.revature.americaonwine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.data.UserDao;

@Component
public class LoginHibernate implements LoginService {

	@Autowired
	private UserDao ud;
	
	@Override
	public User login(String username, String password) {
		User u = ud.getUserByUsername(username);
		if (u != null && u.getPassword().equals(password) )
			return null;
		else return u;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User register(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
