package com.domain;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String full_name;
	private String e_mail;
	private String address;
	private int status; //is admin or not? 1 admin / 0  customer / 2 shopkeeper 
	private String active;
	
	public User(int id,String username,String password,String full_name,String e_mail,String address,int status,String active) {
		// TODO Auto-generated constructor stub
		setAddress(address);
		setE_mail(e_mail);
		setFull_name(full_name);
		setId(id);
		setUsername(username);
		setPassword(password);
		setStatus(status);
		setActive(active);
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
}
