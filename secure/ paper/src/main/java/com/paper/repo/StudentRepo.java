package com.paper.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paper.entity.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student,String> {
}
