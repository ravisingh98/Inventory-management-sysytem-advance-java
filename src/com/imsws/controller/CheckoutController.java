package com.imsws.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.imsws.dao.CheckoutDao;
import com.imsws.dto.CartDto;
import com.imsws.dto.CheckoutDto;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
	ResultSet rs;
	int count;
	int no;
	int nop;
	int id;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		LinkedHashSet<CartDto> cartlistitem=(LinkedHashSet<CartDto>) session.getAttribute("cartlistitem");
		if(cartlistitem!=null){
			for(CartDto obj : cartlistitem){
				id=obj.getPid();
				nop=obj.getNoofproduct();

			}
		String quantity=request.getParameter("noofproduct");
		String totalcost=request.getParameter("totalcost");
		String pname=request.getParameter("name");
		String cost=request.getParameter("cost");
		CheckoutDao cd=new CheckoutDao();
		CheckoutDto cdto;
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		try {
			cdto=new CheckoutDto();
			cdto.setName(pname);
			cdto.setCost(cost);
			cdto.setNoofproduct(quantity);
			cdto.setTotalcost(totalcost);
			cdto.setDate(dtf.format(now));
			
			count=cd.checkout(cdto);
			if(count>0) {
				no=cd.UpdatetotalProduct(id,quantity,nop);
				if(no>0) {
					request.setAttribute("msg", "Order Placed");
					RequestDispatcher rd=request.getRequestDispatcher("orderplaced.jsp");
					rd.forward(request, response);
				}
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

	}}
