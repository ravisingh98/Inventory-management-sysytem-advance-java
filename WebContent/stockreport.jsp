<%@page import="com.imsws.dto.StockReportDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import ="java.util.*, com.imsws.dao.*"
    pageEncoding="ISO-8859-1"%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IMS : Stock Report</title>
  <script src="https://kit.fontawesome.com/b06605e970.js"></script>
  <link rel="stylesheet" href="./assets/stylesheets/dashboard.css">
  <link rel="stylesheet" href="./assets/stylesheets/productreport.css">
    <script src="./assets/js/jquery-3.4.0.min.js"></script>
  <script src="./assets/js/main.js"></script>
</head>
<body>
<% 
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("index.jsp");
}
%>
  <div id="container">
    <div class="container">
      <div class="topbar">
        <div class="row">
          <div class="col-left">
            <h1 class="in">inventory</h1>
            <h1 class="ma">management</h1>
            <h1 class="sy">system</h1>
            <p>Manage Stock Product</p>
          </div>
        </div>
      </div>
      <nav>
        <div class="menubar">
          <ul>
            <li><a href="dashboard.jsp">Home</a></li>
            <li><a href="dashboard.jsp">dashboard</a></li>
            <li><a href="changepassword.jsp">Change Password</a></li>
            <li><a href="logout">Logout</a></li>
          </ul>
        </div>
      </nav>
       <section class="section-preport">
       <%
       if(session.getAttribute("msg")!=null){
    	   %>
    	   <p>
    	      <%=session.getAttribute("msg")%>
    	     </p>
    	     <%
       }
       %>
        <table>
        <thead>
        <th class="id">Id</th>
        <th class="w">Image</th>
        <th class="w">Name</th>
        <th class="w">Type</th>
        <th class="w">Company</th>
        <th class="w">No of Product</th>
        <th class="w">Action</th>
        </thead>
        <tbody>
        <%
        LinkedHashSet<StockReportDto> list = (LinkedHashSet<StockReportDto>)request.getAttribute("list");
	if(list!=null){
		for(StockReportDto obj : list){
			%>
			<tr>
			<td class="id"><%=obj.getPid()%></td>
			<td class="w"><img src="<%=obj.getImagepath()%>"></td>
			<td class="w"><%=obj.getName()%></td>
			<td class="w"><%=obj.getType()%></td>
			<td class="w"><%=obj.getCompany()%></td>
			<td class="w"><%=obj.getNoofproduct()%></td>
			<td class="w"><a href="sedit?id=<%=obj.getPid()%>"><i class="fas fa-edit"></i></a></td>
			</tr>
			<% 
		}
	}
%>
        </tbody>
        </table>
        <%
        if(list!=null){
			%>
			<input class="printbtn" type="button" value="Print">
			<%
		}%>
      </section>
  </div>
  </div>
</body>
</html>