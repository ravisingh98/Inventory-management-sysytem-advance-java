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
<%
response.setHeader("Cache-control", "no-cache");
response.setHeader("Cache-control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expire",0 );

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
            <li><a href="">About Us</a></li>
            <li><a href="">Contact Us</a></li>
            <li><input class="admin-login" type="button" value="ADMIN LOGIN"></li>
          </ul>
        </div>
      </nav>
      <div class="desc-sec">
      <div class="slider-section">
        <div class="slider">
          <div class="slide"><img src="./assets/images/image1.png" alt="img"></div>
          <div class="slide"><img src="./assets/images/image2.jpg" alt="img"></div>
          <div class="slide"><img src="./assets/images/image3.jpg" alt="img"></div>
          <div class="slide"><img src="./assets/images/image4.jpg" alt="img"></div>
          <div class="slide"><img src="./assets/images/image5.jpeg" alt="img"></div>
        </div>
      </div>
      <div class="section">
        <div class="row justify-content">
          <div class="col-1">
            <div class="row-1">
              <img src="./assets/images/image1.png" alt="">
              <h2>product management</h2>
            </div>
            <div class="row-2">
              <img src="./assets/images/image3.jpg" alt="">
              <h2>Stock management</h2>
            </div>
            <div class="row-3">
              <img src="./assets/images/image5.jpeg" alt="">
              <h2>user management</h2>
            </div>
          </div>
          <div class="col-2">
            <div>
              <h1>What is an inventory management system?</h1>
              <p>Inventory management systems track goods through the entire supply chain or the portion of it a business operates in. That covers everything from production to retail, warehousing to shipping, and all the movements of stock and parts between.Practically, it means a business can see all the small moving parts of its operations, allowing it to make better decisions and investments. Different inventory managers focus on different parts of the supply chain—though small businesses are usually more interested in the ordering and sales end of the chain.Because of their wide variation in scope, inventory management systems also vary widely in cost.Software Advice’s FrontRunners report for inventory management gives you an idea of what that price/features mix looks like.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
</body>
</html>