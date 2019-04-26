package com.ubang.table;

public class PersonSeekHelp {
	private int userID;
	private int status;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "{\"userID\":\"" + userID + "\", \"status\":\"" + status + "\"}";
	}
	
}
