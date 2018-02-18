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
			return u;
		else return null;
	}

	@Override
	public User register(User user) {
		User email = ud.getUserByEmail(user.getEmail());
		User username = ud.getUserByUsername(user.getUsername());
		if(email != null) {
			return null;
		}else if(username != null) {
			return null;
		}else {
			ud.insertUser(user);
		}
		return user;
	}
	
}
