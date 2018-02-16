package com.revature.americaonwine.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.User;

@Component
public interface UserDao {
	// Create
	boolean insertUser(User u);
	// Read
	User getUser(int id);
	User getUserByUsername(String username);
	User getUserByEmail(String email);
	List<User> getAll();
	// Update
	boolean updateUser(User u);
	// Delete
	boolean cancelUser(User u);
	boolean cancelUser(int id);
}