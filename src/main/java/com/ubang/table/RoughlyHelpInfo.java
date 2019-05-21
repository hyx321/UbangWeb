package com.ubang.table;

public class RoughlyHelpInfo {
	private int help_id;
	private int helper;
	private int resourse;
	private int type;
	public int getHelp_id() {
		return help_id;
	}
	public void setHelp_id(int help_id) {
		this.help_id = help_id;
	}
	public int getHelper() {
		return helper;
	}
	public void setHelper(int helper) {
		this.helper = helper;
	}
	public int getResourse() {
		return resourse;
	}
	public void setResourse(int resourse) {
		this.resourse = resourse;
	}
	@Override
	public String toString() {
		return "{\"help_id\":\"" + help_id + "\", \"helper\":\"" + helper + "\", \"resourse\":\"" + resourse
				+ "\", \"type\":\"" + type + "\"}";
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
