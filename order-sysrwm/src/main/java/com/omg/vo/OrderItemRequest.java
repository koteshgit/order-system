package com.omg.vo;

public class OrderItemRequest {
	private String itemName;
	private int itemQuantity;

	public OrderItemRequest(String itemName, int itemQuantity) {
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}

	public OrderItemRequest() {
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "OrderItemRequest [itemName=" + itemName + ", itemQuantity=" + itemQuantity + "]";
	}
}
