package com.secure.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.secure.model.StudentDetails;

@Repository
public interface DetailRepository extends MongoRepository<StudentDetails, String>{
	

}
