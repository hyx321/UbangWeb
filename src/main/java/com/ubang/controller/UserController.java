package com.ubang.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ubang.service.JobService;
import com.ubang.service.UserService;
import com.ubang.table.Administor;
import com.ubang.table.FeedBack;
import com.ubang.table.Pagination;
import com.ubang.table.User;
import com.ubang.util.GeneratFileName;
import com.ubang.util.MoreUtil;

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
	public void CheckLoginAdmin(Model model,HttpSession session,String name,String password,HttpServletResponse response) throws IOException{
		name= java.net.URLDecoder.decode(name, "UTF-8");
		userService.CheckLogin(session,name,password,response);			
	}
	
	@RequestMapping(value="/GetAllUsersAdmin",method=RequestMethod.GET)
	public String GetAllUsersAdmin(Model model) throws IOException{
		
		JSONArray json = userService.getAllUsers();	
		model.addAttribute("users",json);		
	
		return "UsersList";
	}
	
	@RequestMapping(value="/GetAllManagerAdmin",method=RequestMethod.GET)
	public String GetAllManagerAdmin(Model model) throws IOException{
		
		JSONArray json = userService.GetAllManagerAdmin();	
		model.addAttribute("managers",json);		
	
		return "ManagerList";
	}
	
	
	@RequestMapping(value="/GetUserAdmin",method=RequestMethod.POST)
	public void GetUserAdmin(Model model,HttpServletResponse response,int ID) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		JSONArray json = userService.GetUserAdmin(ID);
		response.getWriter().print(json.get(0));
	}
	
	@RequestMapping(value="/GetManagerAdmin",method=RequestMethod.POST)
	public void GetManagerAdmin(Model model,HttpServletResponse response,int ID) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		JSONArray json = userService.GetManagerAdmin(ID);
		response.getWriter().print(json.get(0));
	}
	
	@RequestMapping(value="/AddUserAdmin",method=RequestMethod.POST)
	public void AddUserAdmin(Model model,User user,HttpServletResponse response) throws IOException{
		userService.AddUserAdmin(user);
		response.getWriter().print("1");
	}
	
	@RequestMapping(value="/UpdateManagerAdmin",method=RequestMethod.POST)
	public void UpdateManagerAdmin(Model model,Administor admin,HttpServletResponse response) throws IOException{
		
		userService.UpdateManagerAdmin(admin);
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
	
	@RequestMapping(value="/AddManagerAdmin",method=RequestMethod.POST)
	public void AddManagerAdmin(Model model,HttpSession session,Administor admin,HttpServletResponse response) throws IOException{
		String name = (String) session.getAttribute("name");
		userService.AddManagerAdmin(admin,name);
		response.getWriter().print("1");
	}
	
	@RequestMapping(value="/PostFeedBack",method=RequestMethod.POST)
	public void PostFeedBack(Model model,String feedBack,HttpServletResponse response) throws IOException{
		FeedBack info = JSON.parseObject(feedBack, FeedBack.class);
		userService.PostFeedBack(info);
		response.getWriter().print("1");
	}

	@RequestMapping(value="/PostAvatar",method=RequestMethod.POST)
	public void PostAvatar(HttpServletResponse response,HttpServletRequest request) throws IOException, FileUploadException {

		String result = "";	
			
		try {
            request.setCharacterEncoding("utf-8");  //设置编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		
		String id = request.getHeader("id");
		int helpId = Integer.parseInt(id);
		
		MoreUtil saveFile = new MoreUtil();
		String filePath = saveFile.savePic(request, helpId);
		if(filePath.equals("0")) {
			response.getWriter().print("0");
		}else{
			result = userService.PostAvatar(filePath,helpId);
			response.getWriter().print(result);
		}
	}
}
