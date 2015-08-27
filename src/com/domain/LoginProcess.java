package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginProcess {
	 public static User user = null;
	 public static List<User> users;
	 
	 
	public static boolean validate(String username,String userpass){  
		Connection con=null;
		 boolean status=false;  
		  try{  
			  String URL = "jdbc:mysql://localhost/struts_tutorial";
		         Class.forName("com.mysql.jdbc.Driver");
		         con = DriverManager.getConnection(URL, "root", "root");
		     
		   PreparedStatement ps=con.prepareStatement(  
		     "select * from login where username=? and pass=? and active='Y'"); 
		   ps.setString(1,username);  
		   ps.setString(2,userpass);  
		   ResultSet rs=ps.executeQuery();  
		   status=rs.next();  
		   user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
				   rs.getString(6),rs.getInt(7),rs.getString(8));
		  }catch(Exception e){
			  e.printStackTrace();
		   } 
		  finally
		  {
			  try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		 return status;  
		}  
	
	public static User getUser(int id)
	{	
		Connection con=null;	 
		  try{  
			  String URL = "jdbc:mysql://localhost/struts_tutorial";
		         Class.forName("com.mysql.jdbc.Driver");
		         con = DriverManager.getConnection(URL, "root", "root");
		     
		   PreparedStatement ps=con.prepareStatement(  
		     "select * from login where id=? "); 
		   ps.setInt(1,id); 
		   ResultSet rs=ps.executeQuery();  
		   if(rs.next()){ 
		   user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
				   rs.getString(6),rs.getInt(7),rs.getString(8));
		   }
		  }catch(Exception e){
			  e.printStackTrace();}  
		  finally
		  {
			  try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		 return user; 
	}
	
	public static List<User> getAllUsers()
	{
		
		List<User> holder = new ArrayList<User>();
		Connection conn = null;
		String URL = "jdbc:mysql://localhost/struts_tutorial";
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "root");
	         String sql="select * from login where (status = 0 or status = 2)";
	         Statement ps = conn.createStatement();
			 ResultSet rs=ps.executeQuery(sql);
			 while(rs.next())
			 {
				 
				 user=new User(rs.getInt(1), 
						 rs.getString(2), 
						 rs.getString(3), 
						 rs.getString(4), 
						 rs.getString(5), 
						 rs.getString(6),
						 rs.getInt(7), 
						 rs.getString(8));
				 		 holder.add(user);	
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
		users=holder;
		return users;
	}
	
	public static int findUserId(String username)
	{
		Connection conn=null;
		int id=-999;
		try{  
			String URL = "jdbc:mysql://localhost/struts_tutorial";
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "root");
	        String sql= "select * from login where username='"+username+"'"; 
	        Statement ps = conn.createStatement();
			 ResultSet rs=ps.executeQuery(sql);
			 while(rs.next())
			 {
				id= rs.getInt(1);
			 }
			 }catch(Exception e){
				  e.printStackTrace();
			  }
			 finally {
			        if (conn != null) {
				           try {
				              conn.close();
				           } catch (Exception e) {
				           		e.printStackTrace();
				           	 }
			        }
			}
		 return id;		
	}
	
	public static boolean changeUserActivity(int id, String active)
	{
		boolean status=false;
		
		Connection con=null;
		try {
			 String URL = "jdbc:mysql://localhost/struts_tutorial";
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "root");
	         PreparedStatement ps=con.prepareStatement("update login set active = ? where id = ?");	        		 
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
	
}
