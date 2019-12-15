package com.imsws.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.imsws.dao.ProductUpdateDao;

/**
 * Servlet implementation class ProductUpdateController
 */
@WebServlet("/productupdate")
public class ProductUpdateController extends HttpServlet {
	private String UPLOAD_DIRECTORY="D:\\adv Java\\IMSWS\\WebContent\\uploads";
	private static String path=null;
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	int count;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		ArrayList<String> list=new ArrayList<>();
		path = UPLOAD_DIRECTORY.substring(UPLOAD_DIRECTORY.length()-7, UPLOAD_DIRECTORY.length());
		if (!ServletFileUpload.isMultipartContent(request)) {
			
			
			writer.println("Error: Form must has enctype=multipart/form-data.");
			writer.flush();
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		File uploadDir = new File(UPLOAD_DIRECTORY);
		if (!uploadDir.exists()) {
		uploadDir.mkdir();
		}
		try {
			List<FileItem> formItems = upload.parseRequest(request);
			Iterator<FileItem> iter = formItems.iterator();
			while (iter.hasNext()) {
			    FileItem item = iter.next();

			    if (item.isFormField()) {
			    	String value = item.getString();
			    	list.add(value);
			    } else {
			       
			    }
			}
				if (formItems != null && formItems.size() > 0) {
					for(FileItem formItem: formItems) {
						if(!formItem.isFormField()) {
							String fileName = new File(formItem.getName()).getName();
							String fullPath = UPLOAD_DIRECTORY + File.separator + fileName;
							list.add(path + File.separator + fileName);
							File storeFile = new File(fullPath);
							formItem.write(storeFile);
							ProductUpdateDao pad=new ProductUpdateDao();
							count=pad.doUpdate(list);
							
						}
					}
				}
				
				if(count>0) {
					request.setAttribute("msg", "Product Update Successfully");
					request.setAttribute("listdata", list);
					RequestDispatcher rd=request.getRequestDispatcher("pedit.jsp");
					rd.forward(request, response);
				}
		}
		catch(Exception e) {
			System.out.println("Error "+e);
			e.printStackTrace();
		}
	}

}
