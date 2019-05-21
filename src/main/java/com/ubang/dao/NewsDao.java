package com.ubang.dao;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.ubang.table.CampusSafe;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;

public interface NewsDao {
	
	List<Job> GetAllNewsAdmin(int page);

	List<Job> GetNewsAdmin(int id);
	
	void DeleteNewsAdmin(int id);
	
	List<CampusSafe> GetCampusSafeList(int start);
}
