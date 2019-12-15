package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.imsws.helper.QueryConstant;

public class StockUpdateDao {
	Connection con=null;
	PreparedStatement pst=null;
	int count;
	public int doUpdate(ArrayList<String> list) throws ClassNotFoundException, SQLException, NamingException {
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.doSUpdate);
	pst.setInt(1, Integer.parseInt(list.get(2)));
	pst.setInt(2, Integer.parseInt(list.get(0)));
	count=pst.executeUpdate();
	return count;
	}
}
