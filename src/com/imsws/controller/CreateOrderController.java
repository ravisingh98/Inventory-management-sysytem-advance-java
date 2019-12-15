package com.imsws.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imsws.dao.CreateOrderDao;
import com.imsws.dto.CreateOrderDto;

/**
 * Servlet implementation class CreateOrderController
 */
@WebServlet("/createorder")
public class CreateOrderController extends HttpServlet {
	ResultSet rs;
	int count=0;
	String type;
	CreateOrderDto orderDto;
	TreeSet<String> typelist=new TreeSet<>();
	LinkedHashSet<CreateOrderDto> list=new LinkedHashSet<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreateOrderDao cod=new CreateOrderDao();
		try {
			rs=cod.Menu();
			while(rs.next()) {
				orderDto=new CreateOrderDto();
				orderDto.setName(rs.getString("name"));
				orderDto.setCost(rs.getInt("cost"));
				orderDto.setCompany(rs.getString("company"));
				orderDto.setPid(rs.getInt("pid"));
				orderDto.setImagepath(rs.getString("imagepath"));
				type=rs.getString("type");
				typelist.add(type);
				list.add(orderDto);
				count++;
			}
			
			if(count>0) {
				request.setAttribute("typelist", typelist);
				request.setAttribute("list", list);
				RequestDispatcher rd=request.getRequestDispatcher("createorder.jsp");
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
