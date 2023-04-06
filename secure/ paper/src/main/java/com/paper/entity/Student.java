package com.paper.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Student")
public class Student {
    @Id
    private String _id;
	private String studentName;
	private int age;
	private String email;
	
}
