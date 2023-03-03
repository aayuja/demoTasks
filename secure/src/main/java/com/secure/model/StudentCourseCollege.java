package com.secure.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("StudentCourseCollege")
public class StudentCourseCollege {

	@Id
	private String _id;
	
	@DocumentReference(lazy = true)
	private User user;
	
	@DocumentReference(lazy = true)
	private CourseCollege courseCollege;
	
}

