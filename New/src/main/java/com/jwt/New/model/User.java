package com.jwt.New.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("User")
public class User {

	@Id
	private String _id;
	private String first_name;
	private String last_name;
	private String email;
	private String phoneNo;
	private String password;
	private String dob;
    

}
