package com.imsws.dto;

public class OrderReportDto {

	String oid;
	String name;
	String cost;
	String type;
	String company;
	String noofproduct;
	String imagepath;
	String totalcost;
	String date;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String string) {
		this.oid = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getNoofproduct() {
		return noofproduct;
	}
	public void setNoofproduct(String quantity) {
		this.noofproduct = quantity;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
}
