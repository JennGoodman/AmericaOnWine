package com.revature.americaonwine.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.data.UserDao;

@Component
public class LoginHibernate implements LoginService {

	private Logger log = Logger.getLogger(LoginHibernate.class);
	@Autowired
	private UserDao ud;
	
	@Override
	public User login(String username, String password) {
		log.trace("Attempting to login; Username: " + username + "; Password: " + password);
		User u = ud.getUserByUsername(username);
		log.trace("Recieved user " + u.toString());
		if (u != null && u.getPassword().equals(password) )
			return u;
		else return null;
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
