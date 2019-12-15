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

import com.imsws.dao.ProductEditDao;
import com.imsws.dto.ProductEditDto;

/**
 * Servlet implementation class ProductEditController
 */
@WebServlet("/pedit")
public class ProductEditController extends HttpServlet {
	ResultSet rs;
	HttpSession session;
	int count=0;
	LinkedHashSet<ProductEditDto>list=new LinkedHashSet<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		ProductEditDao ped=new ProductEditDao();
		try {
			rs=ped.doEdit(id);
			while(rs.next()) {
				session=request.getSession(false);
				ProductEditDto prt=new ProductEditDto();
				prt.setPid(rs.getInt("pid"));
				prt.setName(rs.getString("name"));
				prt.setCost(rs.getInt("cost"));
				prt.setType(rs.getString("type"));
				prt.setCompany(rs.getString("company"));
				prt.setImagepath(rs.getString("imagepath"));
				list.add(prt);
				count++;
			}
			if(count>0) {
				request.setAttribute("list", list);
				RequestDispatcher rd=request.getRequestDispatcher("pedit.jsp");
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
