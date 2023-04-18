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
@Document("Answer")
public class Answer {
	@Id
	private String _id;
	
	@DocumentReference(lazy = true)
	private QuestionDetail questionDetail;
	
	private String answer;
}
