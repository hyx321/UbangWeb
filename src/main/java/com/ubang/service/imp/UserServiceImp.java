package com.ubang.service.imp;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ubang.dao.JobDao;
import com.ubang.dao.UserDao;
import com.ubang.service.JobService;
import com.ubang.service.UserService;
import com.ubang.table.Administor;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;
import com.ubang.table.User;


@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public Boolean UserLogin(User getUser) {
		if(getUser.getPassword().equals(userDao.UserLogin(getUser))){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String ForgetPwd(User getUser) {
		// TODO Auto-generated method stub
		try {
			userDao.ForgetPwd(getUser);
			return "1";
		}catch (Exception e) {
			// TODO: handle exception
			return e.getMessage().toString();
		}
		
	}

	@Override
	public String Regiest(User user) {
		// TODO Auto-generated method stub
		try {
			userDao.Regiest(user);
			return "1";
		}catch (Exception e) {
			// TODO: handle exception
			return e.getMessage().toString();
		}
	}

	@Override
	public String CheckUserOnly(User user) {
		// TODO Auto-generated method stub
	
		List<User> userList = userDao.CheckUserOnly(user);
		
		if(userList.size() == 1) {
			if(userList.get(0).getNickname().equals(user.getNickname())) {
				return "昵称重复...";
			}else if(userList.get(0).getPhone().equals(user.getPhone())) {
				return "你的手机号已经绑定过了...";
			}
		}else if (userList.size() == 2){
			return "昵称和手机号都重复了...";
		}
				
		return Regiest(user);
	}
	

	@Override
	public List<User> GetUser(User user) {
		// TODO Auto-generated method stub
		return userDao.CheckUserOnly(user);
	}

	@Override
	public void CheckLogin(String name, String password,HttpServletResponse response) {
		
		try {
			Administor administor = new Administor();
			administor.setName(name);
			administor.setPassword(password);
			administor.setPhone(name);
			List<Administor> administors = userDao.CheckLogin(administor);
			if(administors.size() == 1) {
				response.sendRedirect("/ubang/User/GetAllUsersAdmin");
			}else {
				response.sendRedirect("/ubang/index.jsp");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		
	}

	public JSONArray getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userDao.getAllUsers();
		JSONArray json = JSON.parseArray(users.toString());	
	
		return json;
	}

	public JSONArray GetUserAdmin(int ID) {
		// TODO Auto-generated method stub
		
		List<User> users = userDao.GetUserAdmin(ID);
		JSONArray json = JSON.parseArray(users.toString());
		
		return json;
	}

	@Override
	public void DeleteUserAdmin(int iD) {
		// TODO Auto-generated method stub
		userDao.DeleteUserAdmin(iD);
	}

	@Override
	public void UpdateUserAdmin(User user) {
		// TODO Auto-generated method stub
		userDao.UpdateUserAdmin(user);
		
	}

	@Override
	public void AddUserAdmin(User user) {
		// TODO Auto-generated method stub
		user.setAvatar("http://img3.duitang.com/uploads/item/201408/28/20140828170248_QGGmh.jpeg");
		user.setPermission(0);
		userDao.AddUserAdmin(user);
	}

	
}
