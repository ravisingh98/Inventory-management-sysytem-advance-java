<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Product Add</title>
  <link rel="stylesheet" href="./assets/stylesheets/productadd.css">
</head>

<body>
<% 
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("index.jsp");
}
%>
  <div class="add-product">
    <form action="productadd" method="POST" enctype=multipart/form-data>
      <div class="product-add">
      <div class="row">
       <div class="col-1">
          <label>Product Name</label>
          <input type="text" name="productname" placeholder="Enter Product Name" required="required">
          <label>Product Cost</label>
          <input type="text" name="productcost" placeholder="Enter Product Cost" required="required">
          <label>Product Type</label>
          <input type="text" name="productype" placeholder="Enter Product Type" required="required">
          <ul><li><a href="">BACK</a></li>
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
      </div>
      </div>
    </form>
  </div>
</body>

</html>