package com.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.domain.CellPhone;
import com.domain.SearchDao;
import com.opensymphony.xwork2.ActionSupport;

public class NavigationAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  List<CellPhone> cellphones;
	List<CellPhone> dummyPhoneList;
	

	public String goregisterpage()
	{
		return SUCCESS;
	}
	
	public String gocompleteorderpage()
	{
		return SUCCESS;
	}
	
	public String goToHome()
	{
		return SUCCESS;
	}
	
	public String goIndex()
	{		
		cellphones=SearchDao.search(" ","Y");
		Random rand = new Random();
		List<Integer> randomNumbers=new ArrayList<Integer>();
		int g=4;
		int e;
		int f=cellphones.size();
		dummyPhoneList=new ArrayList<CellPhone>();
		
		for (int i = 0; i < g ; i++) {
			
			do {
					e=rand.nextInt(f);
					
				} while (randomNumbers.contains(e));
			
			randomNumbers.add(e);
		}
		
		for (int i = 0; i < randomNumbers.size(); i++) {
			
			//System.out.println(cellphones.get(randomNumbers.get(i)).getName());
			dummyPhoneList.add(cellphones.get(randomNumbers.get(i)));
	
		}
				
		return SUCCESS;
	}

	public List<CellPhone> getDummyPhoneList() {
		return dummyPhoneList;
	}

	public void setDummyPhoneList(List<CellPhone> dummyPhoneList) {
		this.dummyPhoneList = dummyPhoneList;
	}
	
	
	
	
	

}
