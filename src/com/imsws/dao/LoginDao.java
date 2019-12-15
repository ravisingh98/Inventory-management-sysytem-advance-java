package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.imsws.dto.LoginDto;
import com.imsws.helper.QueryConstant;
public class LoginDao {
	
	public Connection con=null;
	public  PreparedStatement pst=null;
	public  ResultSet  rs=null;
	public ResultSet doLogin(LoginDto ld) throws ClassNotFoundException, SQLException, NamingException {
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.login_path);
	pst.setString(1, ld.getUserid());
	pst.setString(2, ld.getPassword());
	rs=pst.executeQuery();
	return rs;
	}

}
