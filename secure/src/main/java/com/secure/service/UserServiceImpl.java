package com.secure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.secure.model.Password;
import com.secure.model.User;
import com.secure.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository studentrepo;

	public List<User> getAll() {
		return studentrepo.findAll();
	}
     
//	public List<User> deleteAll() {
//		
//		return studentrepo.deleteAll();
//	}

	
      public void deleteAll() {
		studentrepo.deleteAll();
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
		User student = studentrepo.findByPhoneNo(phoneNo).get();
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

	@Override
	public String changePassword(String id, Password password) {
		User user= studentrepo.getById(id);
		if(studentrepo.existsByPasswordAndId(password.getOld_password(), id)==true) {
			user.setPassword(password.getNew_password());
			studentrepo.save(user);
	    	return "password updated successfully...";
		}
    else {
    	return "enter your old password correct...";

    }
    
	}
}
