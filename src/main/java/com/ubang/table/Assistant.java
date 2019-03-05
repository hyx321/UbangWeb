package com.ubang.table;

/**
 * 萌新助手
 * @author huang
 *
 */
public class Assistant {
	private String question_key;
	private String answer_text;
	private String answer_url;
	private int type;
	private int send;
	public String getQuestion_key() {
		return question_key;
	}
	public void setQuestion_key(String question_key) {
		this.question_key = question_key;
	}
	public String getAnswer_text() {
		return answer_text;
	}
	public void setAnswer_text(String answer_text) {
		this.answer_text = answer_text;
	}
	public String getAnswer_url() {
		return answer_url;
	}
	public void setAnswer_url(String answer_url) {
		this.answer_url = answer_url;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getSend() {
		return send;
	}
	public void setSend(int send) {
		this.send = send;
	}
	@Override
	public String toString() {
		return "{\"question_key\":\"" + question_key + "\", \"answer_text\":\"" + answer_text + "\", \"answer_url\":\""
				+ answer_url + "\", \"type\":\"" + type + "\", \"send\":\"" + send + "\"}";
	}
	
}
