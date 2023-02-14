package com.student.StudentAdmission.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Student")
public class Student {
	@Id
	private String id;
	private String first_name;
	private String last_name;
	private String emailid;
	private String dob;
	
	
//	public Student() {
//		super();
//	}
//	public Student(String first_name, String last_name, String emailid, String dob) {
//		super();
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.emailid = emailid;
//		this.dob = dob;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getFirst_name() {
//		return first_name;
//	}
//	public void setFirst_name(String first_name) {
//		this.first_name = first_name;
//	}
//	public String getLast_name() {
//		return last_name;
//	}
//	public void setLast_name(String last_name) {
//		this.last_name = last_name;
//	}
//	public String getEmailid() {
//		return emailid;
//	}
//	public void setEmailid(String emailid) {
//		this.emailid = emailid;
//	}
//	public String getDob() {
//		return dob;
//	}
//	public void setDob(String dob) {
//		this.dob = dob;
//	}
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", emailid=" + emailid
//				+ ", dob=" + dob + "]";
//	}	
//	
	
}
