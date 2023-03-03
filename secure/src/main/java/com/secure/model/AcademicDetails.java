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
@Document("AcademicDetail")
public class AcademicDetails {
	@Id
	private String _id;
	private String school;
	private String fieldOfStudy;
	private String startDate;
	private String endDate;
	@DocumentReference(lazy = true)
	private User user;

	public enum Eucation {
		HighSchool, Intermediate,
	}

}

