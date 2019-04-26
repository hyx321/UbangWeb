package com.ubang.table;

public class AlarmContent {
	private String user_phone;
	private String alarm_content;
	private int number;

	
	public String getAlarm_content() {
		return alarm_content;
	}
	public void setAlarm_content(String alarm_content) {
		this.alarm_content = alarm_content;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	@Override
	public String toString() {
		return "{\"user_phone\":\"" + user_phone + "\", \"alarm_content\":\"" + alarm_content + "\", \"number\":\""
				+ number + "\"}";
	}
	

}
