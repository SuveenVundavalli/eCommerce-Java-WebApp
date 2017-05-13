package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.OrderTable;

public interface OrderTableDAO {
	
	public boolean save(OrderTable orderTable);
	public List<OrderTable> list(String userId);

}
