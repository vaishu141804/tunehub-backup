package com.kodnest.tunehub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@GeneratedValue(strategy=GenerationType.UUID)
	@Id
	String userid;
	String username;
	String email;
	String password;
	String role;
	String gender;
	String address;
	boolean ispremium;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userid, String username, String email, String password, String role, String gender,
			String address,boolean ispremium) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.gender = gender;
		this.address = address;
		this.ispremium = ispremium;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public  void setispremium(boolean ispremium) {
		this.ispremium = ispremium;
	}
	@Override
	public String toString() {
		return "user [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", gender=" + gender + ", address=" + address + ", ispremium ="+ispremium +"]";
	}
	public boolean isIspremium() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}