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
import com.domain.CellPhone;
import com.domain.SearchDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.httpserver.Authenticator.Success;

public class BasketAction extends ActionSupport implements SessionAware{
	
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int price;
	private String where;
	private String productName;
	private int customerId;
	private List<CellPhone> cellphones;
	private CellPhone cellphone;
	private Map<String,Object> sessionMap;
	private String message;
	private int basketSize;
	private String username;
	private int quantity;
	private int totalPrice=0;
	private String isDetail="No";
	HttpServletRequest request=ServletActionContext.getRequest();  
	HttpSession session=request.getSession();
	private List<BasketItem> Mybasket=(ArrayList<BasketItem>)session.getAttribute("Mybasket");
	
	public BasketAction() {
		// TODO Auto-generated constructor stub
		super();
		
		
	}
	
	public String execute() throws Exception
	{
		setCellphones(SearchDao.search(where,"Y"));
		return SUCCESS;
	}
	
	public String addtoBasket(){
		
		
			for (int i = 0; i < Mybasket.size(); i++) {
				if(Mybasket.get(i).getProductName().equals(productName)){
					Mybasket.get(i).setQuantity(Mybasket.get(i).getQuantity()+1);
					sessionMap.put("Mybasket", Mybasket);
					return SUCCESS;
				}
			 }
			
			Mybasket.add(new BasketItem(productName, 1, price, getId(), customerId));
			sessionMap.put("Mybasket", Mybasket);
			
			
			message=SearchDao.find(getId()).getName()+"	added your basket successfully";
			return SUCCESS;
		
	}
	
	
	public String removeFromBasket(){
		
		for (int i = 0; i < Mybasket.size(); i++) {
			if(Mybasket.get(i).getProductId()==id){
				Mybasket.remove(i);
			}
		}
		sessionMap.put("Mybasket", Mybasket);
		
		return SUCCESS;
	}
	
	public String updateItemQuantity()
	{
		System.out.println(quantity);
		
		for (int i = 0; i < Mybasket.size(); i++) {
			if(Mybasket.get(i).getProductId()==id){
				Mybasket.get(i).setQuantity(quantity);
			}
		}
		
		
		return SUCCESS;
	}
	
	public String showBasket(){
		
		
		for (int i = 0; i < Mybasket.size(); i++) {
			totalPrice=totalPrice+(Mybasket.get(i).getPrice()*Mybasket.get(i).getQuantity());
		}
		return SUCCESS;
				
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public List<CellPhone> getCellphones() {
		return cellphones;
	}

	public void setCellphones(List<CellPhone> cellphones) {
		this.cellphones = cellphones;
	}

	public List<BasketItem> getMybasket() {
		return Mybasket;
	}

	public void setMybasket(List<BasketItem> mybasket) {
		Mybasket = mybasket;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getBasketSize() {
		return basketSize;
	}

	public void setBasketSize(int basketSize) {
		this.basketSize = basketSize;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductName() {
		return productName;
	}
	

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIsDetail() {
		return isDetail;
	}

	public void setIsDetail(String isDetail) {
		this.isDetail = isDetail;
	}

	public CellPhone getCellphone() {
		return cellphone;
	}

	public void setCellphone(CellPhone cellphone) {
		this.cellphone = cellphone;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
				this.sessionMap=session;
	}


}
