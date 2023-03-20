package com.secure.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.secure.model.College;
import com.secure.model.CourseCollege;

@Repository
public interface CourseCollegeRepository extends MongoRepository<CourseCollege, String>{
	
	public List<CourseCollege> findByCollege(College college);
}


