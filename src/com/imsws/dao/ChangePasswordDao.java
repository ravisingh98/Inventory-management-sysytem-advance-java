package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.imsws.helper.QueryConstant;

public class ChangePasswordDao {
	public ResultSet docheck() throws ClassNotFoundException, SQLException, NamingException {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet  rs=null;
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.doCheck);
	rs=pst.executeQuery();
	return rs;
	}
	
	public int dochange(String oldpassword, String conpassword) throws ClassNotFoundException, SQLException, NamingException {
		System.out.println("in dao");
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet  rs=null;
		int count;
		con=CommonDao.getConnection();
		pst=con.prepareStatement(QueryConstant.doChange);
		pst.setString(1, conpassword);
		pst.setString(2, oldpassword);
		count=pst.executeUpdate();
		return count;
		}
	
}
