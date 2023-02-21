package com.jwt.New.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.New.model.User;
import com.jwt.New.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository studentrepo;

	public List<User> getAll() {
		return studentrepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
		User student = studentrepo.findByPhoneNumber(phoneNo);
		System.out.println(student);
		System.out.println(student == null);
		return new org.springframework.security.core.userdetails.User(String.valueOf(student.getPhoneNo()), "",
				new ArrayList<>());
	}

	@Override
	public User save(User student) {
		System.out.println(student.toString());
		User savedStudent = studentrepo.insert(student);
		return savedStudent;
	}
}
