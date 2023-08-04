package com.omg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omg.entity.Billing;
import com.omg.entity.Order;
import com.omg.entity.OrderItem;
import com.omg.repository.OrderItemRepository;
import com.omg.repository.OrderRepository;
import com.omg.vo.OrderItemRequest;
import com.omg.vo.OrderItemResponse;
import com.omg.vo.OrderRequest;
import com.omg.vo.OrderResponse;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private static final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);

	@Autowired
	private OrderItemRepository orderRepo;

	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public List<OrderItem> getAllOrderItems() {
		List<OrderItem> orderItems = orderItemRepo.findAll();
		return orderItems;
	}

	@Override
	public OrderItemResponse findById(int id) {
		OrderItem orderItem = orderItemRepo.findById(id).get();
		OrderItemResponse orderItemResponse = new OrderItemResponse(orderItem.getItemId(), orderItem.getItemName());
		return orderItemResponse;
	}

	@Override
	public OrderItem orderItemInsert(OrderItemRequest ot) {
		if (!ot.getItemName().isEmpty() && ot.getItemQuantity() != 0) {
			log.info("Inserting Order Item : {}", ot.toString());
			OrderItem itemObj = new OrderItem(ot.getItemQuantity(), ot.getItemName());
			orderItemRepo.save(itemObj);
			return itemObj;
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		if(id != 0) {
			log.info("Deleting  by Id: {}",id);
			orderItemRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean update(OrderItemRequest oitr, int id) {
		boolean isUpdated = false;
		OrderItem orderItemObj = new OrderItem(oitr.getItemQuantity(), oitr.getItemName());
		if(orderItemRepo.save(orderItemObj) != null) {
			isUpdated = true;
		}
		return isUpdated;
	}

}