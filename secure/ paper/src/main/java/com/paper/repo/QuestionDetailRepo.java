package com.paper.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paper.entity.QuestionDetail;
import com.paper.entity.QuestionPaper;

@Repository
public interface QuestionDetailRepo extends MongoRepository<QuestionDetail, String> {

public List<QuestionDetail> findByQuestionPaper(QuestionPaper questionPaper);
}
