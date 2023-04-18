package com.paper.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("StudentClas")
public class StudentClas {
	@Id
	private String _id;
	
	@DocumentReference(lazy = true)
	Student student;
	
	@DocumentReference(lazy = true)
	Clas clas;
}
