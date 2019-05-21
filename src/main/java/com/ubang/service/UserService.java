package com.ubang.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSONArray;
import com.ubang.table.Administor;
import com.ubang.table.FeedBack;
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

	JSONArray getAllUsers();

	JSONArray GetUserAdmin(int iD);

	void DeleteUserAdmin(int iD);

	void UpdateUserAdmin(User user);

	void AddUserAdmin(User user);

	JSONArray GetAllManagerAdmin();

	void UpdateManagerAdmin(Administor admin);

	void AddManagerAdmin(Administor admin,String name);

	JSONArray GetManagerAdmin(int iD);

	void CheckLogin(HttpSession session, String name, String password, HttpServletResponse response);

	void PostFeedBack(FeedBack info);

	String PostAvatar(String url,int id);
}
