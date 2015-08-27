package com.domain;

import java.util.List;



public class Order {
	
	private int orderID;
	private int customerID;
	private int total;
	private String adress;
	private String logistic;

	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setLogistic(String logistic) {
		this.logistic = logistic;
	}
	
	public String getLogistic() {
		return logistic;
	}
	
	
	
	
	public class OrderDetail{
		private CellPhone myPhone;
		private int quantity;
		
		public void setMyPhone(CellPhone myPhone) {
			this.myPhone = myPhone;
		}
		
		public CellPhone getMyPhone() {
			return myPhone;
		}
		
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	}
	
	
}
