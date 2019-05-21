package com.ubang.service;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.ubang.table.AlarmContent;
import com.ubang.table.ChatMessage;
import com.ubang.table.Help;
import com.ubang.table.HelpDetailInfo;
import com.ubang.table.HelpInfoFilter;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.HelpInfomation;
import com.ubang.table.Person;
import com.ubang.table.PersonSeekHelp;
import com.ubang.table.SeekHelpInfo;
import com.ubang.table.User;

public interface SeekHelpService {
	
	void savePic(MultipartFile[] file);
	
	Boolean postHelp(Help help);
	
	Person getPerson(String phone);
	
	String helpList(HelpInfoFilter helpInfoFilter);

	List<AlarmContent> getAlarmContent(String user_phone);

	String ModifyAlarm(AlarmContent alarmContent);

	String PublishHelp(HelpInfoUpdate help);

	String savePicture(String filePath, int helpId);

	String GetMySeekHelp(PersonSeekHelp personSeekHelp);

	String GetSeekHelp(PersonSeekHelp personSeekHelp);

	JSONArray GetSeekHelpListAdmin();

	void DeleteSeekHelpListAdmin(int id);

	JSONArray GetSeekHelpAdmin(int id);

	JSONArray GetHelpInfoAdmin(int id);

	JSONArray SortHelpListAdmin(String type);

	List<HelpDetailInfo> GetHelpInfo(int id);

	void PostRating(String rating);

	String DeleteHelp(int parseInt);

	String ModifyHelpContent(HelpInfoUpdate help);

	String GetHelp(HelpInfomation help);

	String PostCharMessage(ChatMessage chat);

	String getChatMessage(int id);

	String getRecentChatMessage(int id, int start);

	String GetMyHelp(PersonSeekHelp personSeekHelp);

	String GetHelpPic(int id);

	String saveMultPicture(List<String> filePath, int help_id);

	List<HelpDetailInfo> GetUnHelpInfo(int parseInt);

	String PostCharMessagePic(ChatMessage chat);

	String CancelHelp(int parseInt);

	String FinishHelp(int parseInt);
	
}
