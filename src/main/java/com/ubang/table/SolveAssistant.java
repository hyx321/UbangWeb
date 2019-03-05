package com.ubang.table;

public class SolveAssistant {
	private int id;
	private String question_key;
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
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"question_key\":\"" + question_key + "\"}";
	}
	
}	
