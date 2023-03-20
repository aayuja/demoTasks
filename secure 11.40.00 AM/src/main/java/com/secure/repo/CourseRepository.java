package com.secure.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.secure.model.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course, String>{
	

}
