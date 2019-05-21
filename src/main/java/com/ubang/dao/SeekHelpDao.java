package com.ubang.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.ubang.table.AlarmContent;
import com.ubang.table.ChatMessage;
import com.ubang.table.GetHelpBaseInfo;
import com.ubang.table.Help;
import com.ubang.table.HelpBaseInfo;
import com.ubang.table.HelpDetailInfo;
import com.ubang.table.HelpInfoFilter;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.HelpInfomation;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;
import com.ubang.table.Person;
import com.ubang.table.PersonSeekHelp;
import com.ubang.table.SeekHelpInfo;
import com.ubang.table.User;
import com.ubang.table.picture_url;

import net.sf.json.JSONArray;

public interface SeekHelpDao {
	
	//城市标签
	List<String> getCityTag();
	
	//月薪标签
	List<String> getSalaryTag();
	
	//工作经验标签
	List<String> getRequireExp();
	
	//学历标签
	List<String> getRequireDegree();
	
	//公司人数规模标签
	List<String> getCompanyNum();
	
	//公司类型
	List<String> getCompanyType();
	
	//获取招聘信息
//	List<Job> getJobInfo(HashMap<String, List<String>> map);
	List<Job> getJobInfo(JobInfoUpdate jobInfo);
	
	void savePic(MultipartFile file);
	
	Boolean postHelp(Help help);
	
	Person getPerson(String phone);
	
	List<SeekHelpInfo> helpList(HelpInfoFilter helpInfoFilter);
	
	List<AlarmContent> getAlarmContent(String user_phone);

	void ModifyAlarm(AlarmContent alarmContent);
	
	void PublishHelp(HelpInfoUpdate help);
	
	void savePicture(picture_url picture_url);
	
	List<HelpInfoUpdate> GetMySeekHelp(PersonSeekHelp personSeekHelp);
	
	List<SeekHelpInfo> GetSeekHelp(PersonSeekHelp personSeekHelp);
	
	List<HelpBaseInfo> GetSeekHelpListAdmin();
	
	List<HelpBaseInfo> SortHelpListAdmin(String type);
	
	void DeleteSeekHelpListAdmin(int id);
	
	List<GetHelpBaseInfo> GetSeekHelpAdmin(int id);
	
	List<HelpBaseInfo> GetHelpInfoAdmin(int id);
	
	List<HelpDetailInfo> GetHelpInfo(int id);

	void PostRating(HelpDetailInfo helpDetailInfo);
	
	void DeleteHelp(int id);
	
	void ModifyHelpContent(HelpInfoUpdate help);
	
	String JudgeHelpStatus(int id);
	
	void GetHelp(HelpInfomation help);
	
	void ModifiHelpStatus(int id);
	
	void PostCharMessage(ChatMessage chat);
	
	List<ChatMessage> getChatMessage(int id);
	
	List<ChatMessage> getRecentChatMessage(@Param("id")int id, @Param("start")int start);
	
	List<HelpInfoUpdate> GetMyHelp(PersonSeekHelp personSeekHelp);

	List<picture_url> GetHelpPic(int id);
	
	void saveMultPicture(@Param("id")int id, @Param("url")String url);
	
	List<HelpDetailInfo> GetUnHelpInfo(int parseInt);
	
	void PostCharMessagePic(ChatMessage chat);
	
	void CancelHelp(int id);

	void FinishHelp(int id);

	void FinishHelper(@Param("help_id")int help_id,@Param("end_time")String end_time);

	void DeleteHelper(int help_id);
	
}
