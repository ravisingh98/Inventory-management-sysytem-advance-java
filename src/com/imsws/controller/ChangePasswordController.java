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

import com.imsws.dao.ChangePasswordDao;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/changepassword")
public class ChangePasswordController extends HttpServlet {
	ResultSet rs;
	int count;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String conpassword=request.getParameter("conpassword");
		ChangePasswordDao cpd=new ChangePasswordDao();
		try {
			rs=cpd.docheck();
			if(rs.next()) {
				if(oldpassword.equals(rs.getString("password"))) {
					if(newpassword.equals(conpassword)){
						count=cpd.dochange(oldpassword,conpassword);
						if(count>0) {
							request.setAttribute("success", "Password Successfully  Changed");
							RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
							rd.forward(request, response);
						}
						
					}
					else {
						request.setAttribute("ncmsg", "New And Old Passowrd Do Not Match");
						RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
						rd.forward(request, response);
					}
					
				}else {
					request.setAttribute("msg", "Wrong Old Password");
					RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
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


}
