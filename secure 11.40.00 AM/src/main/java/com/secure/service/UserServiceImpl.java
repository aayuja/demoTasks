package com.secure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.secure.model.AcademicDetails;
import com.secure.model.College;
import com.secure.model.Course;
import com.secure.model.CourseCollege;
import com.secure.model.Password;
import com.secure.model.StudentCourseCollege;
import com.secure.model.StudentDetails;
import com.secure.model.User;
import com.secure.repo.AcademicRepository;
import com.secure.repo.CollegeRepository;
import com.secure.repo.CourseCollegeRepository;
import com.secure.repo.CourseRepository;
import com.secure.repo.DetailRepository;
import com.secure.repo.StudentCourseCollegeRepository;
import com.secure.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository studentrepo;
	
	@Autowired
	private DetailRepository detailRepository;
	
	@Autowired
	private AcademicRepository academicRepository;
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired
	private CourseRepository courseRepository;	
	
	@Autowired
	private CourseCollegeRepository courseCollegeRepository;
	
	@Autowired
	private StudentCourseCollegeRepository studentCourseCollegeRepository;
	

	public List<User> getAll() {
		return studentrepo.findAll();
	}
     
//	public List<User> deleteAll() {
//		
//		return studentrepo.deleteAll();
//	}

	
      public void deleteAll() {
		studentrepo.deleteAll();
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
		User student = studentrepo.findByPhoneNo(phoneNo).get();
		System.out.println(student);
		System.out.println(student == null);
		return new org.springframework.security.core.userdetails.User(String.valueOf(student.getPhoneNo()), "",
				new ArrayList<>());
	}

	@Override
	public User save(User student) {
		System.out.println(student.toString());
		User savedStudent = studentrepo.insert(student);
		return savedStudent;
		
	}
	@Override
	public String changePassword(String _id, Password password) {
		System.out.println(_id+" id of student");
		User user= studentrepo.findById(_id).get();
		Boolean passMatch = new BCryptPasswordEncoder().matches(password.getOld_password(), user.getPassword());
		if(passMatch) {
			user.setPassword(new BCryptPasswordEncoder().encode(password.getNew_password()).toString());
			studentrepo.save(user);
			return "password changed";
		}
    else {
    	return "enter your old password correct...";
}
	}
	
	@Override
	public StudentDetails saveDetails(StudentDetails studentDetails,String phoneNo) {
		User user = studentrepo.findByPhoneNo(phoneNo).get();
		studentDetails.setUser(user);
		detailRepository.save(studentDetails);
		return studentDetails;
	}

	@Override
	public AcademicDetails saveAcademicDetails(AcademicDetails academicDetails, String phoneNo) {  
		 User user=studentrepo.findByPhoneNo(phoneNo).get();
		 academicDetails.setUser(user);
		 academicRepository.save(academicDetails);
		return academicDetails;
	}

	@Override
	public List<College> getAllCollege() {
		return collegeRepository.findAll();
	}
	
	@Override
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}
	@Override
	public List<CourseCollege> getAllCourseCollege() {
		return courseCollegeRepository.findAll();
	}
	@Override
	public List<StudentCourseCollege> getAllStudentCourseCollege() {
		return studentCourseCollegeRepository.findAll();
	}

	@Override
	public College saveAllCollege(College college) {
		return collegeRepository.insert(college);
	}

	@Override
	public Course saveAllCourse(Course course) {
		return courseRepository.insert(course);
	}

	@Override
	public CourseCollege saveAllCourseCollege(CourseCollege courseCollege) {
		
		return courseCollegeRepository.insert(courseCollege);
	}

	@Override
	public StudentCourseCollege saveAllStudentCourseCollege(StudentCourseCollege studentCourseCollege) {
		System.out.println(studentCourseCollege);
		return studentCourseCollegeRepository.insert(studentCourseCollege) ;
	}

	@Override
	public List<CourseCollege> getAllCourseOfCollege(String collegeId) {
		College college = new College();
		college.set_id(collegeId);
		return courseCollegeRepository.findByCollege(college);
	}

	@Override
	public StudentCourseCollege getAllCourseCollegeOfStudent(String studentId) {
		User user=new User();
		user.set_id(studentId);
		return  studentCourseCollegeRepository.findByUser(user);
	}

	@Override
	public String changePasswordNew(String phoneNo, Password password) {
		User user= studentrepo.findByPhoneNo(phoneNo).get();
		Boolean passMatch = new BCryptPasswordEncoder().matches(password.getOld_password(), user.getPassword());
		if(passMatch) {
			user.setPassword(new BCryptPasswordEncoder().encode(password.getNew_password()).toString());
			studentrepo.save(user);
			return "password changed";
		}
    else {
    	return "enter your old password correct...";
}
	}
	
}
