package com.paper.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paper.entity.Clas;
import com.paper.entity.QuestionPaper;
import com.paper.entity.Subjec;

@Repository
public interface QuestionPaperRepo extends MongoRepository<QuestionPaper,String> {

	List<QuestionPaper> findByClas(Clas clas);
	QuestionPaper findBySubjectAndClas(Subjec subjec,Clas clas);

}
