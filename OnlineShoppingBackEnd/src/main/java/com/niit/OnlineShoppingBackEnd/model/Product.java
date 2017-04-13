package com.niit.OnlineShoppingBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * @Entity		- object to table relation
 * @Table		- Used for alias name of table
 * @Component 	- to access generic type of object
 */

@Entity
@Table(name="product_info")
@Component
public class Product {
	@Id
	private int id;
	private String name;
	private String description;
	private String price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
