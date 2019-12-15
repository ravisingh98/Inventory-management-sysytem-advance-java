$(window).ready(function () {
	loadLogin();
	addproduct();
	printData();
});

function loadLogin() {
	$(".admin-login").click(function () {
	    $(".desc-sec").load("login.jsp");
	  });
}
function printData() {
	  $(".printbtn").click(function () {
	    print(document);
	  });
	}
function addproduct() {
	 $(".addproduct").click(function () {
		    $(".col-1").load("productadd.jsp");
		  });
}