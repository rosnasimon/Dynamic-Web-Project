package com.face.util;
	import java.io.FileInputStream;
	import java.io.InputStream;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class MySQLConnUtils {

		static Connection con=null;
		public static Properties loadPropertiesFile() throws Exception{
			Properties prop=new Properties();
			InputStream in=new FileInputStream("C:\\Users\\user_2\\eclipse-workspace\\SampleWebApp\\resources\\jdbc.properties");
			prop.load(in);
			in.close();
			return prop;
		}
		public static Connection getConnection() throws Exception {

			Properties prop=loadPropertiesFile();
			final String driver=prop.getProperty("driver");
			final String url=prop.getProperty("url");
			final String username=prop.getProperty("username");
			final String password=prop.getProperty("password");
			
			try {
				Class.forName(driver);
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
				throw e;
			}
			try {
				con=DriverManager.getConnection(url,username,password);
			}
			catch(SQLException e)
			{
				System.out.println("Connection Failed!!");
				e.printStackTrace();
			}
			return con;
		}
}
	
