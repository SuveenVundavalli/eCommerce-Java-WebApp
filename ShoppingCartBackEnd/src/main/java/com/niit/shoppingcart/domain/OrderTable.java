package com.niit.shoppingcart.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderTable {

	@Id
	@GeneratedValue
	private int id;
	private String user_id;
	private String status;
	private Date date_ordered;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate_ordered() {
		return date_ordered;
	}
	public void setDate_ordered(Date date_ordered) {
		this.date_ordered = date_ordered;
	}
	
	
	
	
}
