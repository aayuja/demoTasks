package com.paper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paper.entity.Answer;
import com.paper.entity.Clas;
import com.paper.entity.QuestionDetail;
import com.paper.entity.QuestionPaper;
import com.paper.entity.Student;
import com.paper.entity.StudentClas;
import com.paper.entity.Subjec;
import com.paper.repo.AnswerRepo;
import com.paper.repo.ClasRepo;
import com.paper.repo.QuestionDetailRepo;
import com.paper.repo.QuestionPaperRepo;
import com.paper.repo.StudentClasRepo;
import com.paper.repo.StudentRepo;
import com.paper.repo.SubjecRepo;

@Service
public class PaperServiceImplementation implements PaperService{

@Autowired
private StudentRepo studentRepo; 
@Autowired
private ClasRepo clasRepo;
@Autowired
private StudentClasRepo studentClasRepo;
@Autowired
private SubjecRepo subjectRepo; 
@Autowired
private QuestionPaperRepo questionPaperRepo; 
@Autowired
private QuestionDetailRepo questionDetailRepo;
@Autowired
private AnswerRepo answerRepo;
@Override
public Student saveStudent(Student student) {
	//return studentRepo.insert(student);
	Student savedStudent=studentRepo.insert(student);
	return savedStudent;
}
@Override
public List<Student> getStudent() {
	List<Student> stList=studentRepo.findAll();
	return stList;
}
@Override
public Clas saveClas(Clas clas) {
	return clasRepo.insert(clas);
}
@Override
public List<Clas> getClas() {
	return clasRepo.findAll();
}
@Override
public StudentClas saveStudentClas(StudentClas studentClas) {
	Student st = studentClas.getStudent();
	Clas cls = studentClas.getClas();
	System.out.println(st+"<<<>>>"+cls);
	return studentClasRepo.insert(studentClas);
}
@Override
public List<StudentClas> getStudentClas() {
	return studentClasRepo.findAll();
}
@Override
public Subjec saveSubjec(Subjec subjec) {
	return subjectRepo.insert(subjec);
}
@Override
public QuestionPaper saveQuestionPaper(QuestionPaper questionPaper) {
	return questionPaperRepo.insert(questionPaper);
}
@Override
public QuestionDetail saveQuestionDetail(QuestionDetail questionDetail) {
	
	return questionDetailRepo.insert(questionDetail);
}
@Override
public List<QuestionDetail> getQuestionDetail(String qId) {
	
  QuestionPaper qp=new QuestionPaper();
   qp.set_id(qId);
	return questionDetailRepo.findByQuestionPaper(qp);
}
@Override
public Answer saveAnswer(String qId,String answer) {
	QuestionDetail qd=new QuestionDetail();
	qd.set_id(qId);
	Answer ans = new Answer();
	ans.setQuestionDetail(qd);
	ans.setAnswer(answer);
	return answerRepo.insert(ans);
}
@Override
public void deleteAnswer(String aId) {
	answerRepo.deleteById(aId);
}
@Override
public Answer getAnswer(String qId) {
	QuestionDetail qd=new QuestionDetail();
	qd.set_id(qId);	
	return answerRepo.findByQuestionDetail(qd);
}
@Override
	public List<QuestionPaper> getQuestionPapers(String cId) {
		Clas cls = new Clas();
		cls.set_id(cId);
		return questionPaperRepo.findByClas(cls);
	}
@Override
public QuestionPaper getQuestionPaper(String sId, String cId) {
	Subjec subjec=new Subjec();
	Clas clas=new Clas();
	subjec.set_id(sId);
	clas.set_id(cId);
	return questionPaperRepo.findBySubjectAndClas(subjec, clas);
}

}
