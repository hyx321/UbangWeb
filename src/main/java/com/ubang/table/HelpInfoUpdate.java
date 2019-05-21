package com.ubang.table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class HelpInfoUpdate {
    private int id;
    private int recourse;
    private String content;
    private double start_position_lat;
    private double start_position_lng;
    private double end_position_lat;
    private double end_position_lng;
    private String create_time;
    private String type;
    private String status;
    private int has_picture;
    private int has_rule;
    private int is_urgent;
    private int helper;
    private double helper_position;
	private String avatar;
	private String nickname;
	private List<picture_url> pisList;
    
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getHelper() {
		return helper;
	}
	public void setHelper(int helper) {
		this.helper = helper;
	}
	public double getHelper_position() {
		return helper_position;
	}
	public void setHelper_position(double helper_position) {
		this.helper_position = helper_position;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"recourse\":\"" + recourse + "\", \"content\":\"" + content
				+ "\", \"start_position_lat\":\"" + start_position_lat + "\", \"start_position_lng\":\""
				+ start_position_lng + "\", \"end_position_lat\":\"" + end_position_lat + "\", \"end_position_lng\":\""
				+ end_position_lng + "\", \"create_time\":\"" + create_time + "\", \"type\":\"" + type
				+ "\", \"status\":\"" + status + "\", \"has_picture\":\"" + has_picture + "\", \"has_rule\":\""
				+ has_rule + "\", \"is_urgent\":\"" + is_urgent + "\", \"helper\":\"" + helper
				+ "\", \"helper_position\":\"" + helper_position + "\", \"avatar\":\"" + avatar + "\", \"nickname\":\""
				+ nickname + "\", \"pisList\":\"" + pisList + "\"}";
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
	public List<picture_url> getPisList() {
		return pisList;
	}
	public void setPisList(List<picture_url> pisList) {
		this.pisList = pisList;
	}
	
}
