package com.ubang.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ubang.dao.JobDao;
import com.ubang.service.JobService;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;
import com.ubang.table.Pagination;
import com.ubang.util.JobListUtil;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.EnumMorpher;
import net.sf.json.util.JSONUtils;

/**
 * 职业指南模块功能
 * @author huang
 *
 */

@Controller
@RequestMapping("/Job")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	JobListUtil jobListUtil = new JobListUtil();
	
	//获取标签信息
	@RequestMapping(value="/GetTag",method=RequestMethod.POST)
	public void getTag(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		
		String Tag = String.join(",", jobService.getCityTag())+":"+String.join(",",jobListUtil.setNum())+":"+String.join(",",jobService.getCompanyType())
		+":"+String.join(",",jobListUtil.setDegree())+":"+String.join(",",jobListUtil.setExp());
		
		response.getWriter().print(Tag);
	}
	
	@RequestMapping(value="/GetJobInfo",method=RequestMethod.POST)
	public void getJobInfo(HttpServletResponse response,String getJobInfo) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		
		JobInfoUpdate jobInfo = JSON.parseObject(getJobInfo, new TypeReference<JobInfoUpdate>(){});
	
		List<Job> jobInfoList = jobService.getJobInfo(jobInfo);
		
		System.out.println(jobInfoList.toString());
		response.getWriter().print(jobInfoList);
	}
}
