package com.secure.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.secure.model.Password;
import com.secure.model.User;

public interface IUserService {
	List<User> getAll();

	User save(User student);

	UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException;

	String changePassword(String id, Password password);

	void deleteAll();

}
