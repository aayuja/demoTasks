package com.student.StudentAdmission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.student.StudentAdmission.model.Student;
import com.student.StudentAdmission.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	
	@GetMapping("/all")
	public List<Student> getAll()
	{
		return studentservice.getAll();
	}
	
	
	@PostMapping("/saveDetails")
	public Student save(@RequestBody Student student)
	{
		return studentservice.save(student);
	}
//	,
//	{
//	  "first_name":"Minakshi",
//	  "last_name":"Mishra",
//	  "emailid":" minakshimishra@gmail.com",
//	  "dob":"29/08/08"
//	    
//	},
//	{
//	  "first_name":"Kamal",
//	  "last_name":"Singh",
//	  "emailid":" kamalsingh@gmail.com",
//	  "dob":"30/08/08"
//	    
//	},
//	{
//	  "first_name":"Shruti",
//	  "last_name":"Kothiyal",
//	  "emailid":" ayushibartwal@gmail.com",
//	  "dob":"31/08/08"
//	    
//	}

}
