package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDao {
	
	private int id;
	private CellPhone cp;
	
	
	public static CellPhone sendPhone(int id)
	{
		int idn = 0;
		String name = null;
		String date=null;
		String os=null;
		String cpu=null;
		String memory=null;
		String display=null;
		String physical=null;
		String active=null;
		int price=0;
		String path=null;
		Connection con=null;  
		  try{  
			  String URL = "jdbc:mysql://localhost/struts_tutorial";
		         Class.forName("com.mysql.jdbc.Driver");
		         con = DriverManager.getConnection(URL, "root", "root");
		         PreparedStatement ps=con.prepareStatement("select * from cellphones where id=?");
		         ps.setInt(1, id);
		         ResultSet rs = ps.executeQuery();
		        
		         while(rs.next()){
		        	 idn=rs.getInt(1);
		        	 name=rs.getString(2);
		        	 date=rs.getString(3);
		        	 os=rs.getString(4);
		        	 cpu=rs.getString(5);
		        	 memory=rs.getString(6);
		        	 display=rs.getString(7);
		        	 physical=rs.getString(8);
		        	 price=rs.getInt(9);
		        	 active=rs.getString(11);
		        	 path=rs.getString(12);
		        	 
		        	 
		         }		         
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  finally{
			  try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  return new CellPhone(idn, name, date, os, cpu, memory, display, physical,price,active,path);
	}
	
	
	public static boolean updatePhoneActivity(int id,String active)
	{
		boolean status=false;	
		Connection con=null;
		try {
			 String URL = "jdbc:mysql://localhost/struts_tutorial";
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "root");
	         PreparedStatement ps=con.prepareStatement("update cellphones set active = ? where id = ?");	        		 
	         ps.setString(1, active);
	         ps.setInt(2, id);
	         ps.executeUpdate();
	         status=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
	
	
	public static boolean savePhone(int id,String name,String date,String os,String cpu,String memory,String display,String physical,int price,String path)
	{
		boolean status=false;
		Connection con=null;
		try {
			 String URL = "jdbc:mysql://localhost/struts_tutorial";
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "root");
	         PreparedStatement ps=con.prepareStatement("update cellphones set name=?,date=?,os=?,cpu=?,memory=?,display=?,physical=?,price=?,path=? where id = ?");	        		 
	         ps.setString(1, name);
	         ps.setString(2, date);
	         ps.setString(3, os);
	         ps.setString(4, cpu);
	         ps.setString(5, memory);
	         ps.setString(6, display);
	         ps.setString(7, physical);
	         ps.setInt(8, price);
	         ps.setInt(10,id);
	         ps.setString(9, path);
	         ps.executeUpdate();
	         status=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public static boolean saveProfile(int id,String full_name,String e_mail, String address)
	{
		boolean status=false;
		Connection con=null;
		try {
			 String URL = "jdbc:mysql://localhost/struts_tutorial";
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "root");
	         PreparedStatement ps=con.prepareStatement("update login set full_name=?,e_mail=?,adress=? where id = ?");	     
	         ps.setString(1, full_name);
	         ps.setString(2, e_mail);
	         ps.setString(3, address);
	         ps.setInt(4, id);
	         ps.executeUpdate();
	         status=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

}
