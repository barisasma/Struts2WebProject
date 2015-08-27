package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.LoginProcess;
import com.domain.RegisterAccountDao;
import com.domain.UpdateDao;
import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateProfileAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String message="";
	private String full_name,e_mail,address;
	private int id;
	private User user;
	private static String mailOrigin="somebody@someone.com";
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";//e_mail validation constant
	
	public UpdateProfileAction(){
		e_mail="someone@someone.com";
	}
	
	
	public String execute()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  	  
		int s=(Integer)session.getAttribute("userID");  
		
		System.out.println(s);
		setUser(LoginProcess.getUser(s));
		e_mail=user.getE_mail();
		mailOrigin=e_mail;
		return SUCCESS;
	}
	
	public String save()
	{	  
		 if(e_mail.matches(EMAIL_REGEX)==false)//check for valid email
		   {
			  return ERROR;
		   }
		 
		 if(!mailOrigin.equals(e_mail))
		 {
			 boolean checkemail=RegisterAccountDao.isEmailExist(e_mail); 
			 if(checkemail)
				 return ERROR;
		 }
		
		if(UpdateDao.saveProfile(id,full_name,e_mail,address)){	
			HttpServletRequest request=ServletActionContext.getRequest();  
			HttpSession session=request.getSession();  	  
			int s=(Integer)session.getAttribute("userID");  
			setUser(LoginProcess.getUser(s));
			message="Profile updated!";
			return SUCCESS;
		}
		return ERROR;
	 }
		 
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public String getFull_name() {
		return full_name;
	}


	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}


	public String getE_mail() {
		return e_mail;
	}


	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
}
