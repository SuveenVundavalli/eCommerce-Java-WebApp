package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.My_Cart;

public interface My_CartDAO {
	
	public boolean save(My_Cart my_Cart);

	public boolean update(My_Cart my_Cart);
	
	public boolean delete(int id);
	
	public boolean deleteAllProductsInCart(String user_id);

	public List<My_Cart> list(String userID);
	
	public double getTotalAmount(String userID);
	
	public My_Cart getCartById(int id);

}
