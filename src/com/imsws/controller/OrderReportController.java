package com.imsws.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imsws.dao.OrderReportDao;
import com.imsws.dto.OrderReportDto;

/**
 * Servlet implementation class OrderReportController
 */
@WebServlet("/orderreport")
public class OrderReportController extends HttpServlet {
	ResultSet rs;
	int count=0;
	LinkedHashSet<OrderReportDto>report=new LinkedHashSet<OrderReportDto>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderReportDao ord=new OrderReportDao();
		try {
			rs=ord.orderReport();
			System.out.println(rs);
			while(rs.next()) {
				OrderReportDto dto=new OrderReportDto();
				dto.setOid(rs.getString("oid"));
				dto.setName(rs.getString("name"));
				dto.setNoofproduct(rs.getString("nop"));
				dto.setCost(rs.getString("cost"));
				dto.setDate(rs.getString("date"));
				dto.setTotalcost(rs.getString("totalprice"));
				count++;
				report.add(dto);			}
			if(count>0) {
				request.setAttribute("orderlist", report);
				RequestDispatcher rd=request.getRequestDispatcher("orderreport.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("msg", "Sorry, No Record Found");
				RequestDispatcher rd=request.getRequestDispatcher("orderreport.jsp");
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
