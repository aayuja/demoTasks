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
@Document("PersonalDetail")
public class StudentDetails {


	@Id
	private String _id;
	private String father_name;
	private String mother_name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String dob;
	@DocumentReference(lazy = true)
	private User user;
}