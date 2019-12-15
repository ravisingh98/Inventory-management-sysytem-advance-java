package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.imsws.helper.QueryConstant;

public class CartDao {
	public ResultSet cart(String id) throws ClassNotFoundException, SQLException, NamingException {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet  rs=null;
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.cart_path);
	pst.setInt(1, Integer.parseInt(id));
	rs=pst.executeQuery();
	return rs;
}
	
	public ResultSet cartAll() throws ClassNotFoundException, SQLException, NamingException {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet  rs=null;
		con=CommonDao.getConnection();
		pst=con.prepareStatement(QueryConstant.cartall_path);
		rs=pst.executeQuery();
		return rs;
	}
	
}