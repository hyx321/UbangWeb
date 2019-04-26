package com.ubang.table;

import java.util.List;

/**
 * Created by huang on 2019/4/13.
 */

public class Help {
	 private String help_content;
    private String help_taskId;
    private String help_phone;
    private String help_startPosition;
    private String help_endPosition;
    private String help_name;
    private String help_date;
    private int help_url;
    private String help_type;
    private int help_status;
    private String accept_phone;
    private String accert_position;
    private String isNormal;
    
    
    
	@Override
	public String toString() {
		return "{\"help_content\":\"" + help_content + "\", \"help_taskId\":\"" + help_taskId + "\", \"help_phone\":\""
				+ help_phone + "\", \"help_startPosition\":\"" + help_startPosition + "\", \"help_endPosition\":\""
				+ help_endPosition + "\", \"help_name\":\"" + help_name + "\", \"help_date\":\"" + help_date
				+ "\", \"help_url\":\"" + help_url + "\", \"help_type\":\"" + help_type + "\", \"help_status\":\""
				+ help_status + "\", \"accept_phone\":\"" + accept_phone + "\", \"accert_position\":\""
				+ accert_position + "\", \"isNormal\":\"" + isNormal + "\"}";
	}


	public String getHelp_content() {
		return help_content;
	}


	public void setHelp_content(String help_content) {
		this.help_content = help_content;
	}


	public String getHelp_taskId() {
		return help_taskId;
	}


	public void setHelp_taskId(String help_taskId) {
		this.help_taskId = help_taskId;
	}


	public String getHelp_phone() {
		return help_phone;
	}


	public void setHelp_phone(String help_phone) {
		this.help_phone = help_phone;
	}


	public String getHelp_startPosition() {
		return help_startPosition;
	}


	public void setHelp_startPosition(String help_startPosition) {
		this.help_startPosition = help_startPosition;
	}


	public String getHelp_endPosition() {
		return help_endPosition;
	}


	public void setHelp_endPosition(String help_endPosition) {
		this.help_endPosition = help_endPosition;
	}


	public String getHelp_name() {
		return help_name;
	}


	public void setHelp_name(String help_name) {
		this.help_name = help_name;
	}


	public String getHelp_date() {
		return help_date;
	}


	public void setHelp_date(String help_date) {
		this.help_date = help_date;
	}


	
	

	public int getHelp_status() {
		return help_status;
	}


	public void setHelp_status(int help_status) {
		this.help_status = help_status;
	}


	public String getAccept_phone() {
		return accept_phone;
	}


	public void setAccept_phone(String accept_phone) {
		this.accept_phone = accept_phone;
	}


	public String getAccert_position() {
		return accert_position;
	}


	public void setAccert_position(String accert_position) {
		this.accert_position = accert_position;
	}


	public String getHelp_type() {
		return help_type;
	}


	public void setHelp_type(String help_type) {
		this.help_type = help_type;
	}


	public String getIsNormal() {
		return isNormal;
	}


	public void setIsNormal(String isNormal) {
		this.isNormal = isNormal;
	}


	public int getHelp_url() {
		return help_url;
	}


	public void setHelp_url(int help_url) {
		this.help_url = help_url;
	}




  
}
