package com.action;

import com.domain.RegisterAccountDao;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	
	/*
	username varchar(255) not null,
    pass	varchar(255) not null,
    full_name varchar(255) not null,
    e_mail varchar(255) not null,
    adress varchar(255) not null,
	 */
	
	
	private String username;
	private String pass;
	private String confirmpass;
	private String fullname;
	private String email="example@something.com";
	private String address;
	private String control;
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";//e_mail validation constant
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public String execute()
		{
			return SUCCESS;
		}
		
		
		public String save()
		{
			if(RegisterAccountDao.insert(username, pass, fullname, email, address).equals("success")){	
				System.out.println("success");
				return SUCCESS;
			}
			else {
				System.out.println(control);
				return ERROR;
			}
		}
		
		public void validate(){
			
			boolean checkusername=RegisterAccountDao.isUsernameExist(username);
			boolean checkemail=RegisterAccountDao.isEmailExist(email);
					
			   if(email.matches(EMAIL_REGEX)==false)//check for valid email
			   {
				   addFieldError("email", getText("email.notValid"));
			   }
			
			  if(!pass.equals(confirmpass))
		         {
		        	 addFieldError("confirmpass","Please check your password");
		         }
			  
			  if(checkusername)
		         {
		        	 addFieldError("username","This user already exists");
		         }
			  
			  if(checkemail)
		         {
		        	 addFieldError("email","This email already exists");
		         }
		      
		         
		}

		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPass() {
			return pass;
		}


		public void setPass(String pass) {
			this.pass = pass;
		}


		public String getConfirmpass() {
			return confirmpass;
		}


		public void setConfirmpass(String confirmpass) {
			this.confirmpass = confirmpass;
		}


		public String getFullname() {
			return fullname;
		}


		public void setFullname(String fullname) {
			this.fullname = fullname;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}
		
}
