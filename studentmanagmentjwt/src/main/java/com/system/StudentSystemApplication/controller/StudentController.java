package com.system.StudentSystemApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.system.StudentSystemApplication.config.TokenResponse;
import com.system.StudentSystemApplication.model.Student;
import com.system.StudentSystemApplication.repo.StudentRepo;
import com.system.StudentSystemApplication.service.JwtUtil;
import com.system.StudentSystemApplication.service.StudentServicee;

@RestController
public class StudentController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private StudentServicee studentService;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/all")
	public List<Student> getAll()
	{
		return studentService.getAll();
	}
	
	
	@PostMapping("/saveDetails")
	public Student save(@RequestBody Student student)
	{
		return studentService.save(student);
	} 
	
	@PostMapping("/login")
	public ResponseEntity<?> loginDetails(@RequestBody Student student)
	{
	Student stu = studentRepo.findByFirstNameAndPassword(student.getFirst_name(), student.getPassword());
	   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getPhoneNo(), ""));
		String token="Error";
		TokenResponse tmessage= new TokenResponse ();
		
		if(stu== null) {
			return ResponseEntity.badRequest().body("Galat h re!");
		}
		
		final UserDetails userDetails =studentService.loadUserByUsername(String.valueOf(student.getPhoneNo())); 
		 token = jwtUtil.generateToken(userDetails);
		 System.out.println(token);
			tmessage.setMessage("successfully login");
			tmessage.setToken(token);
			return ResponseEntity.ok().body(tmessage);
			}
	
	
}
