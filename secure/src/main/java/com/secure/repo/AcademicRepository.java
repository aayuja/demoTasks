package com.secure.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.secure.model.AcademicDetails;

@Repository
public interface AcademicRepository extends MongoRepository<AcademicDetails, String>{
	

}
