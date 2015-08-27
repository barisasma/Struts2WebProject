package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchDao {
	
	
	private static List<CellPhone> cellphones;
	static String URL = "jdbc:mysql://localhost/struts_tutorial";
	static Connection conn = null;
	
	public static List<CellPhone> search(String where, String active)
	{	
		 CellPhone cellphone=null;
		 List<CellPhone> holder = new ArrayList<CellPhone>();
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "root");
	         String sql="";
	         
	         if(where.equals(" "))
	        	 sql="select * from cellphones";
	         else{
		         if(active.equals("ALL")){
		        	 sql= "select * from cellphones where (brand like '%"+where+"%' or name like '%"+where+"%' or date like '%"+where+"%' or os like '%"+where+"%' or cpu like '%"+where+"%' or physical like '%"+where+"%' or memory like '%"+where+"%' or display like '%"+where+"%')";
		         }
		         else{
		        	 sql= "select * from cellphones where (brand like '%"+where+"%' or name like '%"+where+"%' or date like '%"+where+"%' or os like '%"+where+"%' or cpu like '%"+where+"%' or physical like '%"+where+"%' or memory like '%"+where+"%' or display like '%"+where+"%') "
		         	 + "and active ='"+active+"'"; }
	         }
	         Statement ps = conn.createStatement();
			 ResultSet rs=ps.executeQuery(sql);
			 while(rs.next())
			 {
				 
				 cellphone=new CellPhone(
						 rs.getInt(1), 
						 rs.getString(2), 
						 rs.getString(3), 
						 rs.getString(4), 
						 rs.getString(5), 
						 rs.getString(6), 
						 rs.getString(7), 
						 rs.getString(8),
						 rs.getInt(9),
				 	     rs.getString(11),
				 	     rs.getString(12));
				 		 holder.add(cellphone);	
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cellphones=holder;
		return cellphones;
	}
	
	public static CellPhone find(int id){
		
		CellPhone cellphone=null;
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "root");
	         String sql= "select * from cellphones where id='"+id+"'"; 
	         Statement ps = conn.createStatement();
			 ResultSet rs=ps.executeQuery(sql);
			 while(rs.next())
			 {
				 
				 cellphone=new CellPhone(
						 rs.getInt(1), 
						 rs.getString(2), 
						 rs.getString(3), 
						 rs.getString(4), 
						 rs.getString(5), 
						 rs.getString(6), 
						 rs.getString(7), 
						 rs.getString(8),
						 rs.getInt(9),
						 rs.getString(11),
						 rs.getString(12));
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return cellphone;
	}
}
