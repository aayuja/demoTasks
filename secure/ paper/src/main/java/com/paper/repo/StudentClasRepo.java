package com.paper.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paper.entity.StudentClas;

@Repository
public interface StudentClasRepo extends MongoRepository<StudentClas,String> {

}
