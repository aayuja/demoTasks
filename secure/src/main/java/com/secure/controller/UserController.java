package com.secure.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.secure.config.JwtService;
import com.secure.config.TokenResponse;
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
import com.secure.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IUserService studentService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private DetailRepository DetailRepo;
	
	@Autowired
	private AcademicRepository academicRepo;
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseCollegeRepository courseCollegeRepository;
	
	@Autowired
	private StudentCourseCollegeRepository studentCourseCollegeRepository;
	
	
	@Autowired
	private JwtService jwtService;
	
	
	
	
	@GetMapping("/all")
	public List<User> getAll()
	{
		return studentService.getAll();
	}
	
	
	@GetMapping("/delete/all")
	public void deleteAll()
	{
		studentService.deleteAll();
	}
	
	
	@PostMapping("/saveDetails")
	public User save(@RequestBody User student)
	{
		student.setPassword(new BCryptPasswordEncoder().encode(student.getPassword()).toString());
		return studentService.save(student);
	} 
	
	@PostMapping("/login")
	public ResponseEntity<?> loginDetails(@RequestBody User student)
	{
		try {
			System.out.println(" student "+student.toString());
		   User stu = userRepo.findByPhoneNo(student.getPhoneNo()).orElseThrow(() -> new UsernameNotFoundException("User Not found"));
		   System.out.println(stu.toString()+" student "+student.toString());
		   Boolean passMatch = new BCryptPasswordEncoder().matches(student.getPassword(), stu.getPassword());
		   if(!passMatch) {
			   return ResponseEntity.badRequest().body(new String("Wrong Password"));
		   }
		   
//		   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getPhoneNo(), stu.getPassword()));
			String token="";
			TokenResponse tmessage= new TokenResponse ();
			if(stu== null) {
				return ResponseEntity.badRequest().body("Galat h re!");
			}
			
			final UserDetails userDetails =studentService.loadUserByUsername(String.valueOf(student.getPhoneNo())); 
			 token = jwtService.generateToken(userDetails);
			 System.out.println(token+" token");
				tmessage.setMessage("successfully login");
				tmessage.setToken(token);
				return ResponseEntity.ok().body(tmessage);
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage()+"error");
			e.getStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	@PostMapping("/changePassword/{_id}")
	public String changePassword(@PathVariable String _id, @RequestBody Password password)
	{
		try {
			return studentService.changePassword(_id,password);		
		}catch(Exception ex){
			ex.getStackTrace();
			System.out.println(ex.getLocalizedMessage()+" error");
			return ex.getLocalizedMessage();
		}
		
	}
	
	
	
	//---------------------------------------------Student information-------------------------------------------
	@PostMapping("/saveStuDetails")
	public StudentDetails saveDetails(@RequestBody() StudentDetails studentDetails)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(principal);
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		System.out.println("The username is" + username);
		return studentService.saveDetails(studentDetails,username);
	} 
	//--------------------------------------Academic Details---------------------------------------------------
	@PostMapping("/academicDetails")
	public AcademicDetails saveAcademicDetails(@RequestBody() AcademicDetails academicDetails)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		System.out.println("The username is" + username);
		return studentService.saveAcademicDetails(academicDetails,username);
	}
	
	//--------------------------------upload document

@PostMapping("/uploadDocument")
public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

    String fileName = file.getOriginalFilename();
    try {
      file.transferTo( new File("/home/ayuza/Documents/" + fileName));
    } catch (Exception e) {
    	e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } 
    return ResponseEntity.ok("File uploaded successfully.");
  }
	
	//----------------------------------------Course and college------------------------------------------
  
//-------------------------------------------C-----------------------------------------------------------

@PostMapping("/save/college")
public College saveCollege(@RequestBody College college)
{
	return studentService.saveAllCollege(college);
} 

@PostMapping("/save/course")
public Course saveCourse(@RequestBody Course course)
{
	return studentService.saveAllCourse(course) ;
} 

@PostMapping("/save/courseCollege")
public CourseCollege saveCourseCollege(@RequestBody CourseCollege courseCollege)
{
	return studentService.saveAllCourseCollege(courseCollege);
} 

@PostMapping("/save/studentCourseCollege")
public StudentCourseCollege saveStudentCourseCollege(@RequestBody StudentCourseCollege studentCourseCollege)
{
	return studentService.saveAllStudentCourseCollege(studentCourseCollege) ;
} 


//------------------------------------------R------------------------------------------------------------
@GetMapping("/all/college")
public List<College> getAllCollege()
{
	return studentService.getAllCollege();
}


@GetMapping("/all/course")
public List<Course> getAllCourse()
{
	return studentService.getAllCourse();
}

@GetMapping("/all/courseCollege")
public List<CourseCollege> getAllCourseCollege()
{
	return studentService.getAllCourseCollege();
}

@GetMapping("/all/studentCourseCollege")
public List<StudentCourseCollege> getAllStudentCourseCollege()
{
	return studentService.getAllStudentCourseCollege();
}

//get all course from coursecollege with college id
@GetMapping("/all/coursesOfCollege/{collegeId}")
public List<CourseCollege> getAllCoursesOfCollege(@PathVariable("collegeId") String collegeId)
{
	return studentService.getAllCourseOfCollege(collegeId);
}
//get all courseCollege from studentcoursecollege  with  the student id
@GetMapping("/all/courseCollegeOfStudent/{studentId}")
public StudentCourseCollege getAllCourseCollegeOfStudent(@PathVariable("studentId") String studentId)
{
	return studentService.getAllCourseCollegeOfStudent(studentId);
}
	
}

