package com.ubang.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ubang.service.MengXinService;
import com.ubang.table.Pagination;
import com.ubang.table.SolveAssistant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 萌新模块功能
 * @author huang
 *
 */

@Controller
@RequestMapping("/MengXin")
public class MengXinController {
	@Autowired
	private MengXinService mengXinService;
	
	//获取图片的url和总数
	@RequestMapping(value="/CampusBeauty",method=RequestMethod.POST)
	public void CampusBeauty(Model model,HttpServletResponse response,String getPagination) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		try {	
			System.out.println("进入CampusBeauty函数");
			Pagination pagination = (Pagination) JSONObject.toBean(JSONObject.fromObject(getPagination), Pagination.class);
			JSONArray json = JSONArray.fromObject(mengXinService.getCampusBeauty(pagination));
			response.getWriter().print(json+"="+mengXinService.getPhotoSum());
			System.out.println(json+"="+mengXinService.getPhotoSum());
		}catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			e.printStackTrace();
		}
	
	}

	//获取助手的问答
	@RequestMapping(value="/Assistant",method=RequestMethod.POST)
	public void getAnswer(HttpServletResponse response,String question_key,HttpServletRequest request) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("进入getAnswer函数");
		JSONArray json = JSONArray.fromObject(mengXinService.getAnswer(question_key));
		System.out.println(json.toString());
		response.getWriter().print(json);
	}
	
	//获取对应已解决的问答
	@RequestMapping(value="/SolveAssistant",method=RequestMethod.POST)
	public void getSolveAssistant(HttpServletResponse response,String getSolveAssistant) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("进入getSolveAssistant函数");
		SolveAssistant solveAssistant = (SolveAssistant) JSONObject.toBean(JSONObject.fromObject(getSolveAssistant), SolveAssistant.class);
		JSONArray json = JSONArray.fromObject(mengXinService.getSolveAssistant(solveAssistant));
		System.out.println(json.toString());
		response.getWriter().print(json);
	}
	
	//获取所有已解决的问答
		@RequestMapping(value="/SolveAllAssistant",method=RequestMethod.POST)
		public void SolveAllAssistant(HttpServletResponse response,String getID) throws IOException{
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("进入getSolveAssistant函数");
			//JSONArray json = JSONArray.fromObject(mengXinService.getSolveAllAssistant(id));
			System.out.println(mengXinService.getSolveAllAssistant(Integer.parseInt(getID)));
			response.getWriter().print(mengXinService.getSolveAllAssistant(Integer.parseInt(getID)));
		}
}
