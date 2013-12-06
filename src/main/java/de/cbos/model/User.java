package de.cbos.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;


@Entity
@Table(name="users")
public class User {
	
    @Id
    @GeneratedValue
    private Integer userId;
    
    @NotBlank
    @RegExp(value="^[a-zA-Z0-9][a-zA-Z0-9 ]+$")
	private String fullName;
    
    @NotBlank
    @Email
	private String email;
    
    @NotBlank
	private String city;
    
    @NotBlank
	private String birthday;

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birth) {
		this.birthday = birth;
	}

}
