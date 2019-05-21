package com.ubang.table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class HelpBaseInfo {
    private int id;
    private String name;
    private String content;
    private String create_time;
    private String type;
    private String status;
    private int is_urgent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecourse() {
		return name;
	}
	public void setRecourse(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIs_urgent() {
		return is_urgent;
	}
	public void setIs_urgent(int is_urgent) {
		this.is_urgent = is_urgent;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"name\":\"" + name + "\", \"content\":\"" + content
				+ "\", \"create_time\":\"" + create_time + "\", \"type\":\"" + type + "\", \"status\":\"" + status
				+ "\", \"is_urgent\":\"" + is_urgent + "\"}";
	}
    

}
