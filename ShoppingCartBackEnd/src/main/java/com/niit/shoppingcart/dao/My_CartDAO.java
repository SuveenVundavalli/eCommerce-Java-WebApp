package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.My_Cart;

public interface My_CartDAO {
	
	public boolean save(My_Cart my_Cart);

	public boolean update(My_Cart my_Cart);

	public List<My_Cart> list();

	public My_Cart get(String id);

}
