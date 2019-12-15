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
  <link rel="stylesheet" href="./assets/stylesheets/cartlist.css">
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
       <section class="section-checkout">
                <table>
        <thead>
        <th class="w">Product</th>
        <th class="w">Price/Unit</th>
        <th class="w">No Of Items</th>
        <th class="w">Total</th>
        <th class="w">Action</th>
        </thead>
        <tbody>
        <%
        LinkedHashSet<CartDto> cartlistitem=(LinkedHashSet<CartDto>) session.getAttribute("cartlistitem");
	if(cartlistitem!=null){
		String quantity=(String)request.getAttribute("quantity");
		for(CartDto obj : cartlistitem){
			%>
			<tr><form action="checkout" method="post">
			<td class="w"><img src="<%=obj.getImagepath()%>">
			<input type="text" class="pname" name="name" value="<%=obj.getName()%>" readonly="readonly">
			</td>
			<td class="w"><input class="itemcost" type="text" name="cost" value="<%=obj.getCost()%>" readonly="readonly"></td>
			<td class="w"><input type="number" name="noofproduct" max="50" min="1" value="1" class="noofproduct" oninput="calculate()"></td>
			<td class="w"><input type="text" class="totalcost" name="totalcost" value="<%=obj.getCost()%>" readonly="readonly"></td>
			<td class="w"><a href="createorder"><i class="fas fa-times"></i></a></td>
			<script>
			function calculate() {
			nop=document.querySelector(".noofproduct").value;
				 total=document.querySelector(".itemcost").value;
				totalprice=nop*total;
				document.querySelector(".totalcost").value=totalprice;
			}
			</script>
			</tr>
			<%
		}
	}
%>
        </tbody>
        </table>
        
        <button class="btn">Checkout</button>
        </form>
      </section>
  </div>
  </div>
</body>
</html>