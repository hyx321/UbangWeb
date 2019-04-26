package com.ubang.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;
import com.ubang.table.User;

public interface UserService {
	
	Boolean UserLogin(User getUser);
	
	String ForgetPwd(User getUser);
	
	String Regiest(User user);
	
	String CheckUserOnly(User user);

	List<User> GetUser(User user);

	void CheckLogin(String name, String password, HttpServletResponse response);

	JSONArray getAllUsers();

	JSONArray GetUserAdmin(int iD);

	void DeleteUserAdmin(int iD);

	void UpdateUserAdmin(User user);

	void AddUserAdmin(User user);
}
