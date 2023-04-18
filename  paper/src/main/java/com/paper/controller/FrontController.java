package com.paper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paper.entity.AnswerSubmitted;
import com.paper.entity.Clas;
import com.paper.entity.ClasSubjecDTO;
import com.paper.entity.QuestionDetail;
import com.paper.entity.QuestionPaper;
import com.paper.entity.Student;
import com.paper.entity.Subjec;
import com.paper.entity.ThymeleafEntity;
import com.paper.repo.AnswerRepo;
import com.paper.repo.ClasRepo;
import com.paper.repo.QuestionDetailRepo;
import com.paper.repo.QuestionPaperRepo;
import com.paper.repo.StudentClasRepo;
import com.paper.repo.StudentRepo;
import com.paper.repo.SubjecRepo;
import com.paper.repo.ThymeleafRepo;

@Controller
public class FrontController {

	@Autowired
	private ThymeleafRepo thymeleafrepo;

	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private ClasRepo clasRepo;
	@Autowired
	private StudentClasRepo studentClasRepo;
	@Autowired
	private SubjecRepo subjecRepo;
	@Autowired
	private QuestionPaperRepo questionPaperRepo;
	@Autowired
	private QuestionDetailRepo questionDetailRepo;
	@Autowired
	private AnswerRepo answerRepo;

	// -----------test------------------
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String getDataList(Model model) {
		List<ThymeleafEntity> empList = thymeleafrepo.findAll();
		model.addAttribute("empList", empList);
		return "employeeList";

	}

	@GetMapping("/homePage")
	// see list of classes --/
	public String homePage() {
		return "home";
	}

	// register student --/savestudent
	@GetMapping("/registerStudent")
	public String registerStudent(ModelMap map) {
		Student student = new Student();
		map.addAttribute("student", student);
		return "registerStudent";
	}

	@PostMapping("/registeringStudent")
	public String registeringStudent(@ModelAttribute("student") Student s) {
		ModelMap mv = new ModelMap();
		studentRepo.insert(s);
		mv.addAttribute("status", "Student Saved");
		return "home";
	}

	// login
	// see list of class
	@GetMapping("/classList")
	public String classList(ModelMap map) {
		List<Clas> cl = clasRepo.findAll();
		List<Subjec> sl = subjecRepo.findAll();
		ClasSubjecDTO clasSubDto = new ClasSubjecDTO();
		map.addAttribute("clasSub", clasSubDto);
		map.addAttribute("classList", cl);
		map.addAttribute("subjectList", sl);
		return "classList";
	}

	// choose your class --/saveStudentClas
	@PostMapping("/choosingClass")
	public String choosingClass(@ModelAttribute("clasSubjec") ClasSubjecDTO csd, ModelMap mv) {
		System.out.println(csd.getSubjec_id()+"<<<<<<<>>>>>>>"+ csd.getClas_id());
		Clas clas = new Clas();
		
		
		clas.set_id(csd.getClas_id());

		Subjec subjec = new Subjec();
		subjec.set_id(csd.getSubjec_id());
		System.out.println(subjec.get_id()+"<<<<<<<>>>>>>>"+ clas.get_id());
		QuestionPaper qp = questionPaperRepo.findBySubjectAndClas(subjec, clas);
		List<QuestionDetail> qd=questionDetailRepo.findByQuestionPaper(qp);
		System.out.println(qp.get_id()+"<<<<<<<>>>>>>>"+ qd.size());
		mv.addAttribute("questionPaper", qd);
		AnswerSubmitted as=new AnswerSubmitted();
		mv.addAttribute(as);
		return "questionPaper";
		
	}
	
}
