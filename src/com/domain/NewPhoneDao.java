package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.action.NewPhoneAction;

public class NewPhoneDao {
	
	public static int save(NewPhoneAction n)
	{
		int status=0;
		Connection con=null;
		  try{  
			  String URL = "jdbc:mysql://localhost/struts_tutorial";
		         Class.forName("com.mysql.jdbc.Driver");
		         con = DriverManager.getConnection(URL, "root", "root");
		     
		         PreparedStatement ps=con.prepareStatement("insert into cellphones(name,date,os,cpu,memory,display,physical,price,brand,path,active) " +
		         			"values(?,?,?,?,?,?,?,?,?,?,?)");  
		         ps.setString(1,n.getName());  
		         ps.setString(2,n.getDate());  
		         ps.setString(3,n.getOs());  
		         ps.setString(4,n.getCpu());  
		         ps.setString(5,n.getMemory());  
		         ps.setString(6,n.getDisplay());
		         ps.setString(7,n.getPhysical());
		         ps.setInt(8, n.getPrice());
		         ps.setString(9, n.getBrand());
		         ps.setString(10, n.getImage());
		         ps.setString(11, "Y");
		         
		         status=ps.executeUpdate();  
		   
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		finally {
	        if (con != null) {
		           try {
		              con.close();
		           } catch (Exception e) {
		           		e.printStackTrace();
		           	 }
	        }
		}
		 return status;  
	}  
}


