package com.ubang.table;

public class CampusPresent {
	private String city;
	private String hold_time;
	private String detail_time;
	private String company;
	private String university;
	private String presentation_place;
	private String presentation_detail;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHold_time() {
		return hold_time;
	}
	public void setHold_time(String hold_time) {
		this.hold_time = hold_time;
	}
	public String getDetail_time() {
		return detail_time;
	}
	public void setDetail_time(String detail_time) {
		this.detail_time = detail_time;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getPresentation_place() {
		return presentation_place;
	}
	public void setPresentation_place(String presentation_place) {
		this.presentation_place = presentation_place;
	}
	public String getPresentation_detail() {
		return presentation_detail;
	}
	public void setPresentation_detail(String presentation_detail) {
		this.presentation_detail = presentation_detail;
	}
	@Override
	public String toString() {
		return "{\"city\":\"" + city + "\", \"hold_time\":\"" + hold_time + "\", \"detail_time\":\"" + detail_time
				+ "\", \"company\":\"" + company + "\", \"university\":\"" + university
				+ "\", \"presentation_place\":\"" + presentation_place + "\", \"presentation_detail\":\""
				+ presentation_detail + "\"}";
	}
	
}
