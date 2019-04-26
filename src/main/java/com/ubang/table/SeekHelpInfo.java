package com.ubang.table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class SeekHelpInfo {
    private int id;
    private int recourse;
    private String content;
    private double start_position_lat;
    private double start_position_lng;
    private double end_position_lat;
    private double end_position_lng;
    private String create_time;
    private String type;
    private int has_picture;
    private int has_rule;
    private int is_urgent;
	private String avatar;
	private String nickname;
	
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecourse() {
		return recourse;
	}
	public void setRecourse(int recourse) {
		this.recourse = recourse;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getCreate_time() {
		return 	create_time;
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
	
	public int getHas_rule() {
		return has_rule;
	}
	public void setHas_rule(int has_rule) {
		this.has_rule = has_rule;
	}
	public int getIs_urgent() {
		return is_urgent;
	}
	public void setIs_urgent(int is_urgent) {
		this.is_urgent = is_urgent;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"recourse\":\"" + recourse + "\", \"content\":\"" + content
				+ "\", \"start_position_lat\":\"" + start_position_lat + "\", \"start_position_lng\":\""
				+ start_position_lng + "\", \"end_position_lat\":\"" + end_position_lat + "\", \"end_position_lng\":\""
				+ end_position_lng + "\", \"create_time\":\"" + create_time + "\", \"type\":\"" + type
				+ "\", \"has_picture\":\"" + has_picture + "\", \"has_rule\":\"" + has_rule + "\", \"is_urgent\":\""
				+ is_urgent + "\", \"avatar\":\"" + avatar + "\", \"nickname\":\"" + nickname + "\"}";
	}
	public double getStart_position_lat() {
		return start_position_lat;
	}
	public void setStart_position_lat(double start_position_lat) {
		this.start_position_lat = start_position_lat;
	}
	public double getStart_position_lng() {
		return start_position_lng;
	}
	public void setStart_position_lng(double start_position_lng) {
		this.start_position_lng = start_position_lng;
	}
	public double getEnd_position_lat() {
		return end_position_lat;
	}
	public void setEnd_position_lat(double end_position_lat) {
		this.end_position_lat = end_position_lat;
	}
	public double getEnd_position_lng() {
		return end_position_lng;
	}
	public void setEnd_position_lng(double end_position_lng) {
		this.end_position_lng = end_position_lng;
	}
	public int getHas_picture() {
		return has_picture;
	}
	public void setHas_picture(int has_picture) {
		this.has_picture = has_picture;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
