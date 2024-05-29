package com.rishabh.splitwise.service;


import com.rishabh.splitwise.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
	private final Map<String, User> userMap;
	
	public UserService() {
		userMap = new HashMap<>();
	}
	
	public void addUser(User user) {
		userMap.put(user.getId(), user);
	}
	
	public User getUserById(String userId) {
		return userMap.get(userId);
	}
}