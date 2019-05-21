package com.ubang.service.imp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.ubang.dao.JobDao;
import com.ubang.dao.SeekHelpDao;
import com.ubang.service.SeekHelpService;
import com.ubang.table.Administor;
import com.ubang.table.AlarmContent;
import com.ubang.table.ChatMessage;
import com.ubang.table.GetHelpBaseInfo;
import com.ubang.table.Help;
import com.ubang.table.HelpBaseInfo;
import com.ubang.table.HelpDetailInfo;
import com.ubang.table.HelpInfoFilter;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.HelpInfomation;
import com.ubang.table.Person;
import com.ubang.table.PersonSeekHelp;
import com.ubang.table.SeekHelpInfo;
import com.ubang.table.User;
import com.ubang.table.picture_url;
import com.ubang.util.GeneratFileName;
import com.ubang.util.MoreUtil;

import ch.qos.logback.classic.pattern.Util;

@Service
public class SeekHelpServiceImp implements SeekHelpService{

	@Autowired
	private SeekHelpDao seekHelpDao;
	
	@Override
	public void savePic(MultipartFile[] files) {
		JSONArray fileNames = new JSONArray();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String folderPath = "D:\\";
		try {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getOriginalFilename();
				fileName = "MicroChat_"+ fileName;
				InputStream input = files[i].getInputStream();
				File folder = new File(folderPath);
			
				OutputStream outputStream = new FileOutputStream(
						folderPath + File.separator + fileName);
				byte[] b = new byte[1024];
				while ((input.read(b)) != -1) {
					outputStream.write(b);
				}
				input.close();
				outputStream.close();
				fileNames.add(fileName);
			}
			returnMap.put("code", "200");
			returnMap.put("msg", "success");
			returnMap.put("fileNames", fileNames);

		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("code", "414");
			returnMap.put("msg", "error");
		
		}
		
	}

	@Override
	public Boolean postHelp(Help help) {
		// TODO Auto-generated method stub
		return seekHelpDao.postHelp(help);
	}

	@Override
	public Person getPerson(String phone) {
		// TODO Auto-generated method stub
		return seekHelpDao.getPerson(phone);
	}

	@Override
	public String helpList(HelpInfoFilter helpInfoFilter) {
		// TODO Auto-generated method stub
		List<SeekHelpInfo> helpList = seekHelpDao.helpList(helpInfoFilter);
		for(int i=0;i<helpList.size();i++) {
			if(helpList.get(i).getHas_picture() == 1) {
				helpList.get(i).setPisList(seekHelpDao.GetHelpPic(helpList.get(i).getId()));
			}
		}
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(helpList));
		return array.toJSONString();
		
	}

	@Override
	public List<AlarmContent> getAlarmContent(String user_phone) {
		// TODO Auto-generated method stub
		return seekHelpDao.getAlarmContent(user_phone);
	}

	@Override
	public String ModifyAlarm(AlarmContent alarmContent) {
		// TODO Auto-generated method stub
		try{
			seekHelpDao.ModifyAlarm(alarmContent);
			return "1";
		}catch (Exception e) {
			// TODO: handle exception
			return e.getMessage().toString();
		}
	}

	public String PublishHelp(HelpInfoUpdate help) {
		// TODO Auto-generated method stub
		try {
			seekHelpDao.PublishHelp(help);
			return "1";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
			return e.getMessage().toString();
		}
		
	}

	public String savePicture(String filePath, int helpId) {
		// TODO Auto-generated method stub
		try {
				picture_url picture_url = new picture_url();
				picture_url.setHelp_id(helpId);
				picture_url.setPicture(filePath);
				seekHelpDao.savePicture(picture_url);
				return "1";
			} catch (Exception e) {
				return e.getMessage();
			}
	}

	@Override
	public String GetMySeekHelp(PersonSeekHelp personSeekHelp) {
		List<HelpInfoUpdate> helpInfoUpdates = seekHelpDao.GetMySeekHelp(personSeekHelp);
		for(int i=0;i<helpInfoUpdates.size();i++) {
			if(helpInfoUpdates.get(i).getHas_picture() == 1) {
				helpInfoUpdates.get(i).setPisList(seekHelpDao.GetHelpPic(helpInfoUpdates.get(i).getId()));
			}
		}
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(helpInfoUpdates));
		return array.toJSONString();
	}

	@Override
	public String GetSeekHelp(PersonSeekHelp personSeekHelp) {
		
		List<SeekHelpInfo> seekHelpInfos = seekHelpDao.GetSeekHelp(personSeekHelp);
		for(int i=0;i<seekHelpInfos.size();i++) {
			if(seekHelpInfos.get(i).getHas_picture() == 1) {
				seekHelpInfos.get(i).setPisList(seekHelpDao.GetHelpPic(seekHelpInfos.get(i).getId()));
			}
		}
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(seekHelpInfos));
		return array.toJSONString();
	}

	@Override
	public JSONArray GetSeekHelpListAdmin() {
		// TODO Auto-generated method stub
		List<HelpBaseInfo> helpBaseInfos = seekHelpDao.GetSeekHelpListAdmin();
		JSONArray json = JSON.parseArray(helpBaseInfos.toString());
	
		return json;

	}

	@Override
	public void DeleteSeekHelpListAdmin(int id) {
		// TODO Auto-generated method stub
		seekHelpDao.DeleteSeekHelpListAdmin(id);
	}

	@Override
	public JSONArray GetSeekHelpAdmin(int id) {
		// TODO Auto-generated method stub
		List<GetHelpBaseInfo> getHelpBaseInfos = seekHelpDao.GetSeekHelpAdmin(id);
		JSONArray json = JSON.parseArray(getHelpBaseInfos.toString());
		return json;
	}

	@Override
	public JSONArray GetHelpInfoAdmin(int id) {
		// TODO Auto-generated method stub
		List<HelpBaseInfo> helpBaseInfos = seekHelpDao.GetHelpInfoAdmin(id);
		JSONArray json = JSON.parseArray(helpBaseInfos.toString());
		return json;
	}

	public JSONArray SortHelpListAdmin(String type) {
		// TODO Auto-generated method stub
		List<HelpBaseInfo> getHelpBaseInfos = seekHelpDao.SortHelpListAdmin(type);
		JSONArray json = JSON.parseArray(getHelpBaseInfos.toString()); 
		return json;
	}

	@Override
	public List<HelpDetailInfo> GetHelpInfo(int id) {
		// TODO Auto-generated method stub
		List<HelpDetailInfo> helpDetailInfos = seekHelpDao.GetHelpInfo(id);
		System.out.println(helpDetailInfos.get(0));
		return helpDetailInfos;
	}

	@Override
	public List<HelpDetailInfo> GetUnHelpInfo(int id) {
		// TODO Auto-generated method stub
		List<HelpDetailInfo> helpDetailInfos = seekHelpDao.GetUnHelpInfo(id);
		System.out.println(helpDetailInfos.get(0));
		return helpDetailInfos;
	}
	
	@Override
	public void PostRating(String rating) {
		HelpDetailInfo helpDetailInfo = JSON.parseObject(rating,HelpDetailInfo.class);
		seekHelpDao.PostRating(helpDetailInfo);
	}

	@Override
	public String DeleteHelp(int id) {
		if(seekHelpDao.GetHelpInfo(id).size()>0) {
			return "已经有人接收求助";
		}else {
			seekHelpDao.DeleteHelp(id);
			return "1";
		}
	}

	@Override
	public String ModifyHelpContent(HelpInfoUpdate help) {
		
		if("未开始".equals(seekHelpDao.JudgeHelpStatus(help.getId()))) {
			seekHelpDao.ModifyHelpContent(help);
			return "1";
		}else {
			return "已经有人接收求助";
		}

	}

	@Override
	public String GetHelp(HelpInfomation help) {
		
		MoreUtil util = new MoreUtil();
        help.setCreate_time(util.getTime());
        try {
        	String aString = seekHelpDao.JudgeHelpStatus(help.getHelp_id());
	        if(aString.equals("未开始")) {
	        	seekHelpDao.ModifiHelpStatus(help.getHelp_id());
	    		seekHelpDao.GetHelp(help);
	    		return "1";
	        }else {
	        	return "0";
	        }
        }catch (Exception e) {
			// TODO: handle exception
        	return "0";
		}
	        
	
	}

	@Override
	public String PostCharMessage(ChatMessage chat) {
		
		MoreUtil util = new MoreUtil();
		chat.setTime(util.getTime());
		
		seekHelpDao.PostCharMessage(chat);
		List<ChatMessage> chatMessages = seekHelpDao.getChatMessage(chat.getMessage_id());
		return chatMessages.get(0).toString();
	}

	@Override
	public String PostCharMessagePic(ChatMessage chat) {
		MoreUtil util = new MoreUtil();
		chat.setTime(util.getTime());
		seekHelpDao.PostCharMessagePic(chat);
		List<ChatMessage> chatMessages = seekHelpDao.getChatMessage(chat.getMessage_id());
		return chatMessages.get(0).toString();
	}
	
	@Override
	public String getChatMessage(int id) {
		// TODO Auto-generated method stub
		List<ChatMessage> chatMessages = seekHelpDao.getChatMessage(id);
		return chatMessages.get(0).toString();
	}

	@Override
	public String getRecentChatMessage(int id, int start) {
		List<ChatMessage> chatMessages = seekHelpDao.getRecentChatMessage(id,start);
		return chatMessages.toString();
	}

	@Override
	public String GetMyHelp(PersonSeekHelp personSeekHelp) {
		// TODO Auto-generated method stub
		List<HelpInfoUpdate> helpInfoUpdates = seekHelpDao.GetMyHelp(personSeekHelp);
		for(int i=0;i<helpInfoUpdates.size();i++) {
			if(helpInfoUpdates.get(i).getHas_picture() == 1) {
				helpInfoUpdates.get(i).setPisList(seekHelpDao.GetHelpPic(helpInfoUpdates.get(i).getId()));
			}
		}
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(helpInfoUpdates));
		return array.toJSONString();
	}
	

	public String GetHelpPic(int id) {
		// TODO Auto-generated method stub
		List<picture_url> picture_urls = seekHelpDao.GetHelpPic(id);
		return picture_urls.toString();
	}

	@Override
	public String saveMultPicture(List<String> filePath,int help_id) {
		try {
			for(int i=0;i<filePath.size();i++) {
				seekHelpDao.saveMultPicture(help_id,filePath.get(i));
			}
			return "1";
		}catch (Exception e) {
			return "0";
		}
	}

	@Override
	public String CancelHelp(int parseInt) {
		if(seekHelpDao.JudgeHelpStatus(parseInt).equals("进行中")) {
			seekHelpDao.CancelHelp(parseInt);
			seekHelpDao.DeleteHelper(parseInt);
			return "1";
		}else {
			return "0";
		}
	}

	@Override
	public String FinishHelp(int parseInt) {
		if(seekHelpDao.JudgeHelpStatus(parseInt).equals("进行中")) {
			seekHelpDao.FinishHelp(parseInt);
			MoreUtil moreUtil = new MoreUtil();
			seekHelpDao.FinishHelper(parseInt,moreUtil.getTime());
			return "1";
		}else {
			return "0";
		}	
	
	}
	

}
