package com.thymeleaf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thymeleaf.demo.entity.ThymeleafEntity;
import com.thymeleaf.demo.repo.ThymeleafRepo;

@Controller
public class ThymeleafController {

	@Autowired
	private ThymeleafRepo thymeleafrepo;
	
	@RequestMapping(value = "/employeeList" , method = RequestMethod.GET)
	public String getDataList(Model model) {
		List<ThymeleafEntity> empList =  thymeleafrepo.findAll();
		model.addAttribute("empList", empList);
		return "employeeList";
		
	}
	
	@GetMapping("/hey")
	public String hello(@RequestParam String name,Model model)
	{
		model.addAttribute("name",name);
		return "hello";
	}
	
	
	
}
