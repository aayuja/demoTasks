package com.student.StudentAdmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.StudentAdmission.model.Student;
import com.student.StudentAdmission.repo.StudentRepo;

@Service
public class StudentService {

@Autowired
private StudentRepo studentrepo;

public List<Student> getAll()
{
	return studentrepo.findAll();
}

public Student save(Student student) {
	System.out.println(student.toString());
	Student savedStudent = studentrepo.insert(student);
	return savedStudent;
}


}
