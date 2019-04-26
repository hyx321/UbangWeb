package com.ubang.dao;

import java.util.HashMap;
import java.util.List;

import com.ubang.table.Administor;
import com.ubang.table.AlarmContent;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;
import com.ubang.table.User;

public interface UserDao {
	
	String UserLogin(User getUser);
	
	void ForgetPwd(User user);
	
	void Regiest(User user);
	
	List<User> CheckUserOnly(User user);
	 
	List<Administor> CheckLogin(Administor administor);
	
	List<User> getAllUsers();
	
	List<User> GetUserAdmin(int ID);
	
	void DeleteUserAdmin(int ID);

	void UpdateUserAdmin(User user);

	void AddUserAdmin(User user);
	
}
