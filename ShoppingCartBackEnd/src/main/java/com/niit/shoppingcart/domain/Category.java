package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
//@Table(name = "CATEGORY")
@Component
public class Category {
	@Id
	private String id;
	private String name;
	private String description;

	// If the relation is one-to-many we need to use the following

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private Set<Product> products;

	/*
	 * Each category may have n number of products. We use Set instead of List
	 * because Set does not have duplicates.
	 */

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
