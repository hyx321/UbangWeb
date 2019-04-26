package com.ubang.service.imp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ubang.dao.JobDao;
import com.ubang.dao.SeekHelpDao;
import com.ubang.service.SeekHelpService;
import com.ubang.table.AlarmContent;
import com.ubang.table.Help;
import com.ubang.table.HelpInfoFilter;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.Person;
import com.ubang.table.PersonSeekHelp;
import com.ubang.table.SeekHelpInfo;
import com.ubang.table.User;
import com.ubang.table.picture_url;

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
	public List<Help> helpList(HelpInfoFilter helpInfoFilter) {
		// TODO Auto-generated method stub
		return seekHelpDao.helpList(helpInfoFilter);
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
	public List<HelpInfoUpdate> GetMySeekHelp(PersonSeekHelp personSeekHelp) {
		// TODO Auto-generated method stub
		return seekHelpDao.GetMySeekHelp(personSeekHelp);
	}

	@Override
	public List<SeekHelpInfo> GetSeekHelp(PersonSeekHelp personSeekHelp) {
		// TODO Auto-generated method stub
		return seekHelpDao.GetSeekHelp(personSeekHelp);
	}

}
