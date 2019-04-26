package com.ubang.table;

public class Company {
	private String company;
	private String company_type;
	private String company_num;
	private String company_field;
	private String company_img;
	private String company_info;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany_type() {
		return company_type;
	}
	public void setCompany_type(String company_type) {
		this.company_type = company_type;
	}
	public String getCompany_num() {
		return company_num;
	}
	public void setCompany_num(String company_num) {
		this.company_num = company_num;
	}
	public String getCompany_field() {
		return company_field;
	}
	public void setCompany_field(String company_field) {
		this.company_field = company_field;
	}
	public String getCompany_img() {
		return company_img;
	}
	public void setCompany_img(String company_img) {
		this.company_img = company_img;
	}
	public String getCompany_info() {
		return company_info;
	}
	public void setCompany_info(String company_info) {
		this.company_info = company_info;
	}
	
	@Override
	public String toString() {
		return "{\"company\":\"" + company + "\", \"company_type\":\"" + company_type + "\", \"company_num\":\""
				+ company_num + "\", \"company_field\":\"" + company_field + "\", \"company_img\":\"" + company_img
				+ "\", \"company_info\":\"" + company_info + "\"}";
	}
	
}
