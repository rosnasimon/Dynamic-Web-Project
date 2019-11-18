package com.face.dao;

import java.sql.Statement;

import com.face.bo.RegisterBO;
import com.face.util.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterDAO {
	
	ConnectionManager con=new ConnectionManager();
	public static boolean save(Connection connection, RegisterBO rg) throws SQLException {

		Statement st=connection.createStatement();
		String query="insert into register values('"+rg.getFname()+"','"+rg.getUname()+"','"+rg.getPwd()+"','"
						+rg.getCpwd()+"','"+rg.getEmail()+"')";
		int result=st.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data inserted successfully!!");
			return true;
		}
		else
		{
			System.out.println("A problem occurs");	
			return false;
		}
	}
}
