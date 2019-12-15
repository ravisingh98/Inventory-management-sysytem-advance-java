package com.imsws.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imsws.dao.LoginDao;
import com.imsws.dto.LoginDto;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="Invalid UserId Or Password";
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		LoginDto logindto=new LoginDto();
		logindto.setUserid(userid);
		logindto.setPassword(password);
		LoginDao logindao=new LoginDao();
		try {
			ResultSet rs=logindao.doLogin(logindto);
			if(rs.next()) {
				System.out.println("ssdsd");
				HttpSession session=request.getSession(true);
				session.setAttribute("userid", userid);
				response.sendRedirect("dashboard.jsp");
			}else {
				request.setAttribute("msg", msg);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("loginagain.jsp");
				requestDispatcher.forward(request, response);
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
		}finally {
//			try {
//				logindao.rs.close();
//				logindao.pst.close();
//				logindao.con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}

}
