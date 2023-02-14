package com.student.StudentAdmission.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.StudentAdmission.model.Student;

public interface StudentRepo extends MongoRepository<Student, String>{

}
