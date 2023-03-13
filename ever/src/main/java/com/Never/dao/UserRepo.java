package com.Never.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Never.Entity.Password;
import com.Never.Entity.User;
@Repository
public interface UserRepo extends CrudRepository<User, Integer>{

	public void save(Password passw);

	public boolean existsByEmailAndPassword(String email, String password);
	
}
