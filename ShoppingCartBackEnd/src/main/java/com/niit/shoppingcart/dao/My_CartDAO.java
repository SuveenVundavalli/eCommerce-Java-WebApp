package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.My_Cart;

public interface My_CartDAO {
	
	public boolean save(My_Cart my_Cart);

	public boolean update(My_Cart my_Cart);

	public List<My_Cart> list(String userID);
	
	public double getTotalAmount(String userID);
	
	//no. of products also should display in UI
	//This we can get from list().size()

	//public My_Cart get(String id);

}
