package com.ubang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ubang.service.JobService;
import com.ubang.service.UserService;
import com.ubang.table.Pagination;
import com.ubang.table.User;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/UserLogin",method=RequestMethod.POST)
	public void UserLogin(Model model,HttpServletResponse response,String getUser) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		User user = JSON.parseObject(getUser, User.class);
		Boolean result = userService.UserLogin(user);
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/ForgetPwd",method=RequestMethod.POST)
	public void ForgetPwd(Model model,HttpServletResponse response,String getUser) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		
		User user = JSON.parseObject(getUser, User.class);
		String result = userService.ForgetPwd(user);
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/Regiest",method=RequestMethod.POST)
	public void Regiest(Model model,HttpServletResponse response,String getUser) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		User user = JSON.parseObject(getUser, User.class);
		String text = userService.CheckUserOnly(user);
		response.getWriter().print(text);
	}	
	
	@RequestMapping(value="/GetUser",method=RequestMethod.POST)
	public void GetUser(Model model,HttpServletResponse response,String getUser) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		User user = JSON.parseObject(getUser, User.class);
		List<User> result = userService.GetUser(user);
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/CheckLoginAdmin",method=RequestMethod.GET)
	public void CheckLoginAdmin(Model model,String name,String password,HttpServletResponse response) throws IOException{
		name= java.net.URLDecoder.decode(name, "UTF-8");
		userService.CheckLogin(name,password,response);	
	
	}
	
	@RequestMapping(value="/GetAllUsersAdmin",method=RequestMethod.GET)
	public String GetAllUsersAdmin(Model model) throws IOException{
		
		JSONArray json = userService.getAllUsers();	
		model.addAttribute("users",json);		
	
		return "UsersList";
	}
	
	
	@RequestMapping(value="/GetUserAdmin",method=RequestMethod.POST)
	public void GetUserAdmin(Model model,HttpServletResponse response,int ID) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		JSONArray json = userService.GetUserAdmin(ID);
		response.getWriter().print(json.get(0));
	}
	
	@RequestMapping(value="/AddUserAdmin",method=RequestMethod.POST)
	public void AddUserAdmin(Model model,User user,HttpServletResponse response) throws IOException{
		userService.AddUserAdmin(user);
		response.getWriter().print("1");
	}
	
	@RequestMapping(value="/UpdateUserAdmin",method=RequestMethod.POST)
	public void UpdateUserAdmin(Model model,User user,HttpServletResponse response) throws IOException{
		userService.UpdateUserAdmin(user);
		response.getWriter().print("1");
	}

	@RequestMapping(value="/DeleteUserAdmin",method=RequestMethod.POST)
	public void DeleteUserAdmin(Model model,int ID,HttpServletResponse response) throws IOException{
		userService.DeleteUserAdmin(ID);
		response.getWriter().print("1");
	}
}
