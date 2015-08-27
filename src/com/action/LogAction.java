package com.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.domain.BasketDao;
import com.domain.BasketItem;
import com.domain.LoginProcess;
import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport implements SessionAware{
	
	private String username;
	private String userpass;
	private Map<String,Object> sessionMap;
	private User user;



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserpass() {
		return userpass;
	}


	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String execute(){
		
		
		if(LoginProcess.validate(username, userpass)){ 
			
			user=LoginProcess.user;
			
			sessionMap.put("login", "true");
			sessionMap.put("name",username);
			sessionMap.put("userID", LoginProcess.findUserId(username));
			sessionMap.put("isAdmin", user.getStatus());
			sessionMap.put("Mybasket", BasketDao.getBasket(username));
			
			
			
			HttpServletRequest request=ServletActionContext.getRequest();  
			HttpSession session=request.getSession();  
			
			String s=(String)session.getAttribute("login");  
			
			System.out.println(s);
	        return SUCCESS;  
	    }  
	    else{  
	        return "error";  
	    }  
		

	}


	public String logout(){	
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		BasketDao.saveBasket((ArrayList<BasketItem>)session.getAttribute("Mybasket"),(Integer)session.getAttribute("userID"));
		sessionMap.clear();
		return SUCCESS;
	}


	@Override
	public void setSession(Map<String,Object> session) {
		// TODO Auto-generated method stub
		this.sessionMap=session;
		
	}
	
	

}
