package com.action;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.domain.CellPhone;
import com.domain.SearchDao;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String where;
	private List<CellPhone> cellphones;
	private List<CellPhone> initialPhones;
	
	private String sortType="";
	private int phoneid;
	private CellPhone cellphone;
	
	private boolean handlePaging=false;
	private int page=1;
	
	
	final int PAGE_SIZE = 4;
	//int numberOfPages = -1;
	static int  currentPage = -1;
	
	private int[] numberOfPages;
	
	
	
	public SearchAction(){
		
	}
	
	public String execute() throws Exception{
		
		 setCellphones(SearchDao.search(where,"Y"));
		 handlePaging(page);
		 return SUCCESS;
	}
	
	public String phoneDetail(){
	
		setCellphone(SearchDao.find(getPhoneid()));
		return SUCCESS;
	}
	
	public void handlePaging(int page)
	{
		System.out.println(page);
		
		int totalRec=cellphones.size();
		
		int numberOfPages=totalRec/PAGE_SIZE;
		
		
		
		if(totalRec%PAGE_SIZE>0)
			numberOfPages++;
	
		
		this.numberOfPages=new int[numberOfPages];
		for (int i = 0; i < numberOfPages; i++) {
			this.numberOfPages[i]=i+1;
		}
		
		int showFrom=(PAGE_SIZE)*(page-1);
		
		int page_size=cellphones.size()-showFrom;
		
		if(page_size>PAGE_SIZE)
			page_size=PAGE_SIZE;
		
		initialPhones=new ArrayList<CellPhone>();
		
		
		for (int i = showFrom; i < showFrom+page_size; i++) {
			
			try {
				initialPhones.add(cellphones.get(i));
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				break;
			}
		}
		
		if (sortType.equals("AZ")){
			 Collections.sort(initialPhones, CellPhone.CpNameASC);
		 }
		 else if(sortType.equals("ZA")){
			 Collections.sort(initialPhones,CellPhone.CpNameDESC);
		 } 
		 else if(sortType.equals("Inc")){
			 Collections.sort(initialPhones, CellPhone.CpPriceASC);
		 } 
		 else if(sortType.equals("Dec")){
			 Collections.sort(initialPhones,CellPhone.CpPriceDESC);
		 }
		
		
	}

	public List<CellPhone> getCellphones() {
		return cellphones;
	}

	public void setCellphones(List<CellPhone> cellphones) {
		this.cellphones = cellphones;
	}
	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public int getPhoneid() {
		return phoneid;
	}

	public void setPhoneid(int phoneid) {
		this.phoneid = phoneid;
	}

	public CellPhone getCellphone() {
		return cellphone;
	}

	public void setCellphone(CellPhone cellphone) {
		this.cellphone = cellphone;
	}

	public int[] getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int[] numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public List<CellPhone> getInitialPhones() {
		return initialPhones;
	}

	public void setInitialPhones(List<CellPhone> initialPhones) {
		this.initialPhones = initialPhones;
	}

	public boolean isHandlePaging() {
		return handlePaging;
	}

	public void setHandlePaging(boolean handlePaging) {
		this.handlePaging = handlePaging;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
	
	
		

}


