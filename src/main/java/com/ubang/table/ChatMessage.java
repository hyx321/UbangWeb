package com.ubang.table;

import java.security.KeyStore.PrivateKeyEntry;

public class ChatMessage {
    private int message_id;
    private int resourse;
    private int help_id;
    private int helper;
    private String resourse_name;
    private String helper_name;
    private String content;
    private String pic_url;
    private String time;
    private double position_lat;
    private double position_lng;
    private int recieve;
    private int send;
    private String resourse_avatar;
    private String helper_avatar;
    private String Option;
    
    public int getSend() {
        return send;
    }

    @Override
	public String toString() {
		return "{\"message_id\":\"" + message_id + "\", \"resourse\":\"" + resourse + "\", \"help_id\":\"" + help_id
				+ "\", \"helper\":\"" + helper + "\", \"resourse_name\":\"" + resourse_name + "\", \"helper_name\":\""
				+ helper_name + "\", \"content\":\"" + content + "\", \"pic_url\":\"" + pic_url + "\", \"time\":\""
				+ time + "\", \"position_lat\":\"" + position_lat + "\", \"position_lng\":\"" + position_lng
				+ "\", \"recieve\":\"" + recieve + "\", \"send\":\"" + send + "\", \"resourse_avatar\":\""
				+ resourse_avatar + "\", \"helper_avatar\":\"" + helper_avatar + "\", \"Option\":\"" + Option + "\"}";
	}

    public void setSend(int send) {
        this.send = send;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getResourse() {
        return resourse;
    }

    public void setResourse(int resourse) {
        this.resourse = resourse;
    }

    public int getHelp_id() {
        return help_id;
    }

    public void setHelp_id(int help_id) {
        this.help_id = help_id;
    }

    public int getHelper() {
        return helper;
    }

    public void setHelper(int helper) {
        this.helper = helper;
    }

    public String getResourse_name() {
        return resourse_name;
    }

    public void setResourse_name(String resourse_name) {
        this.resourse_name = resourse_name;
    }

    public String getHelper_name() {
        return helper_name;
    }

    public void setHelper_name(String helper_name) {
        this.helper_name = helper_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPosition_lat() {
        return position_lat;
    }

    public void setPosition_lat(double position_lat) {
        this.position_lat = position_lat;
    }

    public double getPosition_lng() {
        return position_lng;
    }

    public void setPosition_lng(double position_lng) {
        this.position_lng = position_lng;
    }

    public int getRecieve() {
        return recieve;
    }

    public void setRecieve(int recieve) {
        this.recieve = recieve;
    }

	public String getResourse_avatar() {
		return resourse_avatar;
	}

	public void setResourse_avatar(String resourse_avatar) {
		this.resourse_avatar = resourse_avatar;
	}

	public String getHelper_avatar() {
		return helper_avatar;
	}

	public void setHelper_avatar(String helper_avatar) {
		this.helper_avatar = helper_avatar;
	}

	public String getOption() {
		return Option;
	}

	public void setOption(String option) {
		Option = option;
	}
}