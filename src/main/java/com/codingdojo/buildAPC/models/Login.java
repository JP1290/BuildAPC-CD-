package com.codingdojo.buildAPC.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Login {

	@NotEmpty(message = "Email can't be blank")
	@Email(message = "Invalid Email")
	private String email;
	@NotEmpty(message = "Password can't be blank")
	@Size(min = 5, max = 64, message = "")
	private String password;
	
	public Login() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
