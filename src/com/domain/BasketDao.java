package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class BasketDao {
	
	
	static String URL = "jdbc:mysql://localhost/struts_tutorial";
	static Connection conn = null;
	
	public static int addToBasket(String username,int productId,int price)
	{
		int status=0;
		int customerId=LoginProcess.findUserId(username);
	
		  try{  
			  
		         Class.forName("com.mysql.jdbc.Driver");
		         conn = DriverManager.getConnection(URL, "root", "root");
		         String sql="select * from basket where customer_id="+customerId+" and product_id="+productId+"";
		         PreparedStatement ps2=conn.prepareStatement(sql);
		         ResultSet rs=ps2.executeQuery();
		         if(rs.next()){
		        	 int l_quantity = rs.getInt(3);
		        	 sql="update basket set quantity="+(l_quantity+1)+" where customer_id="+customerId+" and product_id="+productId+"";
		        	 ps2.execute(sql);
		         }
		         else{
		         PreparedStatement ps=conn.prepareStatement("insert into basket(customer_id,product_id,price,quantity) "+
		         			"values(?,?,?,?)");  
		         ps.setInt(1,customerId);  
		         ps.setInt(2,productId); 
		         ps.setInt(3, price);
		         ps.setInt(4, 1);
		         status=ps.executeUpdate();  
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
		 return status;  
	}
	
	public static void updateBasketQuantity(String username, int productId,int newQuantity)
	{
		int customerId=LoginProcess.findUserId(username);
		  try{  
			  if (newQuantity==0) {
				System.out.println(newQuantity);
			 }
			  else{
		         Class.forName("com.mysql.jdbc.Driver");
		         conn = DriverManager.getConnection(URL, "root", "root");
		         String sql="select * from basket where customer_id="+customerId+" and product_id="+productId+"";
		         PreparedStatement ps2=conn.prepareStatement(sql);
		         ResultSet rs=ps2.executeQuery();
		         if(rs.next()){
		        	 sql="update basket set quantity="+(newQuantity)+" where customer_id="+customerId+" and product_id="+productId+"";
		        	 ps2.execute(sql);
		        	 System.out.println(newQuantity);
		         }
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
	  
	}
	
	public static int removeFromBasket(String username,int productId){
	
		int customerId=LoginProcess.findUserId(username);
		int status = 0;
	
		  try{  
			  
		         Class.forName("com.mysql.jdbc.Driver");
		         conn = DriverManager.getConnection(URL, "root", "root");
		     
		         PreparedStatement ps=conn.prepareStatement("delete from basket where customer_id=? and product_id=?" );  
		         ps.setInt(1,customerId);  
		         ps.setInt(2,productId);  
		         status=ps.executeUpdate();  
		         	   
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
		 return status;  
		
	}
	
	public static List<BasketItem> getBasket(String username)
	{
		int customerId=LoginProcess.findUserId(username);
		return getItems(customerId);
	}
	
	
	public static List<BasketItem> getItems(int id)
	{
		
		List<BasketItem> items= new ArrayList<BasketItem>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "root");
	        String sql= "select * from basket where customer_id="+id+""; 
	        Statement ps = conn.createStatement();
			ResultSet rs=ps.executeQuery(sql);
			 while(rs.next())
			 {
				String productName = SearchDao.find(rs.getInt(2)).getName();
				BasketItem basketitem=new BasketItem(productName, rs.getInt(3), rs.getInt(4),rs.getInt(2),rs.getInt(1));
				items.add(basketitem); 
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
		 return  items;
		
	}
	
	
	public static void saveBasket(ArrayList<BasketItem> basket,int customerId){
		
	
		//int customerId=LoginProcess.findUserId(username);
	
		  try{  
			  
		         Class.forName("com.mysql.jdbc.Driver");
		         conn = DriverManager.getConnection(URL, "root", "root");
		         String sql="delete from basket where customer_id="+customerId;
		         PreparedStatement ps2=conn.prepareStatement(sql);
		         
		         ps2.executeUpdate();
		         
		         ps2.clearBatch();
		         
		         for (int i = 0; i < basket.size(); i++) {
		        	 PreparedStatement ps=conn.prepareStatement("insert into basket(customer_id,product_id,price,quantity) "+
			         			"values(?,?,?,?)");  
			         ps.setInt(1,customerId);  
			         ps.setInt(2,basket.get(i).getProductId()); 
			         ps.setInt(3, basket.get(i).getPrice());
			         ps.setInt(4, basket.get(i).getQuantity());
			         ps.executeUpdate();
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
		 
		
	}

}

	
