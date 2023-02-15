package com.demo.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.jwt.entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student , Integer> {

	boolean existsByphoneNumber(String phoneNumber);


	boolean existsByPassWord(String passWord);


	Student findByPhoneNumber(String phoneNo);

}
