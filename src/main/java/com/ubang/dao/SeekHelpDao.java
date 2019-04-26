package com.ubang.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.ubang.table.AlarmContent;
import com.ubang.table.Help;
import com.ubang.table.HelpInfoFilter;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;
import com.ubang.table.Person;
import com.ubang.table.PersonSeekHelp;
import com.ubang.table.SeekHelpInfo;
import com.ubang.table.User;
import com.ubang.table.picture_url;

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
	
	List<Help> helpList(HelpInfoFilter helpInfoFilter);
	
	List<AlarmContent> getAlarmContent(String user_phone);

	void ModifyAlarm(AlarmContent alarmContent);
	
	void PublishHelp(HelpInfoUpdate help);
	
	void savePicture(picture_url picture_url);
	
	List<HelpInfoUpdate> GetMySeekHelp(PersonSeekHelp personSeekHelp);
	
	List<SeekHelpInfo> GetSeekHelp(PersonSeekHelp personSeekHelp);
}
