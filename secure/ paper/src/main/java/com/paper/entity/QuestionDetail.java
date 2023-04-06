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
@Document("QuestionDetail")
public class QuestionDetail {
	
	@Id
	private String _id;
	
	@DocumentReference(lazy = true)
	private QuestionPaper questionPaper;
	
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
}
