package com.secure.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.secure.model.StudentCourseCollege;
import com.secure.model.User;

@Repository
public interface StudentCourseCollegeRepository extends MongoRepository<StudentCourseCollege, String>{
	
public StudentCourseCollege findByUser(User user);
	
}
