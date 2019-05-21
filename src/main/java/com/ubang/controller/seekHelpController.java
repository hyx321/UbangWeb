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
import org.springframework.ui.Model;
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
import com.ubang.table.ChatMessage;
import com.ubang.table.Help;
import com.ubang.table.HelpBaseInfo;
import com.ubang.table.HelpDetailInfo;
import com.ubang.table.HelpInfoFilter;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.HelpInfomation;
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
import com.ubang.util.MoreUtil;

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
	public void PublishHelp(HttpServletResponse response,String getHelp,HttpServletRequest request) throws IOException {

		HelpInfoUpdate help = JSON.parseObject(getHelp, new TypeReference<HelpInfoUpdate>(){});
        MoreUtil moreUtil = new MoreUtil();
        help.setCreate_time(moreUtil.getTime());
    
        String resultPic= "";
        if(help.getHas_picture() == 1) {
        	try {
                request.setCharacterEncoding("utf-8");  //设置编码
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
    		
    		MoreUtil saveFile = new MoreUtil();
    		List<String> filePath = saveFile.saveMultPics(request);
    		if(filePath == null) {
    			resultPic = "0";
    		}else{
    			resultPic = seekHelpService.saveMultPicture(filePath,help.getId());
    		}
        }
        if(resultPic.equals("0")) {
        	help.setHas_picture(0);
        }
        String result = seekHelpService.PublishHelp(help);
		response.getWriter().print(result+":"+resultPic);
	}
	
	
	@RequestMapping(value="/DeleteHelp",method=RequestMethod.POST)
	public void DeleteHelp(HttpServletResponse response,String id) throws IOException {
		String result = seekHelpService.DeleteHelp(Integer.parseInt(id));
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/CancelHelp",method=RequestMethod.POST)
	public void CancelHelp(HttpServletResponse response,String id) throws IOException {
		String result = seekHelpService.CancelHelp(Integer.parseInt(id));
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/FinishHelp",method=RequestMethod.POST)
	public void FinishHelp(HttpServletResponse response,String id) throws IOException {
		String result = seekHelpService.FinishHelp(Integer.parseInt(id));
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/GetHelp",method=RequestMethod.POST)
	public void GetHelp(HttpServletResponse response,String getHelp) throws IOException {
		HelpInfomation help = JSON.parseObject(getHelp, HelpInfomation.class);
		
		String result = seekHelpService.GetHelp(help);
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/ModifyHelpContent",method=RequestMethod.POST)
	public void ModifyHelpContent(HttpServletResponse response,String helpInfo) throws IOException {
		HelpInfoUpdate help = JSON.parseObject(helpInfo, HelpInfoUpdate.class);
		String result = seekHelpService.ModifyHelpContent(help);
		response.getWriter().print(result);
	}
	
	
	@RequestMapping(value="/GetMySeekHelp",method=RequestMethod.POST)
	public void GetMySeekHelp(HttpServletResponse response,String getHelp) throws IOException, ParseException {
		
		PersonSeekHelp personSeekHelp = JSON.parseObject(getHelp, new TypeReference<PersonSeekHelp>(){});
		String result = seekHelpService.GetMySeekHelp(personSeekHelp);
		
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/GetMyHelp",method=RequestMethod.POST)
	public void GetMyHelp(HttpServletResponse response,String getHelp) throws IOException, ParseException {
		
		PersonSeekHelp personSeekHelp = JSON.parseObject(getHelp, new TypeReference<PersonSeekHelp>(){});
		String helpInfoUpdates = seekHelpService.GetMyHelp(personSeekHelp);
		response.getWriter().print(helpInfoUpdates);
	}
	
	
	@RequestMapping(value="/GetSeekHelp",method=RequestMethod.POST)
	public void GetSeekHelp(HttpServletResponse response,String getHelp) throws IOException, ParseException {
		
		PersonSeekHelp personSeekHelp = JSON.parseObject(getHelp, new TypeReference<PersonSeekHelp>(){});
		String result = seekHelpService.GetSeekHelp(personSeekHelp);
		
		response.getWriter().print(result);
	}
	
	
	@RequestMapping(value="/GetHelpInfo",method=RequestMethod.POST)
	public void GetHelpInfo(HttpServletResponse response,String id) throws IOException, ParseException {
		
		List<HelpDetailInfo> helpDetailInfos = seekHelpService.GetHelpInfo(Integer.parseInt(id));
		
		response.getWriter().print(helpDetailInfos);
	}
	

	@RequestMapping(value="/GetUnHelpInfo",method=RequestMethod.POST)
	public void GetUnHelpInfo(HttpServletResponse response,String id) throws IOException, ParseException {
		
		List<HelpDetailInfo> helpDetailInfos = seekHelpService.GetUnHelpInfo(Integer.parseInt(id));
		
		response.getWriter().print(helpDetailInfos);
	}
	
	
	@RequestMapping(value="/PostRating",method=RequestMethod.POST)
	public void PostRating(HttpServletResponse response,String rating) throws IOException, ParseException {
		
		seekHelpService.PostRating(rating);
		
		response.getWriter().print("1");
	}
	
	
	
	@RequestMapping(value="/PostPic",method=RequestMethod.POST)
	public void PostPic(HttpServletResponse response,HttpServletRequest request,String image) throws IOException {

		try {
            request.setCharacterEncoding("utf-8");  //设置编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		
		String id = request.getHeader("helpId");
		int helpId = Integer.parseInt(id);
		
		MoreUtil saveFile = new MoreUtil();
		String filePath = saveFile.savePic(request, helpId);
		if(filePath.equals("0")) {
			response.getWriter().print("0");
		}else{
			String result = seekHelpService.savePicture(filePath,helpId);
			response.getWriter().print(result);
		}
	}
	

	@RequestMapping(value="/PostCharMessagePic",method=RequestMethod.POST)
	public void PostCharMessagePic(HttpServletResponse response,HttpServletRequest request,String chatMessage) throws IOException {

		try {
            request.setCharacterEncoding("utf-8");  //设置编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	
		ChatMessage chat = JSON.parseObject(chatMessage,ChatMessage.class);
		MoreUtil saveFile = new MoreUtil();
		String filePath = saveFile.savePic(request, chat.getHelp_id());
		if(filePath.equals("0")) {
			response.getWriter().print("0");
		}else{
			chat.setPic_url(filePath);
			String result = seekHelpService.PostCharMessagePic(chat);
			response.getWriter().print(result);
		}
	}
	
	@RequestMapping(value="/PostCharMessage",method=RequestMethod.POST)
	public void PostCharMessage(HttpServletResponse response,HttpServletRequest request,String image,String chatMessage) throws IOException {
	
		String result = "";
		try {
            request.setCharacterEncoding("utf-8");  //设置编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		
		ChatMessage chat = JSON.parseObject(chatMessage,ChatMessage.class);
		if(!chat.getPic_url().equals("null")) {
			
			MoreUtil saveFile = new MoreUtil();
			String filePath = saveFile.savePic(request, chat.getHelp_id());
			if(filePath.equals("0")) {
				result = "0";
			}else{
				chat.setPic_url(filePath);
			}
		}
		if(result.equals("0")) {
			response.getWriter().print(result);
		}else {
			result = seekHelpService.PostCharMessage(chat);
			response.getWriter().print(result);
		}
	
	}

	@RequestMapping(value="/personInfo",method=RequestMethod.POST)
	public void personInfo(HttpServletResponse response,String phone) throws IOException {

		Person person = seekHelpService.getPerson(phone);
		
		response.getWriter().print(person.toString());
	}
	
	@RequestMapping(value="/helpList",method=RequestMethod.POST)
	public void helpList(HttpServletResponse response,String getHelpList) throws IOException {

		HelpInfoFilter help = JSON.parseObject(getHelpList, new TypeReference<HelpInfoFilter>(){});
		String result = seekHelpService.helpList(help);
		
		response.getWriter().print(result);
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
	
	
	@RequestMapping(value="/GetSeekHelpListAdmin",method=RequestMethod.GET)
	public String GetSeekHelpListAdmin(Model model) throws IOException, ParseException {
			
		com.alibaba.fastjson.JSONArray json = seekHelpService.GetSeekHelpListAdmin();
		model.addAttribute("seekHelps",json);		
	
		return "SeekHelpList";
	}
	
	@RequestMapping(value="/SortHelpListAdmin",method=RequestMethod.GET)
	public String SortHelpListAdmin(Model model,String type,HttpServletRequest request) throws IOException, ParseException {

		com.alibaba.fastjson.JSONArray json = seekHelpService.SortHelpListAdmin(type);
		model.addAttribute("seekHelps",json);		
	
		return "SeekHelpList";
	}
	
	@RequestMapping(value="/DeleteSeekHelpListAdmin",method=RequestMethod.POST)
	public void DeleteSeekHelpListAdmin(Model model,int id,HttpServletResponse response) throws IOException, ParseException {			
		seekHelpService.DeleteSeekHelpListAdmin(id);
		response.getWriter().print("1"); 
	}
	
	
	/**
	 * 获取已完成的信息
	 * @param model
	 * @param id
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value="/GetSeekHelpAdmin",method=RequestMethod.POST)
	public void GetSeekHelpAdmin(Model model,int id,HttpServletResponse response) throws IOException, ParseException {			
		response.setContentType("text/html;charset=UTF-8");
		com.alibaba.fastjson.JSONArray json = seekHelpService.GetSeekHelpAdmin(id);
		response.getWriter().print(json.get(0));
	}
	
	@RequestMapping(value="/GetHelpInfoAdmin",method=RequestMethod.POST)
	public void GetHelpInfoAdmin(Model model,int id,HttpServletResponse response) throws IOException, ParseException {			
		com.alibaba.fastjson.JSONArray json = seekHelpService.GetSeekHelpListAdmin();
		model.addAttribute("seekHelps",json.get(0));
	}
	
	
	@RequestMapping(value="/GetChatMessage",method=RequestMethod.POST)
	public void GetChatMessage(Model model,int id,HttpServletResponse response) throws IOException, ParseException {			
		String result = seekHelpService.getChatMessage(id);
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/GetRecentChatMessage",method=RequestMethod.POST)
	public void getRecentChatMessage(Model model,int id,int start,HttpServletResponse response) throws IOException, ParseException {			
		String result = seekHelpService.getRecentChatMessage(id,start);
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/GetHelpPic",method=RequestMethod.POST)
	public void GetHelpPic(Model model,int id,HttpServletResponse response) throws IOException, ParseException {			
		String result = seekHelpService.GetHelpPic(id);
		response.getWriter().print(result);
	}
}
