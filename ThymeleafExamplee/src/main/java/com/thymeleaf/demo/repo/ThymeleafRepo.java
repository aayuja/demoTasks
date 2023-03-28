package com.thymeleaf.demo.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.thymeleaf.demo.entity.ThymeleafEntity;

@Repository
public class ThymeleafRepo {

	public  List<ThymeleafEntity> findAll() {
		
		List<ThymeleafEntity> employee= new ArrayList<>();
		employee.add(new ThymeleafEntity("A1" , "Minakshi" , "22"));
		employee.add(new ThymeleafEntity("A2" , "Akanksha" , "23"));
		employee.add(new ThymeleafEntity("A3" , "Sakshi" , "24"));
		employee.add(new ThymeleafEntity("A4" , "Sonakshi" , "25"));

		return employee;
	}
}
