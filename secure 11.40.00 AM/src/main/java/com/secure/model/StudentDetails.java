package com.secure.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("PersonalDetail")
@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
public class StudentDetails {


	@Id
	private String _id;
	private String father_name;
	private String mother_name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	@JsonIgnoreProperties(value = {"academicDetails", "studentCourseCollege", "studentDetails"}, allowGetters = false)
	@DocumentReference(lazy = true)
	private User user;
}