package com.system.StudentSystemApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.StudentSystemApplication.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String>{

@Query("{first_name: $0, password: $1}")
Student findByFirstNameAndPassword(String firstName, String password);

@Query("{phoneNo: $0}")
Student findByPhoneNumber(String phoneNo);
    
}
