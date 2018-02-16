package com.revature.americaonwine.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Roles;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.data.UserDao;

@Component
public class AdminHibernate implements AdminService {

	private Logger log = Logger.getLogger(AdminHibernate.class);
	
	@Autowired
	private UserDao ud;
	
	@Override
	public List<User> getPendingRetailerAccounts() {
		List<User> users = ud.getAll();
		log.debug("Users contains:");
		for (User u : users)
			log.debug(u.toString());
		List<User> retailers = new ArrayList<>();
		for (User u : users)
			if (u.getRole() == Roles.numericalRepresentation(Roles.RETAILER) && u.getActive() == 0)
				retailers.add(u);
		return retailers;
	}

}
