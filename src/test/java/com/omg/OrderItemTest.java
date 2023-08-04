package com.omg;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.omg.entity.Billing;
import com.omg.entity.Order;
import com.omg.entity.OrderItem;
import com.omg.service.OrderItemService;
import com.omg.vo.OrderItemRequest;
import com.omg.vo.OrderItemResponse;
import com.omg.vo.OrderRequest;

@DataJpaTest
public class OrderItemTest {

	@Autowired
	private OrderItemService orderItemService;

	@Test
	public void testGetOrderItems() throws Exception {
		List<OrderItem> orderItemsList = orderItemService.getAllOrderItems();
		assertNotNull(orderItemsList);
		assertNotEquals(orderItemsList.size(), 0);
	}
	
	@Test
	public void testGetOrderItemById() throws Exception {
		OrderItemResponse ordeItemResponse =  orderItemService.findById(2);
		assertNotNull(ordeItemResponse);
	}
	
	@Test
	public void testUpdateOrderItem() throws Exception {
		OrderItemRequest orderItemRequest = new OrderItemRequest();
		orderItemRequest.setItemName("Item22");
		orderItemRequest.setItemQuantity(15);
		
		boolean isUpdated =  orderItemService.update(orderItemRequest, 2);
		assertEquals(isUpdated, true);
	}
	

	@Test
	public void testCreateOrder() throws Exception {
		OrderItemRequest orderItemRequest = new OrderItemRequest();
		orderItemRequest.setItemName("Item22");
		orderItemRequest.setItemQuantity(10);

		OrderItem newOrderItem = orderItemService.orderItemInsert(orderItemRequest);
		assertNotNull(newOrderItem);
		assertEquals(newOrderItem.getItemQuantity(), 10);
	}
}
