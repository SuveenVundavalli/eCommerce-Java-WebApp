package com.niit.shoppingcart.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "My_cart")
@Component
public class My_Cart {
	
	@Id
	@GeneratedValue
	private int id;
	private String user_id;
	private String product_name;
	private int price;
	private int quantity;
	private Date date_dded;
	
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDate_dded() {
		return date_dded;
	}
	public void setDate_dded(Date date_dded) {
		this.date_dded = date_dded;
	}
	 
	
	
	

}
