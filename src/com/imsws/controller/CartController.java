package com.imsws.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imsws.dao.CartDao;
import com.imsws.dto.CartDto;
import com.imsws.dto.CreateOrderDto;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	ResultSet rs;
	ResultSet rs2;
	int count=0;
	LinkedHashSet<CartDto> cartlist=new LinkedHashSet<>();
	LinkedHashSet<CartDto> cartlistall=new LinkedHashSet<>();
	CartDto cartdto;
	CartDto cartdto2;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		CartDao cd=new CartDao();
		CartDao cd2=new CartDao();
		try {
			rs=cd.cart(id);
			while (rs.next()) {
				cartdto=new CartDto();
				cartdto.setPid(rs.getInt("pid"));
				cartdto.setName(rs.getString("name"));
				cartdto.setNoofproduct(rs.getInt("noofproduct"));
				cartdto.setCost(rs.getInt("cost"));
				cartdto.setImagepath(rs.getString("imagepath"));
				cartlist.add(cartdto);
			}
			rs2=cd2.cartAll();
			while (rs2.next()) {
				cartdto2=new CartDto();
				cartdto2.setPid(rs2.getInt("pid"));
				cartdto2.setName(rs2.getString("name"));
				cartdto2.setCost(rs2.getInt("cost"));
				cartdto2.setCompany(rs2.getString("company"));
				cartdto2.setImagepath(rs2.getString("imagepath"));
				cartlistall.add(cartdto2);
				count++;
			}
			
			if(count>0) {
				request.setAttribute("cartlist", cartlist);
				request.setAttribute("cartlistall", cartlistall);
				RequestDispatcher rd=request.getRequestDispatcher("productcart.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
