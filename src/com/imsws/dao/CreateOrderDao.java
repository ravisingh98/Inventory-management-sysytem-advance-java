package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.imsws.helper.QueryConstant;

public class CreateOrderDao {

	Connection con=null;
	PreparedStatement pst=null;
	ResultSet  rs=null;
	public ResultSet Menu() throws ClassNotFoundException, SQLException, NamingException {
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.menu);
	rs=pst.executeQuery();
	return rs;
}
}
