<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IMS : Inventory Management System</title>
  <link rel="stylesheet" href="./assets/stylesheets/dashboard.css">
  <link rel="stylesheet" href="./assets/stylesheets/productadd.css">
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
       <section class="section-dash">
        <div class="row">
          <div class="col-1">
            <div class="add-product">
    <form action="productadd" method="POST" enctype=multipart/form-data>
     <div class="row">
      <div class="product-add">
           <p>
      <%=request.getAttribute("msg")%>
     </p>
      <div class="row">
       <div class="col-1">
          <label>Product Name</label>
          <input type="text" name="productname" placeholder="Enter Product Name" required="required">
          <label>Product Cost</label>
          <input type="text" name="productcost" placeholder="Enter Product Cost" required="required">
          <label>Product Type</label>
          <input type="text" name="productype" placeholder="Enter Product Type" required="required">
          <ul><li><a href="dashboard.jsp">BACK</a></li>
          <li><button>SUBMIT</button></li></ul>
        </div> 
        <div class="col-2">
       <label>Product Company</label>
          <input type="text" name="productcompany" placeholder="Enter Product Company" required="required">
          <label>No Of Product</label>
          <input type="text" name="noofproduct" placeholder="Enter No Of Product" required="required">
          <label>Product Image</label>
          <input type="file" class="file" name="file" required="required">
        </div>
      </div></div>
     </div>
    </form>
  </div>
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