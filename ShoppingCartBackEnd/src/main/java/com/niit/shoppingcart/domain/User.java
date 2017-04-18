package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


//Need to create singleton instance of this class
@Entity 
//to map the database table
@Table(name="User")
public class User {
	
	@Id
	private String id;
	
	@Column(name="name") //if the field name in table and property name in class are different, then we require specify column name otherwise no need specify
	private String name;
	@Min(5)
	@Max(15)
	private String password;
	private String contact;
	private String role;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
