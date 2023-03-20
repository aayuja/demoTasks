package com.secure.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.secure.model.AcademicDetails;
import com.secure.model.College;
import com.secure.model.Course;
import com.secure.model.CourseCollege;
import com.secure.model.Password;
import com.secure.model.StudentCourseCollege;
import com.secure.model.StudentDetails;
import com.secure.model.User;

public interface IUserService {
	List<User> getAll();
	
	List<College> getAllCollege();
	
	List<Course> getAllCourse();
	
	List<CourseCollege> getAllCourseCollege();
	
	List<StudentCourseCollege> getAllStudentCourseCollege();

	User save(User student);
	
    College saveAllCollege(College college);
	
	Course saveAllCourse(Course course);
	
	CourseCollege saveAllCourseCollege(CourseCollege courseCollege);
	
	StudentCourseCollege saveAllStudentCourseCollege(StudentCourseCollege studentCourseCollege);

	

	UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException;

	String changePassword(String _id, Password password);

	void deleteAll();

	StudentDetails saveDetails(StudentDetails studentDetails,String phoneNo);

	AcademicDetails saveAcademicDetails(AcademicDetails academicDetails, String phoneNo);

	List<CourseCollege> getAllCourseOfCollege(String collegeId);

	StudentCourseCollege getAllCourseCollegeOfStudent(String studentId);

	String changePasswordNew(String phoneNo, Password password);


}