package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.domain.Order.OrderDetail;

public class OrderDao {
	
	
	
	
	public static boolean finishOrder(int customer_id,String address,String logistic, int total,List<BasketItem> items){
		
		boolean status=false;
		String URL = "jdbc:mysql://localhost/struts_tutorial";
		
		Connection conn=null;
		Random randomNum = new Random();
		int randomInt = randomNum.nextInt(100000);
		//if generated order_id exists, generate again until getting unique order_id
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "root");
	        String sql= "select * from orders where id="+randomInt+"";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        	randomInt=randomNum.nextInt(100000);
	        	ps.clearBatch();
		        String sql1= "select * from orders where id="+randomInt+"";
		        ps=conn.prepareStatement(sql1);
		        rs=ps.executeQuery();  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "root");
	        String sql= "insert into orders values(?,?,?,?,?)"; 
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, randomInt);
	        ps.setInt(2, customer_id);
	        ps.setString(3, address);
	        ps.setString(4, logistic);
	        ps.setInt(5, total);
			ps.executeUpdate();	
			fillOrderDetails(items, randomInt);
			status=true;
			
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
	
	
	private static void fillOrderDetails(List<BasketItem> basketItem,int orderID){
		
		String URL = "jdbc:mysql://localhost/struts_tutorial";
		
		Connection conn=null;
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "root");
	        String sql= "insert into order_details values(?,?,?)"; 
	        PreparedStatement ps = conn.prepareStatement(sql);
	        
	        for (int i = 0; i < basketItem.size(); i++) {
				ps.setInt(1, orderID);
				ps.setInt(2, basketItem.get(i).getProductId());
				ps.setInt(3, basketItem.get(i).getQuantity());
				ps.executeUpdate();
				ps.clearParameters();
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
	
	public static List<Order> getMyOrders(int customerID){
		boolean status=false;
		String URL = "jdbc:mysql://localhost/struts_tutorial";
		Connection conn=null;
		
		List<Order> myorders=new ArrayList<Order>();
		List<OrderDetail> orderDetails= new ArrayList<OrderDetail>();
		
		Order order;//= new Order();
    	Order.OrderDetail orderDetail;
		
		try {
			
		
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "root");
	       
	        
	        
	        //String sql= "select * from orders where customer_id="+customerID+"";
	        
	        String sql="select * from orders where customer_id="+customerID+"";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){  
	        	order=new Order();
	        	order.setOrderID(rs.getInt(1));
	        	order.setAdress(rs.getString(3));
	        	order.setLogistic(rs.getString(4));
	        	order.setTotal(rs.getInt(5));     	
	        	myorders.add(order);
	        }
			
		} catch (Exception e) {
				// TODO: handle exception
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
		return myorders;
	}
	
	
	public static List<OrderDetail> getOrderDetails(int orderID){
		
		Connection conn=null;
		Order order=new Order();
		List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();
		OrderDetail od;
		String URL="jdbc:mysql://localhost/struts_tutorial";
		//if generated order_id exists, generate again until getting unique order_id
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "root");
	        String sql= "select * from order_details where order_id="+orderID+"";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	        	od=order.new OrderDetail();
	        	od.setMyPhone(SearchDao.find(rs.getInt(2)));
	        	od.setQuantity(rs.getInt(3));
	        	orderDetails.add(od);
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orderDetails;
	}

	

}
