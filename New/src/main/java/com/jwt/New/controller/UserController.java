package com.jwt.New.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.New.config.JwtService;
import com.jwt.New.config.TokenResponse;
import com.jwt.New.model.User;
import com.jwt.New.repo.UserRepository;
import com.jwt.New.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IUserService studentService;
	
	@Autowired
	private UserRepository studentRepo;
	
	@Autowired
	private JwtService jwtService;
	
	
	
	
	@GetMapping("/all")
	public List<User> getAll()
	{
		return studentService.getAll();
	}
	
	
	@PostMapping("/saveDetails")
	public User save(@RequestBody User student)
	{
		return studentService.save(student);
	} 
	
	@PostMapping("/login")
	public ResponseEntity<?> loginDetails(@RequestBody User student)
	{
	User stu = studentRepo.findByFirstNameAndPassword(student.getFirst_name(), student.getPassword());
	   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getPhoneNo(), ""));
		String token="";
		TokenResponse tmessage= new TokenResponse ();
		
		if(stu== null) {
			return ResponseEntity.badRequest().body("Galat h re!");
		}
		
		final UserDetails userDetails =studentService.loadUserByUsername(String.valueOf(student.getPhoneNo())); 
		 token = jwtService.generateToken(userDetails);
		 System.out.println(token);
			tmessage.setMessage("successfully login");
			tmessage.setToken(token);
			return ResponseEntity.ok().body(tmessage);
			}
	
	
}
