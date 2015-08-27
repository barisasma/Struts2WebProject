package com.action;

import com.domain.CellPhone;
import com.domain.UpdateDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdatePhoneAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name,date,os,cpu,memory,display,physical,path;
	private int price;
	CellPhone cp;
	private String message;

	public String execute()
	{
		cp=getPhone(getId());
		name=cp.getName();
		date=cp.getDate();
		os=cp.getOps();
		cpu=cp.getCpu();
		memory=cp.getMemory();
		display=cp.getDisplay();
		physical=cp.getPhysical();
		price=cp.getPrice();
		path=cp.getPath();
		
		System.out.println(cp.getName());
		System.out.println(id);
		
		return SUCCESS;
	}
	public String save()
	{
		if(UpdateDao.savePhone(id,name,date,os,cpu,memory,display,physical,price,path)){
			setMessage("Item succesfully updated!");
			return SUCCESS;
		}
		else
			return ERROR;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CellPhone getCp() {
		return cp;
	}

	public void setCp(CellPhone cp) {
		this.cp = cp;
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
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public CellPhone getPhone(int id)
	{
		return UpdateDao.sendPhone(id);
	}

	
	
}
