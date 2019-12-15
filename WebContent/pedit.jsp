<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import ="java.util.*, com.imsws.dto.*"
    pageEncoding="ISO-8859-1"%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IMS : Product Edit</title>
  <script src="https://kit.fontawesome.com/b06605e970.js"></script>
  <link rel="stylesheet" href="./assets/stylesheets/dashboard.css">
  <link rel="stylesheet" href="./assets/stylesheets/productadd.css">
  <link rel="stylesheet" href="./assets/stylesheets/pedit.css">
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
            <li><a href="dashboard.jsp">dashboard</a></li>
            <li><a href="changepassword.jsp">Change Password</a></li>
            <li><a href="logout">Logout</a></li>
          </ul>
        </div>
      </nav>
       <section class="section-dash">
        <%
       if(request.getAttribute("msg")!=null){
    	   %>
    	   <p>
    	      <%=request.getAttribute("msg")%>
    	     </p>
    	     <%
       }
       %>
       <div class="row">
          <div class="col-1">
           <div class="add-product">
    <form action="productupdate" method="POST" enctype=multipart/form-data>
      <div class="product-add">
      <div class="row">
       <div class="col-1">
        <%
        ArrayList<String> listdata = (ArrayList<String>)request.getAttribute("listdata");
 if(listdata==null){
	 LinkedHashSet<ProductEditDto> list = (LinkedHashSet<ProductEditDto>)request.getAttribute("list");
	if(list!=null){
		for(ProductEditDto obj : list){
			%>
			<label>Product Id</label>
          <input class="no-allow" type="text" name="productid" value="<%=obj.getPid()%>" required="required" readonly="readonly" title="you can't edit this">
			<label>Product Name</label>
          <input type="text" name="productname" value="<%=obj.getName()%>" required="required">
          <label>Product Cost</label>
          <input type="text" name="productcost" value="<%=obj.getCost() %>" required="required">
          <label>Product Type</label>
          <input type="text" name="productype" value="<%=obj.getType() %>" required="required">
          <ul><li><a href="productreport.jsp">BACK</a></li>
          <li><button>UPDATE</button></li></ul>
        </div> 
        <div class="col-2">
       <label>Product Company</label>
          <input type="text" name="productcompany" value="<%=obj.getCompany()%>" required="required">
          <label>Product Image</label>
          <img alt="img" class="image" src="<%=obj.getImagepath()%>">
          <input type="file" class="file" name="file" required="required">
        </div>
			<% 
		}
	}
 }
%>

<%
if(listdata!=null){
	%>
		<label>Product Id</label>
      <input class="no-allow" type="text" name="productid" value="<%=listdata.get(0)%>" required="required" readonly="readonly" title="you can't edit this">
		<label>Product Name</label>
      <input type="text" name="productname" value="<%=listdata.get(1)%>" required="required">
      <label>Product Cost</label>
      <input type="text" name="productcost" value="<%=listdata.get(2)%>" required="required">
      <label>Product Type</label>
      <input type="text" name="productype" value="<%=listdata.get(3)%>" required="required">
      <ul><li><a href="productreport.jsp">BACK</a></li>
      <li><button>UPDATE</button></li></ul>
    </div> 
    <div class="col-2">
   <label>Product Company</label>
      <input type="text" name="productcompany" value="<%=listdata.get(4)%>" required="required">
      <label>Product Image</label>
      <img alt="img" class="image" src="<%=listdata.get(5)%>">
      <input type="file" class="file" name="file" required="required">
    </div>
    <%
	}
%>
      </div>
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