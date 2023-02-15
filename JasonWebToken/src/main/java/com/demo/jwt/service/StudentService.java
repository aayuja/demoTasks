package com.demo.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.jwt.entity.Student;

@Service
public interface StudentService {

	void save(Student student);

	UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException;

}
