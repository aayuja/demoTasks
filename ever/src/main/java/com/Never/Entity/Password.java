package com.Never.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Password {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	@Override
	public String toString() {
		return "Password [id=" + id + ", password=" + password + "]";
	}

	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Password(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	
	
    
	
}
