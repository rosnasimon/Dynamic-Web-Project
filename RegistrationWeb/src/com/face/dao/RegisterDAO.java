package com.face.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import com.face.bo.RegisterBO;

public class RegisterDAO {
	
	public static final RegisterDAO regdao=new RegisterDAO();
	public static void Save(Connection con,RegisterBO rg)
	{
		try {
			Statement st=con.createStatement();
			String query="insert into register values('"+rg.getFname()+"','"+rg.getUname()+"','"+rg.getPwd()+"','"+rg.getCpwd()+"','"+rg.getMail()+"','"+rg.getMob()+"')";
			int result=st.executeUpdate(query);
			if(result==1) {
				System.out.println("Data inserted Successfully");
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
