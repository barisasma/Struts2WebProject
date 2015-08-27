package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterAccountDao {
	
	public static String insert(String username,String password,String fullname,String email,String address){
		
		Connection con=null;
		try {
			
			 String URL = "jdbc:mysql://localhost/struts_tutorial";
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "root");
	         
	         /*
	          * username varchar(255) not null,
			    pass	varchar(255) not null,
			    full_name varchar(255) not null,
			    e_mail varchar(255) not null,
			    adress varchar(255) not null,
			    status int not null,
	          */
	        
	        
	         String sql = "insert into login(username,pass,full_name,e_mail,adress,status,active) values(?,?,?,?,?,?,?)";	         
	         PreparedStatement ps = con.prepareStatement(sql);
	         
	         ps.setString(1, username);
	         ps.setString(2, password);
	         ps.setString(3, fullname);
	         ps.setString(4, email);
	         ps.setString(5, address);
	         ps.setInt(6, 0);//0 means customer
	         ps.setString(7,"Y");
	         ps.execute();
	         
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		}
		
		return "success";
	}
	public static boolean isUsernameExist(String username)
	{
		Connection con=null;
		
		try {
			 String URL = "jdbc:mysql://localhost/struts_tutorial";
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "root");
	         String sql="select * from login where username = ?";
	         PreparedStatement ps=con.prepareStatement(sql);
	         ps.setString(1, username);
	         ResultSet rs=ps.executeQuery();
	         while(rs.next())
	         {
	        	 System.out.println(rs.getString(2)+"  isUserNameExist");
	        	 return true;
	         }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return false;
	}
	
	public static boolean isEmailExist(String email)
	{
		Connection con = null;
		try {
			 String URL = "jdbc:mysql://localhost/struts_tutorial";
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "root");
	         
	         String sql="select * from login where e_mail=?";
	         PreparedStatement ps=con.prepareStatement(sql);
	         ps.setString(1, email);	         
	         ResultSet rs=ps.executeQuery();
	         while(rs.next())
	         {
	        	 return true;
	         }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally 
		{
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return 	false;
	}
	

}
