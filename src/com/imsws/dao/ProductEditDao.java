package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.imsws.helper.QueryConstant;

public class ProductEditDao {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet  rs=null;
	public ResultSet doEdit(String id) throws ClassNotFoundException, SQLException, NamingException{
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.doEdit);
	pst.setInt(1, Integer.parseInt(id));
	rs=pst.executeQuery();
	return rs;
}
}