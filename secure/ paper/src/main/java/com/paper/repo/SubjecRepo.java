package com.paper.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paper.entity.Subjec;

@Repository
public interface SubjecRepo extends MongoRepository<Subjec, String> {

}
