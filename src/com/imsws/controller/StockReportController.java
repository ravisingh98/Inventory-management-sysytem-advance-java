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
import javax.xml.ws.Response;

import com.imsws.dao.ProductReportDao;
import com.imsws.dao.StockReportDao;
import com.imsws.dto.ProductReportDto;
import com.imsws.dto.StockReportDto;

/**
 * Servlet implementation class ProductReportController
 */
@WebServlet("/stockreport")
public class StockReportController extends HttpServlet {
	ResultSet rs;
	int count=0;
	HttpSession session;
	LinkedHashSet<StockReportDto>list=new LinkedHashSet<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				StockReportDao prd=new StockReportDao();
				try {
					rs=prd.doFatch();
					while(rs.next()) {
						session=request.getSession(false);
						StockReportDto prt=new StockReportDto();
						prt.setPid(rs.getInt("pid"));
						prt.setName(rs.getString("name"));
						prt.setCost(rs.getInt("cost"));
						prt.setType(rs.getString("type"));
						prt.setCompany(rs.getString("company"));
						prt.setNoofproduct(rs.getInt("noofproduct"));
						prt.setImagepath(rs.getString("imagepath"));
						list.add(prt);
						count++;
					}
					if(count>0) {
						request.setAttribute("list", list);
						RequestDispatcher rd=request.getRequestDispatcher("stockreport.jsp");
						rd.forward(request, response);
					}
					else {
						request.setAttribute("msg", "Sorry, No Record Found");
						RequestDispatcher rd=request.getRequestDispatcher("stockreport.jsp");
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
