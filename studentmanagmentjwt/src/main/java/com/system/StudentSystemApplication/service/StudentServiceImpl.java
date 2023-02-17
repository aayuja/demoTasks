package com.system.StudentSystemApplication.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.system.StudentSystemApplication.config.TokenResponse;
import com.system.StudentSystemApplication.model.Student;
import com.system.StudentSystemApplication.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentServicee, UserDetailsService
{
	


  @Autowired
  private StudentRepo studentrepo;

public List<Student> getAll()
{
	return studentrepo.findAll();
}

public Student save(Student student) {
	System.out.println(student.toString());
	Student savedStudent = studentrepo.insert(student);
	return savedStudent;
}

@Override
public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
	Student student = studentrepo.findByPhoneNumber(phoneNo);
	System.out.println(student);
	System.out.println(student == null);
    return  new org.springframework.security.core.userdetails.User(String.valueOf(student.getPhoneNo()), "", new ArrayList<>());

}



}



