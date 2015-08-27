package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.domain.BasketDao;
import com.domain.BasketItem;
import com.domain.Order;
import com.domain.Order.OrderDetail;
import com.domain.OrderDao;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> shipment;
	private String username;
	private int customerId;
	private String address;
	private String logistic;
	private int total;
	private List<Order> orders;
	private List<OrderDetail> orderDetails;
	private Map<String,Object> sessionMap;
	private List<BasketItem> myBasket;
	private int orderID;
	
	public OrderAction() {
		// TODO Auto-generated constructor stub
		
		shipment=new ArrayList<String>();
		shipment.add("Yurtiçi Kargo");
		shipment.add("Aras Kargo");
		shipment.add("MNG Kargo");
		shipment.add("Sürat Kargo");
	}
	
	public String gotoOrderPage(){
				
		return SUCCESS;
	}
	
	
	public String completeOrder()
	{
		System.out.println(logistic);
		System.out.println("CustomerId: "+customerId);
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		myBasket=(List<BasketItem>) session.getAttribute("Mybasket");
		
		
		for (int i = 0; i < myBasket.size(); i++) {
			total=total+(myBasket.get(i).getPrice()*myBasket.get(i).getQuantity());
		}
		
		if(OrderDao.finishOrder(customerId, address, logistic, total,myBasket)){
		
			
			myBasket=new ArrayList<BasketItem>();//initialing
			sessionMap.put("Mybasket", myBasket);
			return SUCCESS;
		
		}
		else
			return ERROR;
	}
	
	public String myOrders(){
		
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		
		orders=OrderDao.getMyOrders((Integer) session.getAttribute("userID"));
		
		return SUCCESS;
	}
	
	
	public String myOrderDetail(){
		//System.out.println("****" + this.orderID);
		orderDetails=OrderDao.getOrderDetails(this.orderID);
		return SUCCESS;
	}
	
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	

	public List<String> getShipment() {
		return shipment;
	}


	public void setShipment(List<String> shipment) {
		this.shipment = shipment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogistic() {
		return logistic;
	}

	public void setLogistic(String logistic) {
		this.logistic = logistic;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sessionMap=arg0;
	}	

}
