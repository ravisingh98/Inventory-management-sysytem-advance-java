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
import javax.servlet.http.HttpSession;

import com.imsws.dao.StockEditDao;
import com.imsws.dto.StockEditDto;
/**
 * Servlet implementation class StockEditController
 */
@WebServlet("/sedit")
public class StockEditController extends HttpServlet {
	ResultSet rs;
	HttpSession session;
	int count=0;
	LinkedHashSet<StockEditDto>list=new LinkedHashSet<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		StockEditDao ped=new StockEditDao();
		try {
			rs=ped.doEdit(id);
			while(rs.next()) {
				session=request.getSession(false);
				StockEditDto prt=new StockEditDto();
				prt.setPid(rs.getInt("pid"));
				prt.setName(rs.getString("name"));
				prt.setCost(rs.getInt("cost"));
				prt.setNoofproduct(rs.getInt("noofproduct"));
				prt.setType(rs.getString("type"));
				prt.setCompany(rs.getString("company"));
				prt.setImagepath(rs.getString("imagepath"));
				list.add(prt);
				count++;
			}
			if(count>0) {
				request.setAttribute("list", list);
				RequestDispatcher rd=request.getRequestDispatcher("sedit.jsp");
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
