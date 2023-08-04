package com.omg.service;

import java.util.List;

import com.omg.entity.Order;
import com.omg.vo.OrderRequest;
import com.omg.vo.OrderResponse;

public interface OrderService {
	
	List<Order> getAllOrders();
	
	OrderResponse findById(int id);
	
	Order orderInsert(OrderRequest o);
	
	void insertAll(List<OrderRequest> o);
	
	boolean delete(int id);
	
	boolean update(OrderRequest o, int id);
	
	boolean updateAll(List<OrderRequest> o, int id);
}
