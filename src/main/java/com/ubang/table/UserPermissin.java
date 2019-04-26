package com.ubang.table;

public class UserPermissin {
	private int user_id;
	private String limit_permission_name;
	private String limit_permission_time;
	private String limit_reason;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLimit_permission_name() {
		return limit_permission_name;
	}
	public void setLimit_permission_name(String limit_permission_name) {
		this.limit_permission_name = limit_permission_name;
	}
	public String getLimit_permission_time() {
		return limit_permission_time;
	}
	public void setLimit_permission_time(String limit_permission_time) {
		this.limit_permission_time = limit_permission_time;
	}
	public String getLimit_reason() {
		return limit_reason;
	}
	public void setLimit_reason(String limit_reason) {
		this.limit_reason = limit_reason;
	}
	@Override
	public String toString() {
		return "{\"user_id\":\"" + user_id + "\", \"limit_permission_name\":\"" + limit_permission_name
				+ "\", \"limit_permission_time\":\"" + limit_permission_time + "\", \"limit_reason\":\"" + limit_reason
				+ "\"}";
	}
	
}
