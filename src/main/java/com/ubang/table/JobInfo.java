package com.ubang.table;

import java.util.List;

/**
 * 为了获取招聘信息
 * 筛选的内容
 * @author huang
 *
 */
public class JobInfo {
	private List<String> cityList;
	private List<String> companyNumList;
	private List<String> companyTypeList;
	private List<String> degreeList;
	private List<String> expList;
	private int start;
	private int space;
	
	@Override
	public String toString() {
		return "{\"cityList\":\"" + cityList + "\", \"companyNumList\":\"" + companyNumList
				+ "\", \"companyTypeList\":\"" + companyTypeList + "\", \"degreeList\":\"" + degreeList
				+ "\", \"expList\":\"" + expList + "\"}";
	}


	public List<String> getCityList() {
		return cityList;
	}


	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}


	public List<String> getCompanyNumList() {
		return companyNumList;
	}


	public void setCompanyNumList(List<String> companyNumList) {
		this.companyNumList = companyNumList;
	}


	public List<String> getCompanyTypeList() {
		return companyTypeList;
	}


	public void setCompanyTypeList(List<String> companyTypeList) {
		this.companyTypeList = companyTypeList;
	}


	public List<String> getDegreeList() {
		return degreeList;
	}


	public void setDegreeList(List<String> degreeList) {
		this.degreeList = degreeList;
	}


	public List<String> getExpList() {
		return expList;
	}


	public void setExpList(List<String> expList) {
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
	
	
}
