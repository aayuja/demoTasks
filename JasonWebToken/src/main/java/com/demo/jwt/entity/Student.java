package com.demo.jwt.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="StudentInfo")

public class Student {
	

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id ;
	
	@Column
	private String Name;
	@Column
	private String email;
	@Column
	private String phoneNumber;
	@Column
	private String passWord;
	

	@Column(name = "created" ,updatable = false)
    private LocalDateTime created = LocalDateTime.now();

	    
	    @Column(name = "updated" ,updatable = false)
	    private LocalDateTime updated = LocalDateTime.now();
	
	
	  
	  public int getId() {
			return id;
		}

      public void setId(int id) {
			this.id = id;
		}



   public String getName() {
			return Name;
		}




   public void setName(String name) {
			Name = name;
		}



   public String getEmail() {
			return email;
		}



   public void setEmail(String email) {
			this.email = email;
		}



   public String getPhoneNumber() {
			return phoneNumber;
		}



  public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

    public String getPassWord() {
			return passWord;
		}

   public void setPassWord(String passWord) {
			this.passWord = passWord;
		}

  public LocalDateTime getCreated() {
			return created;
		}

  public void setCreated(LocalDateTime created) {
			this.created = created;
		}


  public LocalDateTime getUpdated() {
			return updated;
		}



  public void setUpdated(LocalDateTime updated) {
			this.updated = updated;
		}

  public Student(int id, String name, String email, String phoneNumber, String passWord, LocalDateTime created,
			LocalDateTime updated) {
			super();
			this.id = id;
			Name = name;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.passWord = passWord;
			this.created = created;
			this.updated = updated;
		}


  @Override
		public String toString() {
			return "Student [id=" + id + ", Name=" + Name + ", email=" + email + ", phoneNumber=" + phoneNumber
					+ ", passWord=" + passWord + ", created=" + created + ", updated=" + updated + "]";
		}

  public Student() {}
}
	
	
	


