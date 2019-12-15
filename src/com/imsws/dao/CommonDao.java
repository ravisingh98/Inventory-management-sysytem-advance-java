package com.imsws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public interface CommonDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/shopy","postgres","zxcv");
		
//		InitialContext initContext = new InitialContext();
//		Context context = (Context) initContext.lookup("java:comp/env");
//		DataSource dataSource = (DataSource)context.lookup("jdbc/shopy");
//		con = dataSource.getConnection();
		return con;
	}

}