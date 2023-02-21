package com.jwt.New.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jwt.New.model.User;

public interface IUserService {
	List<User> getAll();

	User save(User student);

	UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException;
}
