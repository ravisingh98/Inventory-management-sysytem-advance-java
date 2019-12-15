<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IMS : Inventory Management System</title>
  <link rel="stylesheet" href="./assets/stylesheets/dashboard.css">
  <link rel="stylesheet" href="./assets/stylesheets/main.css">
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
            <li><a href="">Change Password</a></li>
            <li><a href="logout">Logout</a></li>
          </ul>
        </div>
      </nav>
       <section class="section-dash">
       <%
       if(request.getAttribute("success")!=null){
    	   %>
    	 <span class="msg"><%=request.getAttribute("success")%></span> 
    	 <%
       }
       
       if(request.getAttribute("ncmsg")!=null){
    	   %>
    	 <span class="msg"><%=request.getAttribute("ncmsg")%></span> 
    	 <%
       }
       
       if(request.getAttribute("msg")!=null){
    	   %>
    	 <span class="msg"><%=request.getAttribute("msg")%></span> 
    	 <%
       }
       
       %>
       <div class="form">
<div class="in-form">
<form action="changepassword" method="post">
<input type="password" name="oldpassword" placeholder="Old Password" class="form-p" required="required"/>
<input type="password" name="newpassword" placeholder="New Password" class="form-p" required="required"/>
<input type="password" name="conpassword" placeholder="Confirm Password" class="form-p" required="required"/>
<button class="form-btn">Change</button>
</form>
      </section>
  </div>
  </div>
</body>
</html>