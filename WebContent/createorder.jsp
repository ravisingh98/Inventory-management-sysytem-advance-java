<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import ="java.util.*,java.util.*, com.imsws.dto.*"
    pageEncoding="ISO-8859-1"%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IMS : Product Edit</title>
  <script src="https://kit.fontawesome.com/b06605e970.js"></script>
  <link rel="stylesheet" href="./assets/stylesheets/dashboard.css">
  <link rel="stylesheet" href="./assets/stylesheets/productadd.css">
  <link rel="stylesheet" href="./assets/stylesheets/createorder.css">
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
        	<li><a href="logout"><i class="fas fa-shopping-cart"></i></a></li>
          </ul>
        </div>
      </nav>
       <section class="section-dash">
        <div class="row">
          <div class="col-1">
          <ul>
            	 <%
                 LinkedHashSet<CreateOrderDto> datalist=(LinkedHashSet<CreateOrderDto>) request.getAttribute("list");
    	if(datalist!=null){
    		for(CreateOrderDto obj : datalist){
    			%>
    			<li>
    			<img alt="img" src="<%=obj.getImagepath()%>">
    			<p><%=obj.getName()%> - <%=obj.getCompany() %></p>
    			<p>&#8377 <%=obj.getCost()%></p>
    			<a href="cart?id=<%=obj.getPid()%>">Add To Cart</a>
    			</li>
    			<% 
    		}
    	}
        
    %>
	</ul>
          </div>
          <div class="col-2">
              <%
	TreeSet<String> list = (TreeSet<String>)request.getAttribute("typelist");
	if(list!=null){
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()){
			String typelist=iterator.next();
			%>
			<ul>
			<li><a href="">
			&#8658 
			<%=typelist%>
			</a>
			</li>
			</ul>
			<% 
		}
	}
%>
          </div>
        </div>
      </section>
  </div>
  </div>
</body>
</html>