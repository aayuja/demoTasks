package com.demo.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwt.entity.Student;
import com.demo.jwt.entity.TokenResponse;
import com.demo.jwt.repo.StudentRepo;
import com.demo.jwt.response.Message;
import com.demo.jwt.service.JwtUtil;
import com.demo.jwt.service.ServiceImpl;
import com.demo.jwt.service.StudentService;

@RestController
public class HomeController {
	

	@Autowired
    private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private StudentRepo studentRepo;
	

	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ServiceImpl serviceImpl;
	
	@Autowired
	private JwtUtil  jwtUtil;
	
	@PostMapping("/saveDetails")
	public ResponseEntity<Message> addStudent(@RequestBody Student student)
	{
		Message message= new Message();
		studentService.save(student);
		message.setMessage("student details saved successfully");
		return ResponseEntity.ok().body(message);
		
		
		
	}

	
	@GetMapping("/hello")
	public ResponseEntity<Message> getData()
	{
	
	Message message= new Message();
	message.setMessage("Hello-World");
	return ResponseEntity.ok().body(message);
	
}
	
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponse> loginStudent(@RequestBody Student student ){
		
		
		
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getPhoneNumber(), ""));

		
		String token="Error";
		TokenResponse tmessage= new TokenResponse ();
		student.setPassWord(student.getPassWord());
		student.setPhoneNumber(student.getPhoneNumber());
		if(studentRepo.existsByphoneNumber(student.getPhoneNumber())==true
				&&
				studentRepo.existsByPassWord(student.getPassWord())==true)
		{ 
			final UserDetails userDetails =serviceImpl.loadUserByUsername(String.valueOf(student.getPhoneNumber())); 
		 token = jwtUtil.generateToken(userDetails);
		 System.out.println(token);
			
			
			tmessage.setMessage("successfully login");
			tmessage.setToken(token);
			return ResponseEntity.ok().body(tmessage);
			
			
		}
		
		else {
		
			tmessage.setMessage("Enter valid details");
		return ResponseEntity.badRequest().body(tmessage);
		
		
	}

	}

}
