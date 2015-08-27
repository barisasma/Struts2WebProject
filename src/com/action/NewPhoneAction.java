package com.action;

import java.util.ArrayList;
import java.util.List;

import com.domain.NewPhoneDao;
import com.opensymphony.xwork2.ActionSupport;

public class NewPhoneAction extends ActionSupport{
	private String name,date,os,cpu,memory,display,physical,brand,image;
	private int price;
	private String message;
	private List<String> brands;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewPhoneAction(){
		
		brands=new ArrayList<String>();
		brands.add("SAMSUNG");
		brands.add("LG");
		brands.add("APPLE");
		brands.add("SONY");
		brands.add("HTC");
		brands.add("ASUS");
		brands.add("NEXUS");
		
	}
	
	public String execute()
	{
		if(NewPhoneDao.save(this)>0){
			setMessage("Item added succesfully to database: " +name);
			name="";
			date="";
			os="";
			cpu="";
			memory="";
			display="";
			physical="";
			image="";
			price=0;
			return SUCCESS;
		}
		else 
			return ERROR;
	}
	
	
	public String goNewPhonePage()
	{
		return SUCCESS;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getPhysical() {
		return physical;
	}

	public void setPhysical(String physical) {
		this.physical = physical;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<String> getBrands() {
		return brands;
	}

	public void setBrands(List<String> brands) {
		this.brands = brands;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	
	
	
}
