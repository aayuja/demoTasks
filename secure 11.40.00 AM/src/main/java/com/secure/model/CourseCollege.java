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
@Document("CourseCollege")
public class CourseCollege {

	@Id
	private String _id;

	@JsonIgnoreProperties(value= {})
	@DocumentReference(lazy = true)
	private Course course;

	@JsonIgnoreProperties(value= {})
	@DocumentReference(lazy = true)
	private College college;
}
