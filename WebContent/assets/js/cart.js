window.addEventListener("load", initEvent);

function initEvent() {
	console.log("ff");
	document.querySelector(".noofproduct").addEventListener("onkeyup", noOfProduct);
}

function noOfProduct() {
	console.log("ffffff");
	var nop=document.querySelector(".noofproduct").value;
	var total=document.querySelector(".itemcost").innerText;
	var totalprice=nop*total;
	document.querySelector(".totalcost").innerHTML=totalprice;
}