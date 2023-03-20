package com.secure.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.secure.model.User;

@Repository
public  interface UserRepository extends MongoRepository<User, String>{
	

@Query("{first_name: $0, password: $1}")
User findByFirstNameAndPassword(String firstName, String password);

//@Query("{phoneNo: $0}")
Optional<User> findByPhoneNo(String phoneNo);


@Query("{email: $0}")
Optional<User> findByEmail(String email);

//@Query("{_id: $0}")
//User getById(String _id);

//@Query("{password: $0, _id: $1}")
//boolean existsByPasswordAndId(String password, String _id);
    
}
