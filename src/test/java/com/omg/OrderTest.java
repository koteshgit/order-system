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
import com.omg.service.OrderService;
import com.omg.vo.OrderRequest;
import com.omg.vo.OrderResponse;

@DataJpaTest
public class OrderTest {

	@Autowired
	private OrderService orderService;

	@Test
	public void testGetOrders() throws Exception {
		List<Order> ordersList = orderService.getAllOrders();
		assertNotNull(ordersList);
		assertNotEquals(ordersList.size(), 0);
	}
	
	@Test
	public void testGetOrderById() throws Exception {
		OrderResponse orderResponse =  orderService.findById(2);
		assertNotNull(orderResponse);
	}
	
	@Test
	public void testUpdateOrder() throws Exception {
		OrderRequest updateOrderRequest = new OrderRequest();
		updateOrderRequest.setOrderStatus("Accepted");
		updateOrderRequest.setSubtotal(550);
		updateOrderRequest.setTax(30);
		updateOrderRequest.setShippingCharges(15);
		updateOrderRequest.setTotal(600);
		boolean isUpdated =  orderService.update(updateOrderRequest, 2);
		assertEquals(isUpdated, true);
	}
	

	@Test
	public void testCreateOrder() throws Exception {
		OrderRequest order = new OrderRequest();
		order.setOrderStatus("Accepted");
		order.setSubtotal(500);
		order.setTax(20);
		order.setShippingCharges(12);
		order.setTotal(532);

		Billing billing = new Billing("Renner Road", "Praire Creek", "Dallas", "Texas", 75258);
		order.setBilling(billing);

		OrderItem orderItem = new OrderItem(1, "Laptop");
		List<OrderItem> listOrderItem = new ArrayList<>();
		listOrderItem.add(orderItem);
		order.setOrderItem(listOrderItem);

		Order newOrder = orderService.orderInsert(order);
		assertNotNull(newOrder);
		assertEquals(newOrder.getTotal(), 532);
	}
}
