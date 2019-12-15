package com.imsws.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imsws.dao.ItemListDao;
import com.imsws.dto.ItemListDto;

/**
 * Servlet implementation class ItemListController
 */
@WebServlet("/itemlist")
public class ItemListController extends HttpServlet {
	ResultSet rs;
	int count=0;
	LinkedHashSet<ItemListDto> list=new LinkedHashSet<>();
	HashMap<String, LinkedHashSet<ItemListDto>> items=new HashMap<String, LinkedHashSet<ItemListDto>>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String quantity=request.getParameter("quantity");
		ItemListDao cd=new ItemListDao();
		ItemListDto cdto;
		try {
			rs=cd.itemlist(id);
			while(rs.next()) {
				cdto=new ItemListDto();
				cdto.setPid(rs.getInt("pid"));
				cdto.setName(rs.getString("name"));
				cdto.setCost(rs.getInt("cost"));
				cdto.setNoofproduct(rs.getInt("noofproduct"));
				cdto.setCompany(rs.getString("company"));
				cdto.setImagepath(rs.getString("imagepath"));
				list.add(cdto);
				count++;
			}
			if(count>0) {
				items.put("itemslist", list);
				request.setAttribute("items", items);
				request.setAttribute("quantity", quantity);
				request.setAttribute("datalist", list);
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
