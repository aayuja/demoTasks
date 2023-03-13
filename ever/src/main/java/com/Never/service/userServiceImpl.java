package com.Never.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Never.Entity.Password;
import com.Never.Entity.User;
import com.Never.dao.UserRepo;

@Service
class userServiceImpl implements userService {

	@Autowired
	private UserRepo u;
	
	

	@Override
	public void build(User us) {
		u.save(us);
	}
	public void buildPass(Password passw) {
		u.save(passw);
	}
	public List<User> getAllData() {
		// TODO Auto-generated method stub
		List<User> lus= (List<User>) u.findAll();
		return lus;
	}
	
	

}
