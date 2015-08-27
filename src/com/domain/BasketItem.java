package com.domain;

public class BasketItem {
	
	private String productName;
	private int Quantity;
	private int price;
	private int productId;
	private int customerId;
	public BasketItem(String productName, int quantity,int price,int productId,int customerId)
	{
		setProductName(productName);
		setQuantity(quantity);
		setPrice(price);
		setProductId(productId);
		setCustomerId(customerId);
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}	
	
	
	

}
