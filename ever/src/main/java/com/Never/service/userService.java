package com.Never.service;

import java.util.List;

import com.Never.Entity.Password;
import com.Never.Entity.User;


public interface userService {
	
	public void build(User us);
	
	public void buildPass(Password passw);
	
	public List<User> getAllData();
	

	
}

