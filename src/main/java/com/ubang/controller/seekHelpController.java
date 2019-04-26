package com.ubang.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ubang.dao.JobDao;
import com.ubang.service.JobService;
import com.ubang.service.SeekHelpService;
import com.ubang.table.AlarmContent;
import com.ubang.table.Help;
import com.ubang.table.HelpInfoFilter;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;
import com.ubang.table.Pagination;
import com.ubang.table.Person;
import com.ubang.table.PersonSeekHelp;
import com.ubang.table.SeekHelpInfo;
import com.ubang.table.User;
import com.ubang.util.GeneratFileName;
import com.ubang.util.JobListUtil;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.EnumMorpher;
import net.sf.json.util.JSONUtils;

/**
 * 
 * @author huang
 *
 */

@Controller
@RequestMapping("/SeekHelp")
public class seekHelpController {
	

	@Autowired
	private SeekHelpService seekHelpService;

	
	//获取标签信息
	@RequestMapping(value="/GetMyHelpList",method=RequestMethod.POST)
	public void getMyHelpList(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
	
		response.getWriter().print("");
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(@RequestParam("files")MultipartFile[] file) {
		seekHelpService.savePic(file);
	}
	
	@RequestMapping(value="/saveHelp",method=RequestMethod.POST)
	public void saveHelp(HttpServletResponse response,String getHelp) throws IOException {

		Help help = JSON.parseObject(getHelp, new TypeReference<Help>(){});
	
		seekHelpService.postHelp(help);
		
		response.getWriter().print("OK");
	}
	
	@RequestMapping(value="/PublishHelp",method=RequestMethod.POST)
	public void PublishHelp(HttpServletResponse response,String getHelp) throws IOException {

		HelpInfoUpdate help = JSON.parseObject(getHelp, new TypeReference<HelpInfoUpdate>(){});

		java.util.Date date = new java.util.Date();          // 获取一个Date对象
        new Timestamp(date.getTime());
        help.setCreate_time(new Timestamp(date.getTime()).toLocaleString());
     	System.out.println(new Timestamp(date.getTime()).toLocaleString());
         
		String result = seekHelpService.PublishHelp(help);
		
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/GetMySeekHelp",method=RequestMethod.POST)
	public void GetMySeekHelp(HttpServletResponse response,String getHelp) throws IOException, ParseException {
		
		PersonSeekHelp personSeekHelp = JSON.parseObject(getHelp, new TypeReference<PersonSeekHelp>(){});
		List<HelpInfoUpdate> helpInfoUpdates = seekHelpService.GetMySeekHelp(personSeekHelp);
		
		response.getWriter().print(helpInfoUpdates);
	}
	
	
	@RequestMapping(value="/GetSeekHelp",method=RequestMethod.POST)
	public void GetSeekHelp(HttpServletResponse response,String getHelp) throws IOException, ParseException {
		
		PersonSeekHelp personSeekHelp = JSON.parseObject(getHelp, new TypeReference<PersonSeekHelp>(){});
		List<SeekHelpInfo> helpInfoUpdates = seekHelpService.GetSeekHelp(personSeekHelp);
		
		response.getWriter().print(helpInfoUpdates);
	}
	
	
	@RequestMapping(value="/PostPic",method=RequestMethod.POST)
	public void PostPic(HttpServletResponse response,HttpServletRequest request,String image) throws IOException {

		String result = "";
		try {
            request.setCharacterEncoding("utf-8");  //设置编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		try{
			String id = request.getHeader("helpId");
			int helpId = Integer.parseInt(id);
			DiskFileItemFactory dff = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dff);
			List<FileItem> items = sfu.parseRequest(request);
			// 获取上传字段
			FileItem fileItem = items.get(0);
			// 更改文件名为唯一的
			String filename = fileItem.getName();
			
			if (filename != null) {
				filename = GeneratFileName.getRandomName() + "." + FilenameUtils.getExtension(filename);
			}
			// 生成存储路径
			String storeDirectory = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\ubang";
			String storeDirectory1 = "http://119.23.232.90:8080/ubang/";
			File file = new File(storeDirectory);
			if (!file.exists()) {
				file.mkdir();
			}
			
			String filePath = storeDirectory1 + filename;
			result = seekHelpService.savePicture(filePath,helpId);
		}catch (Exception e) {
			// TODO: handle exception
			result = e.getMessage();
		}
		
		response.getWriter().print(result);
	}

	@RequestMapping(value="/personInfo",method=RequestMethod.POST)
	public void personInfo(HttpServletResponse response,String phone) throws IOException {

		Person person = seekHelpService.getPerson(phone);
		
		response.getWriter().print(person.toString());
	}
	
	@RequestMapping(value="/helpList",method=RequestMethod.POST)
	public void helpList(HttpServletResponse response,String getHelpList) throws IOException {

		HelpInfoFilter help = JSON.parseObject(getHelpList, new TypeReference<HelpInfoFilter>(){});
		List<Help> person = seekHelpService.helpList(help);
		
		response.getWriter().print(person);
	}
	
	
	
	@RequestMapping(value="/GetAlarmContent",method=RequestMethod.POST)
	public void GetAlarmContent(HttpServletResponse response,String user_phone) throws IOException {

		List<AlarmContent> alarms = seekHelpService.getAlarmContent(user_phone);
		
		response.getWriter().print(alarms);
	}
	
	@RequestMapping(value="/ModifyAlarm",method=RequestMethod.POST)
	public void ModifyAlarm(HttpServletResponse response,String getAlarmContent) throws IOException {

		AlarmContent alarmContent = (AlarmContent)JSONObject.toBean(JSONObject.fromObject(getAlarmContent), AlarmContent.class);
		
		String result = seekHelpService.ModifyAlarm(alarmContent);
		response.getWriter().print(result); 
	}
}
