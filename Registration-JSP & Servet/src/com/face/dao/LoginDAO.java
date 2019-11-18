package com.face.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.face.bo.LoginBO;
import com.face.bo.RegisterBO;
import com.face.util.ConnectionManager;

public class LoginDAO {
	
	ConnectionManager con=new ConnectionManager();
	public static boolean check(Connection connection,LoginBO lbo,RegisterBO reg) throws SQLException 
	{
		boolean status = false;
		Statement st=connection.createStatement();
		String query="select uname,pwd,fname,email from register";
		ResultSet result=st.executeQuery(query);
		while(result.next())
		{
			if(result.getString(1).equals(lbo.getUsername())&&result.getString(2).equals(lbo.getPassword()))
			{
				//System.out.println("Logged Successfully!!!\n");	
				status= true;
				reg.setFname(result.getString(3));
				reg.setUname(result.getString(1));
				reg.setEmail(result.getString(4));
				break;
			}
			else
			{
				status= false;
				//System.out.println("panipali");
			}
		}
		return status;
		
	}
}
