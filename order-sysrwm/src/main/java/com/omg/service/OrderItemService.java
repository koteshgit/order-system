package com.omg.service;

import java.util.List;

import com.omg.entity.Order;
import com.omg.entity.OrderItem;
import com.omg.vo.OrderItemRequest;
import com.omg.vo.OrderItemResponse;
import com.omg.vo.OrderRequest;
import com.omg.vo.OrderResponse;

public interface OrderItemService {
	
	List<OrderItem> getAllOrderItems();
	
	OrderItemResponse findById(int id);
	
	OrderItem orderItemInsert(OrderItemRequest ot);
	
	boolean delete(int id);
	
	boolean update(OrderItemRequest o, int id);
	
}
