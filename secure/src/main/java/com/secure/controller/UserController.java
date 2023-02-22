package com.secure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secure.config.JwtService;
import com.secure.config.TokenResponse;
import com.secure.model.Password;
import com.secure.model.User;
import com.secure.repo.UserRepository;
import com.secure.service.IUserService;

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
	
	@GetMapping("/delete/all")
	public void deleteAll()
	{
		studentService.deleteAll();
	}
	
	
	@PostMapping("/saveDetails")
	public User save(@RequestBody User student)
	{
		student.setPassword(new BCryptPasswordEncoder().encode(student.getPassword()).toString());
		return studentService.save(student);
	} 
	
	@PostMapping("/login")
	public ResponseEntity<?> loginDetails(@RequestBody User student)
	{
		try {
			System.out.println(" student "+student.toString());
		   User stu = studentRepo.findByPhoneNo(student.getPhoneNo()).orElseThrow(() -> new UsernameNotFoundException("User Not found"));
		   System.out.println(stu.toString()+" student "+student.toString());
		   Boolean passMatch = new BCryptPasswordEncoder().matches(student.getPassword(), stu.getPassword());
		   if(!passMatch) {
			   return ResponseEntity.badRequest().body(new String("Wrong Password"));
		   }
		   
//		   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getPhoneNo(), stu.getPassword()));
			String token="";
			TokenResponse tmessage= new TokenResponse ();
			if(stu== null) {
				return ResponseEntity.badRequest().body("Galat h re!");
			}
			
			final UserDetails userDetails =studentService.loadUserByUsername(String.valueOf(student.getPhoneNo())); 
			 token = jwtService.generateToken(userDetails);
			 System.out.println(token+" token");
				tmessage.setMessage("successfully login");
				tmessage.setToken(token);
				return ResponseEntity.ok().body(tmessage);
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage()+"error");
			e.getStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	
	public void changePassword(@PathVariable String id, @RequestBody Password password)
	{
		studentService.changePassword(id,password);		
	}
	
	
}
