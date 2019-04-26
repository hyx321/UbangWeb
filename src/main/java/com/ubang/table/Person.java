package com.ubang.table;


/**
 * Created by huang on 2019/4/13.
 */

public class Person {
    private String phone;
    private String name;
    private String headUrl;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

	@Override
	public String toString() {
		return "{\"phone\":\"" + phone + "\", \"name\":\"" + name + "\", \"headUrl\":\"" + headUrl + "\"}";
	}
    
}
