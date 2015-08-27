package com.action;

import java.util.List;

import com.domain.CellPhone;
import com.domain.LoginProcess;
import com.domain.SearchDao;
import com.domain.UpdateDao;
import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CellPhone> cellphones;
	private List<User> users;
	private int id;
	private String currentactivity;

	public ListAction(){
		
	}
	
	public String goPhoneList()
	{
		cellphones=SearchDao.search(" ","ALL");
		return SUCCESS;
	}
	
	public String changePhoneActivity()
	{
		CellPhone cp=SearchDao.find(id);
		if(cp.getActive().equals("Y"))
			currentactivity="N";
		else
			currentactivity="Y";
		
		if(UpdateDao.updatePhoneActivity(id,currentactivity))
		{
			return SUCCESS;
		}
			return ERROR;
	}
	
	public String goUserList()
	{
		users=LoginProcess.getAllUsers();
		return SUCCESS;
	}
	
	public String changeUserActivity()
	{
		User user=LoginProcess.getUser(id);
		if(user.getActive().equals("Y"))
			currentactivity="N";
		else
			currentactivity="Y";
		
		if(LoginProcess.changeUserActivity(id,currentactivity))
		{
			return SUCCESS;
		}
		
		return ERROR;
	}

	public List<CellPhone> getCellphones() {
		return cellphones;
	}

	public void setCellphones(List<CellPhone> cellphones) {
		this.cellphones = cellphones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrentactivity() {
		return currentactivity;
	}

	public void setCurrentactivity(String currentactivity) {
		this.currentactivity = currentactivity;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
	
	
	
	

}
