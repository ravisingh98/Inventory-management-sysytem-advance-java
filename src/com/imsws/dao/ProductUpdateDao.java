package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.imsws.helper.QueryConstant;

public class ProductUpdateDao {
	Connection con=null;
	PreparedStatement pst=null;
	int count;
	public int doUpdate(ArrayList<String> list) throws ClassNotFoundException, SQLException, NamingException {
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.doUpdate);
	pst.setString(1, list.get(1));
	pst.setInt(2, Integer.parseInt(list.get(2)));
	pst.setString(3, list.get(3));
	pst.setString(4, list.get(4));
	pst.setString(5, list.get(5));
	pst.setInt(6, Integer.parseInt(list.get(0)));
	count=pst.executeUpdate();
	return count;
	}

}
