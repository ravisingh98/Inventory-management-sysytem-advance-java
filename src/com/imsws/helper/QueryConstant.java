package com.imsws.helper;

public interface QueryConstant {

	String login_path="select userid,password,rolename from user_mst where userid=? and password=?";
	String cart_path="select * from addproduct where pid=?";
	String cartall_path="select * from addproduct";
	String doCheck="select password from user_mst";
	String doChange="update user_mst set password=? where password=?";
	String checkout="insert into orderreport (name,nop,cost,date,totalprice) values (?,?,?,?,?)";
	String updateTotalProduct="update addproduct set noofproduct=(?-?) where pid=?";
	String menu="select * from addproduct";
	String itemList="select * from addproduct where pid=?";
	String orderReport="select * from orderreport";
	String doUpload="insert into addproduct(name,cost,type,company,noofproduct,imagepath)values(?,?,?,?,?,?)";
	String doEdit="select pid,name,cost,type,company,imagepath from addproduct where pid=?";
	String doFatch="select pid,name,cost,type,company,imagepath from addproduct";
	String doUpdate="update addproduct set name=?,cost=?,type=?,company=?,imagepath=? where pid=?";
	String doSEdit="select * from addproduct where pid=?";
	String doSFatch="select pid,name,cost,type,company,noofproduct,imagepath from addproduct";
	String doSUpdate="update addproduct set noofproduct=? where pid=?";
}
