package com.face.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.face.bo.AddProductBO;
import com.face.bo.UserAccount;
import java.sql.PreparedStatement;

public class DBUtils {

	public static UserAccount findUser(Connection conn, //
	           String userName, String password) throws SQLException {
	       String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
	               + " where a.User_Name = ? and a.password= ?";
	       PreparedStatement pstm = conn.prepareStatement(sql);
	       pstm.setString(1, userName);
	       pstm.setString(2, password);
	       ResultSet rs = pstm.executeQuery();
	       
	       if (rs.next()) {
	           String gender = rs.getString("Gender");
	           UserAccount user = new UserAccount();
	           user.setUserName(userName);
	           user.setPassword(password);
	           user.setGender(gender);
	           return user;
	       }
	       return null;
	   }
	
	public static AddProductBO addProduct(Connection conn, //
	           int pid,String pname, int price,int quantity) throws SQLException {
		try {
			Statement st=conn.createStatement();
			String query="insert into product values("+pid+",'"+pname+"',"+price+","+quantity+")";
			int result=st.executeUpdate(query);
			if(result==1) {
				System.out.println("Data inserted Successfully");
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	   }
	
	public static ArrayList<AddProductBO> getProductList(Connection conn)
	{
		ArrayList<AddProductBO> list=new ArrayList<AddProductBO>();
		try
		{
			Statement st=conn.createStatement();
			String query="select * from product";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				AddProductBO add=new AddProductBO();
				add.setPid(rs.getInt("pdt_id"));
				add.setPname(rs.getString("pname"));
				add.setPrice(rs.getInt("price"));
				add.setQuantity(rs.getInt("quantity"));
				list.add(add);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static boolean deleteProduct(Connection conn,int id)
	{
		try
		{
			Statement st=conn.createStatement();
			String query="delete from product where pdt_id = "+id;
			ResultSet re=st.executeQuery(query);
			while(re.next())
			{
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
