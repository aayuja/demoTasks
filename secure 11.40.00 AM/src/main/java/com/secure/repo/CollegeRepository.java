package com.secure.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.secure.model.College;

@Repository
public interface CollegeRepository extends MongoRepository<College, String>{
	

}
