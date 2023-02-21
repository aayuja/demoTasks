package com.jwt.New.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jwt.New.model.User;

@Repository
public  interface UserRepository extends MongoRepository<User, String>{
	

@Query("{first_name: $0, password: $1}")
User findByFirstNameAndPassword(String firstName, String password);

@Query("{phoneNo: $0}")
User findByPhoneNumber(String phoneNo);


@Query("{email: $0}")
Optional<User> findByEmail(String email);
    
}
