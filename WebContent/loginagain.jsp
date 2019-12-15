<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IMS : Inventory Management System</title>
  <link rel="stylesheet" href="./assets/stylesheets/main.css">
  <script src="./assets/js/jquery-3.4.0.min.js"></script>
  <script src="./assets/js/main.js"></script>
</head>
<body>
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
            <li><a href="">About Us</a></li>
            <li><a href="">Contact Us</a></li>
            <li><input class="admin-login" type="button" value="ADMIN LOGIN"></li>
          </ul>
        </div>
        <div class="form">
	<div class="in-form">
	<% if(request.getAttribute("msg")!=null){
		%>
		<p><%=request.getAttribute("msg")%></p>
		<% 
	}
	%>
	<form action="login" method="post">
	<input type="text" name="userid" placeholder="Enter Your User Id" class="form-l"/>
	<input type="password" name="password" placeholder="Enter Your Password" class="form-p" />
	<button class="form-btn">Sign In</button>
	</form>
	</div>
</div>

</body>
</html>