package com.ubang.table;

public class Administor {
	private int id;
	private String name;
	private String phone;
	private String password;
	private String who_create;
	private int root;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"name\":\"" + name + "\", \"phone\":\"" + phone + "\", \"password\":\""
				+ password + "\", \"who_create\":\"" + who_create + "\", \"root\":\"" + root + "\"}";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWho_create() {
		return who_create;
	}
	public void setWho_create(String who_create) {
		this.who_create = who_create;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	

}
