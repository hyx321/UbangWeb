package com.ubang.table;

/**
 * 用户
 * @author huang
 *
 */
public class User {
	private int id;
	private String nickname;
	private String name;
	private String password;
	private int permission;
	private String qq;
	private String email;
	private String wechat;
	private String sex;
	private String avatar;
	private String signature;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"nickname\":\"" + nickname + "\", \"name\":\"" + name + "\", \"password\":\""
				+ password + "\", \"permission\":\"" + permission + "\", \"qq\":\"" + qq + "\", \"email\":\"" + email
				+ "\", \"wechat\":\"" + wechat + "\", \"sex\":\"" + sex + "\", \"avatar\":\"" + avatar
				+ "\", \"signature\":\"" + signature + "\", \"phone\":\"" + phone + "\"}";
	}
	
	
}
