package com.paper.service;

import java.util.List;

import com.paper.entity.Answer;
import com.paper.entity.Clas;
import com.paper.entity.QuestionDetail;
import com.paper.entity.QuestionPaper;
import com.paper.entity.Student;
import com.paper.entity.StudentClas;
import com.paper.entity.Subjec;

public interface PaperService {

	Student saveStudent(Student student);

	List<Student> getStudent();

	Clas saveClas(Clas clas);
	
	List<Clas>  getClas();

	StudentClas saveStudentClas(StudentClas studentClas);

	List<StudentClas> getStudentClas();

	Subjec saveSubjec(Subjec subjec);

	QuestionPaper saveQuestionPaper(QuestionPaper questionPaper);

	QuestionDetail saveQuestionDetail(QuestionDetail questionDetail);

	List<QuestionDetail> getQuestionDetail(String qId);

	Answer saveAnswer(String qId,String answer);

	void deleteAnswer(String aId);

	Answer getAnswer(String qId);

	List<QuestionPaper> getQuestionPapers(String cId);

	QuestionPaper getQuestionPaper(String sId, String cId);
}
