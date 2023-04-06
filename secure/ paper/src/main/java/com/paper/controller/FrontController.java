package com.paper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paper.entity.Student;
import com.paper.entity.ThymeleafEntity;
import com.paper.repo.AnswerRepo;
import com.paper.repo.ClasRepo;
import com.paper.repo.QuestionDetailRepo;
import com.paper.repo.QuestionPaperRepo;
import com.paper.repo.StudentClasRepo;
import com.paper.repo.StudentRepo;
import com.paper.repo.SubjecRepo;
import com.paper.repo.ThymeleafRepo;
import com.paper.service.PaperService;

@Controller
public class FrontController {

	@Autowired
	private ThymeleafRepo thymeleafrepo;

	// -----------test------------------
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String getDataList(Model model) {
		List<ThymeleafEntity> empList = thymeleafrepo.findAll();
		model.addAttribute("empList", empList);
		return "employeeList";

	}


}
