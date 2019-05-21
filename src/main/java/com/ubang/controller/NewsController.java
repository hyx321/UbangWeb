package com.ubang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ubang.service.JobService;
import com.ubang.service.NewsService;
import com.ubang.service.UserService;
import com.ubang.table.Administor;
import com.ubang.table.JobFirst;
import com.ubang.table.Pagination;
import com.ubang.table.User;

@Controller
@RequestMapping("/News")
public class NewsController {
	@Autowired
	private NewsService newsService;
		
	@RequestMapping(value="/GetAllNewsAdmin",method=RequestMethod.GET)
	public String GetAllNewsAdmin(Model model) throws IOException{
		int page = 0;
		JSONArray json = newsService.GetAllNewsAdmin(page);	
		model.addAttribute("newslist",json);		
		model.addAttribute("page",page);	
		return "NewsList";
	}	
	
	
	@RequestMapping(value="/GetNewsAdmin",method=RequestMethod.GET)
	public void GetNewsAdmin(Model model,int id,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
	    JSONArray json = newsService.GetNewsAdmin(id);
		response.getWriter().print(json.get(0));
	}	

	@RequestMapping(value="/DeleteNewsAdmin",method=RequestMethod.GET)
	public void DeleteNewsAdmin(Model model,int id,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
	    newsService.DeleteNewsAdmin(id);
		response.getWriter().print("1");
	}	

	@RequestMapping(value="/UpdateNewsAdmin",method=RequestMethod.GET)
	public void UpdateNewsAdmin(Model model,JobFirst jobFirst,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
	    newsService.UpdateNewsAdmin(jobFirst);
		response.getWriter().print("1");
	}	
	
	@RequestMapping(value="/GetCampusSafeList",method=RequestMethod.POST)
	public void GetCampusSafeList(Model model,int start,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
	    String result = newsService.GetCampusSafeList(start);
		response.getWriter().print(result);
	}	
	
	@RequestMapping(value="/GetCampusPresentationList",method=RequestMethod.POST)
	public void GetCampusPresentationList(Model model,int start,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
	   //String result = newsService.GetCampusPresentationList(start);
//		response.getWriter().print(result);
	}	
}
