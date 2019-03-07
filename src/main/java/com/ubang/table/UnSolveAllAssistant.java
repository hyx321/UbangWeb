package com.ubang.table;

public class UnSolveAllAssistant {
	private int id;
	private String question_key;
	private int isSolve;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion_key() {
		return question_key;
	}
	public void setQuestion_key(String question_key) {
		this.question_key = question_key;
	}
	public int getIsSolve() {
		return isSolve;
	}
	public void setIsSolve(int isSolve) {
		this.isSolve = isSolve;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"question_key\":\"" + question_key + "\", \"isSolve\":\"" + isSolve + "\"}";
	}
	
	
}
