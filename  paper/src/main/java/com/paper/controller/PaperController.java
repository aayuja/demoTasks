package com.paper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.paper.service.PaperService;

@RestController
public class PaperController {

	@Autowired
	private PaperService paperService;
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

	// ----------save student
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		return paperService.saveStudent(student);
	}

	// ----------get list of student
	@GetMapping("/getStudent")
	public List<Student> getStudent() {
		return paperService.getStudent();

	}

	// -----------save clas
	@PostMapping("/saveClas")
	public Clas saveClas(@RequestBody Clas clas) {
		return paperService.saveClas(clas);
	}

	// ----------get list of clas
	@GetMapping("/getClas")
	public List<Clas> getClas() {
		return paperService.getClas();
	}

	// ------save Student class
	@PostMapping("/saveStudentClas")
	public StudentClas saveStudentClas(@RequestBody() StudentClas studentClas) {
		
		return paperService.saveStudentClas(studentClas);
	}

	// ------get List of student class
	@GetMapping("/getStudentClas")
	public List<StudentClas> getStudentClas() {
		return paperService.getStudentClas();
	}

	// ----save subject
	@PostMapping("/saveSubjec")
	public Subjec saveSubjec(@RequestBody() Subjec subjec) {
		return paperService.saveSubjec(subjec);
	}

	// ----save question paper
	@PostMapping("/saveQuestionPaper")
	public QuestionPaper saveQuestionPaper(@RequestBody()QuestionPaper questionPaper) {
		return paperService.saveQuestionPaper(questionPaper);
	}
	// get list of question paper of a particular class
	@GetMapping("/getQuestionPapers/{classId}")
    public List<QuestionPaper> getQuestionPapers(@PathVariable("classId") String cId)
    {
		return paperService.getQuestionPapers(cId);
		
    }
	// choose one question paper of a particular subject and of a particular class
	@GetMapping("/getQuestionPaper/{subjectId}/{classId}")
    public QuestionPaper getQuestionPaper(  @PathVariable("subjectId") String sId,
    		@PathVariable("classId") String cId)
    {
		return paperService.getQuestionPaper(sId,cId);
		
    }
	
	
	// -----save question detail --questions of a question paper
	@PostMapping("/saveQuestionDetail")
	public QuestionDetail saveQuestionDetail(@RequestBody()QuestionDetail QuestionDetail) {
		return paperService.saveQuestionDetail(QuestionDetail);
	}


    
	// get questions of a particular question paper
	@GetMapping("/getQuestion/{questionPaperId}")
	public List<QuestionDetail> getQuestionDetail(@PathVariable("questionPaperId") String qId) {
		return paperService.getQuestionDetail(qId);
	}
	
	
	// ---save answer to a particular question
	@PostMapping("/saveAnswer/{questionDetailId}")
	public Answer saveAnswer(@PathVariable("questionDetailId") String qId, @RequestBody String answer) {
		return paperService.saveAnswer(qId, answer);
	}

	// ----delete answer to a particular question
	@DeleteMapping("/deleteAnswer/{answerId}")
	public void deleteAnswer(@PathVariable("answerId") String aId) {
		paperService.deleteAnswer(aId);
	}

	// -----see answer of a particular question
	
	@GetMapping("/getAnswer/{questionDetailId}")
	public Answer getAnswer(@PathVariable("questionDetailId") String qId)
	{
		return paperService.getAnswer(qId);
	}
	// ----go to next question

	// ----go to previous question

	// timer

}
