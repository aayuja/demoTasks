package com.system.StudentSystemApplication.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.system.StudentSystemApplication.model.Student;

public interface StudentServicee {

	List<Student> getAll();

	Student save(Student student);

	UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException;

}
