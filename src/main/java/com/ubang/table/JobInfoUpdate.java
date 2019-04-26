package com.ubang.table;

import java.util.List;

/**
 * 为了获取招聘信息
 * 筛选的内容
 * @author huang
 *
 */
public class JobInfoUpdate {
	private String cityList;
	private String companyNumList;
	private String companyTypeList;
	private String degreeList;
	private String expList;
	private int start;
	private int space;
	
	
	public String getCityList() {
		return cityList;
	}

	public void setCityList(String cityList) {
		this.cityList = cityList;

	}

	public String getCompanyNumList() {
		return companyNumList;
	}

	public void setCompanyNumList(String companyNumList) {
		this.companyNumList = companyNumList;
	}

	public String getCompanyTypeList() {
		return companyTypeList;
	}

	public void setCompanyTypeList(String companyTypeList) {
		this.companyTypeList = companyTypeList;
	}

	public String getDegreeList() {
		return degreeList;
	}

	public void setDegreeList(String degreeList) {
		this.degreeList = degreeList;
	}

	public String getExpList() {
		return expList;
	}

	public void setExpList(String expList) {
		this.expList = expList;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

	@Override
	public String toString() {
		return "{\"cityList\":\"" + cityList + "\", \"companyNumList\":\"" + companyNumList
				+ "\", \"companyTypeList\":\"" + companyTypeList + "\", \"degreeList\":\"" + degreeList
				+ "\", \"expList\":\"" + expList + "\", \"start\":\"" + start + "\", \"space\":\"" + space + "\"}";
	}

	
}
