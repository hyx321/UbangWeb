package com.ubang.table;

import java.security.KeyStore.PrivateKeyEntry;

public class GetHelpBaseInfo {
	
	private String resourse;
	private String helper;
	private String recourse_create_time;
	private String helper_create_time;
	private String helper_end_time;
	private String content;
	private String type;
	private String description;
	private String rating;
	private int is_urgent;
	public String getResourse() {
		return resourse;
	}
	public void setResourse(String resourse) {
		this.resourse = resourse;
	}
	public String getHelper() {
		return helper;
	}
	public void setHelper(String helper) {
		this.helper = helper;
	}
	public String getRecourse_create_time() {
		return recourse_create_time;
	}
	public void setRecourse_create_time(String recourse_create_time) {
		this.recourse_create_time = recourse_create_time;
	}
	public String getHelper_create_time() {
		return helper_create_time;
	}
	public void setHelper_create_time(String helper_create_time) {
		this.helper_create_time = helper_create_time;
	}
	public String getHelper_end_time() {
		return helper_end_time;
	}
	public void setHelper_end_time(String helper_end_time) {
		this.helper_end_time = helper_end_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getIs_urgent() {
		return is_urgent;
	}
	public void setIs_urgent(int is_urgent) {
		this.is_urgent = is_urgent;
	}
	@Override
	public String toString() {
		return "{\"resourse\":\"" + resourse + "\", \"helper\":\"" + helper + "\", \"recourse_create_time\":\""
				+ recourse_create_time + "\", \"helper_create_time\":\"" + helper_create_time
				+ "\", \"helper_end_time\":\"" + helper_end_time + "\", \"content\":\"" + content + "\", \"type\":\""
				+ type + "\", \"description\":\"" + description + "\", \"rating\":\"" + rating + "\", \"is_urgent\":\""
				+ is_urgent + "\"}";
	}

	
}
