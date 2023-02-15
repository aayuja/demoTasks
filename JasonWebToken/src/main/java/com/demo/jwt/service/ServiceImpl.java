package com.demo.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.demo.jwt.entity.Student;
import com.demo.jwt.repo.StudentRepo;
import java.util.ArrayList;

@Service
public class ServiceImpl implements StudentService, UserDetailsService {
	
	@Autowired 
	private StudentRepo studentRepo;

	@Override
	public void save(Student student) {
		studentRepo.save(student);
		
	}

	


	@Override
	public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
		Student student = studentRepo.findByPhoneNumber(phoneNo);
        return  new org.springframework.security.core.userdetails.User(String.valueOf(student.getPhoneNumber()), "", new ArrayList<>());
	}



}
