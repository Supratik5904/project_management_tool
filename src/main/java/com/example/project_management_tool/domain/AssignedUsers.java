package com.example.project_management_tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ausers")
public class AssignedUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(updatable = false, unique = true)
	private String userNameString;
	@Column(name="name")
	private String fullNameString;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFullNameString() {
		return fullNameString;
	}
	public void setFullNameString(String fullNameString) {
		this.fullNameString = fullNameString;
	}
	public String getUserNameString() {
		return userNameString;
	}
	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
	
}
