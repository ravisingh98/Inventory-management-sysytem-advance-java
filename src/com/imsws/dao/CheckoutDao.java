package com.imsws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.imsws.dto.CheckoutDto;
import com.imsws.helper.QueryConstant;

public class CheckoutDao {
	public int checkout(CheckoutDto cdto) throws ClassNotFoundException, SQLException, NamingException {
		Connection con=null;
		PreparedStatement pst=null;
		int count;
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.checkout);
	pst.setString(1, cdto.getName());
	pst.setString(2, cdto.getNoofproduct());
	pst.setString(3, cdto.getCost());
	pst.setString(4, cdto.getDate());
	pst.setString(5, cdto.getTotalcost());
	count=pst.executeUpdate();
	return count;
}
	public int UpdatetotalProduct(int id, String quantity, int nop) throws ClassNotFoundException, SQLException, NamingException {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet  rs=null;
	int no;
	con=CommonDao.getConnection();
	pst=con.prepareStatement(QueryConstant.updateTotalProduct);
	pst.setInt(1, nop);
	pst.setInt(2, Integer.parseInt(quantity));;
	pst.setInt(3, id);
	System.out.println(id);
	System.out.println(quantity);
	System.out.println(nop);
	no=pst.executeUpdate();
	return no;
	}
}
