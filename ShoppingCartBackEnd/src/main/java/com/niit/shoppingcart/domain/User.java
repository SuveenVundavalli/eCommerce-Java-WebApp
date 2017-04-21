package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


//Need to create singleton instance of this class
@Entity 
//to map the database table
@Table(name="User")
@Component // context.scan("com.niit") will scan the package and create singleton instance
public class User {
	
	@Id
	private String id;
	
	@Column(name="name") //if the field name in table and property name in class are different, then we require specify column name otherwise no need specify
	private String name;

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
