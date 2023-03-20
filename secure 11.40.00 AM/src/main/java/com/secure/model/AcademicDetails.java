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
@Document("AcademicDetail")
public class AcademicDetails {
	@Id
	private String _id;
	private String school;
	private String fieldOfStudy;
	private String startDate;
	private String endDate;

	@DocumentReference(lazy = true)
	@JsonIgnoreProperties(value = {"academicDetails", "studentCourseCollege", "studentDetails"}, allowGetters = false)
	private User user;

	public enum Eucation {
		HighSchool, Intermediate,
	}

}



