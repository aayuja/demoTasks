package com.paper.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paper.entity.Clas;

@Repository
public interface ClasRepo extends MongoRepository<Clas, String> {

}
