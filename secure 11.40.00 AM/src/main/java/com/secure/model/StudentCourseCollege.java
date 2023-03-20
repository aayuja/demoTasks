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
@JsonIgnoreProperties(value = {"user"}, allowSetters = true)
@Document("StudentCourseCollege")
public class StudentCourseCollege {

	@Id
	private String _id;
	
	@JsonIgnoreProperties(value = {"academicDetails", "studentCourseCollege", "studentDetails"}, allowGetters = false)
	@DocumentReference(lazy = true)
	private User user;
	
	@JsonIgnoreProperties(value = {"course", "college"}, allowGetters = false)
	@DocumentReference(lazy = true)
	private CourseCollege courseCollege;
	
}

