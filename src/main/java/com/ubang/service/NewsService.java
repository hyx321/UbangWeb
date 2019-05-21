package com.ubang.service;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.ubang.table.Job;
import com.ubang.table.JobFirst;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;

public interface NewsService {
	
	JSONArray GetAllNewsAdmin(int page);

	JSONArray GetNewsAdmin(int id);

	void DeleteNewsAdmin(int id);

	void UpdateNewsAdmin(JobFirst jobFirst);

	String GetCampusSafeList(int start);

}
