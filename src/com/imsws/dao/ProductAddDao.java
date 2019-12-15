package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.imsws.helper.QueryConstant;
public class ProductAddDao {
	Connection con=null;
	PreparedStatement pst=null;
	int count;
	public int doUpload(ArrayList<String> list) throws ClassNotFoundException, SQLException, NamingException {
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.doUpload);
	pst.setString(1, list.get(0));
	pst.setInt(2, Integer.parseInt(list.get(1)));
	pst.setString(3, list.get(2));
	pst.setString(4, list.get(3));
	pst.setInt(5, Integer.parseInt(list.get(4)));
	pst.setString(6, list.get(5));
	count=pst.executeUpdate();
	return count;
	}
}