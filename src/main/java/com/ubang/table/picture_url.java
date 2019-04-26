package com.ubang.table;

public class picture_url {
	private int help_id;
	private String picture;
	public int getHelp_id() {
		return help_id;
	}
	public void setHelp_id(int help_id) {
		this.help_id = help_id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "{\"help_id\":\"" + help_id + "\", \"picture\":\"" + picture + "\"}";
	}
	
}
