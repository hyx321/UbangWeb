package com.ubang.service;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.ubang.table.AlarmContent;
import com.ubang.table.Help;
import com.ubang.table.HelpInfoFilter;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.Person;
import com.ubang.table.PersonSeekHelp;
import com.ubang.table.SeekHelpInfo;
import com.ubang.table.User;

public interface SeekHelpService {
	
	void savePic(MultipartFile[] file);
	
	Boolean postHelp(Help help);
	
	Person getPerson(String phone);
	
	List<Help> helpList(HelpInfoFilter helpInfoFilter);

	List<AlarmContent> getAlarmContent(String user_phone);

	String ModifyAlarm(AlarmContent alarmContent);

	String PublishHelp(HelpInfoUpdate help);

	String savePicture(String filePath, int helpId);

	List<HelpInfoUpdate> GetMySeekHelp(PersonSeekHelp personSeekHelp);

	List<SeekHelpInfo> GetSeekHelp(PersonSeekHelp personSeekHelp);
	
}
