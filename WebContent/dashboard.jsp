<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IMS : Inventory Management System</title>
  <link rel="stylesheet" href="./assets/stylesheets/dashboard.css">
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
       <section class="section-dash">
        <div class="row">
          <div class="col-1">
            <p>Welcome To Inventory Management System</p>
            <hr>
            <ul>
              <li><input class="addproduct" type="button" value="Add Product"></li>
              <li><a href="productreport">Product Report</a></li>
              <li><a href="stockreport">Stock Report</a></li>
              <li><a href="createorder">Create Order</a></li>
              <li><a href="orderreport">Order Report</a></li>
            </ul>
          </div>
          <div class="col-2">
            <img src="./assets/images/inventory.jpg" alt="images">
            <hr>
            <div class="developby"><span>Developed By : -</span><a href="https://ravisingh98.github.io/ravisingh">ravi
                Singh</a></div>
          </div>
        </div>
      </section>
  </div>
  </div>
</body>
</html>