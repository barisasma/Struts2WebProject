package com.domain;

import java.util.Comparator;

public class CellPhone implements Comparable<CellPhone>{
	private int ID;
	private String name;
	private String date;
	private String ops;
	private String Cpu;
	private String memory;
	private String display;
	private String physical;
	private int    price;
	private String active;
	private String path;
	
	public CellPhone(int ID, String name,String date,String ops,String Cpu,String memory,String display,String physical,int price,String active,String path){
		setID(ID);
		setName(name);
		setCpu(Cpu);
		setDate(date);
		setDisplay(display);
		setMemory(memory);
		setOps(ops);
		setPhysical(physical);
		setPrice(price);
		setActive(active);
		setPath(path);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
	

	public String getOps() {
		return ops;
	}

	public void setOps(String ops) {
		this.ops = ops;
	}

	public String getCpu() {
		return Cpu;
	}

	public void setCpu(String cpu) {
		Cpu = cpu;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int compareTo(CellPhone o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static Comparator<CellPhone> CpNameASC
    = new Comparator<CellPhone>() {

		public int compare(CellPhone cp1, CellPhone cp2) {
		
		String phoneName1 = cp1.getName().toUpperCase();
		String phoneName2 = cp2.getName().toUpperCase();
		
		//ascending order
		return phoneName1.compareTo(phoneName2);
		
		}
	};
	
	public static Comparator<CellPhone> CpNameDESC
    = new Comparator<CellPhone>() {

		public int compare(CellPhone cp1, CellPhone cp2) {
		
		String phoneName1 = cp1.getName().toUpperCase();
		String phoneName2 = cp2.getName().toUpperCase();
		
		//ascending order
		//return phoneName1.compareTo(phoneName2);
		
		//descending order
		return phoneName2.compareTo(phoneName1);
		}
	};
	
	public static Comparator<CellPhone> CpPriceASC
    = new Comparator<CellPhone>() {

		public int compare(CellPhone cp1, CellPhone cp2) {
		
		int phonePrice1 = cp1.getPrice();
		int phonePrice2 = cp2.getPrice();
		
		//ascending order
		return phonePrice1-phonePrice2;
		
		//descending order
		//return phonePrice2-phonePrice1;
		}
	};
	
	public static Comparator<CellPhone> CpPriceDESC
    = new Comparator<CellPhone>() {

		public int compare(CellPhone cp1, CellPhone cp2) {
		
		int phonePrice1 = cp1.getPrice();
		int phonePrice2 = cp2.getPrice();
		
		//ascending order
		//return phonePrice1-phonePrice2;
		
		//descending order
		return phonePrice2-phonePrice1;
		}
	};
}
