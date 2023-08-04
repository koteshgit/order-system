package com.omg.vo;

public class OrderItemResponse {
	private int itemId;
	private String itemName;

	public OrderItemResponse() {}

	public OrderItemResponse(int itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
