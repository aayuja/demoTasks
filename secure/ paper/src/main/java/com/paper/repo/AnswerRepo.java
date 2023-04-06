package com.paper.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paper.entity.Answer;
import com.paper.entity.QuestionDetail;

@Repository
public interface AnswerRepo extends MongoRepository<Answer, String>{

	public Answer findByQuestionDetail(QuestionDetail qd);
}
