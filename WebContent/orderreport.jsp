<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import ="java.util.*, com.imsws.dto.*"
    pageEncoding="ISO-8859-1"%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IMS : Inventory Management System</title>
  <script src="https://kit.fontawesome.com/b06605e970.js"></script>
  <link rel="stylesheet" href="./assets/stylesheets/dashboard.css">
  <link rel="stylesheet" href="./assets/stylesheets/checkout.css">
  <link rel="stylesheet" href="./assets/stylesheets/orderreport.css">
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
            <li><a href="">Home</a></li>
            <li><a href="#">dashboard</a></li>
            <li><a href="changepassword.jsp">Change Password</a></li>
            <li><a href="logout">Logout</a></li>
          </ul>
        </div>
      </nav>
       <section class="section-checkout">
                <table>
        <thead>
        <th class="w">Order Id</th>
        <th class="w">Product</th>
        <th class="w">Cost/Item</th>
        <th class="w">No Of Items</th>
        <th class="w">Date</th>
        <th class="w">TotalCost</th>
        </thead>
        <tbody>
        <%
       if(request.getAttribute("msg")!=null){
    	   %>
    	   <p>
    	      <%=request.getAttribute("msg")%>
    	     </p>
    	     <%
       }
       %>
        <%
        LinkedHashSet<OrderReportDto> orderlist=(LinkedHashSet<OrderReportDto>) request.getAttribute("orderlist");
	if(orderlist!=null){
		for(OrderReportDto obj : orderlist){
			%>
			<tr>
			<td><%=obj.getOid()%></td>
			<td><%=obj.getName()%></td>
			<td><%=obj.getCost()%></td>
			<td><%=obj.getNoofproduct()%></td>
			<td><%=obj.getDate()%></td>
			<td><%=obj.getTotalcost()%></td>
			</tr>
			<%
		}
	}
%>
        </tbody>
        </table>
         <%
        if(request.getAttribute("orderlist")!=null){
			%>
			<input class="printbtn" type="button" value="Print">
			<%
		}%>
      </section>
  </div>
  </div>
</body>
</html>