package com.secure.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("User")
public class User implements UserDetails{

	@Id
	private String _id;
	private String first_name;
	private String last_name;
	private String email;
	@Indexed(unique = true)
	private String phoneNo;
	private String password;
	private String dob;
	
	 @DocumentReference(lazy = true, lookup = "{ 'user' : ?#{#self._id} }")
	 @JsonIgnoreProperties(value = {"user"}, allowGetters = false)
	 @ReadOnlyProperty
	 private StudentDetails studentDetails;
	 
	 @DocumentReference(lazy = true, lookup = "{ 'user' : ?#{#self._id} }")
	 @ReadOnlyProperty
	 @JsonIgnoreProperties(value = {"user"}, allowGetters = false)
	 private AcademicDetails academicDetails;
	 
	 @DocumentReference(lazy = true, lookup = "{ 'user' : ?#{#self._id} }")
	 @ReadOnlyProperty
	 @JsonIgnoreProperties(value = {"user"}, allowGetters = false)
	 private  StudentCourseCollege studentCourseCollege;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList();
	}

	@Override
	public String getPassword() {
	    return this.password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.phoneNo;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return "test";
	}
}
