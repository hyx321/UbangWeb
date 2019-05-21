package com.ubang.service.imp;

import java.util.HashMap;
import java.util.List;

import org.junit.internal.runners.ErrorReportingRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ubang.dao.JobDao;
import com.ubang.dao.NewsDao;
import com.ubang.service.JobService;
import com.ubang.service.NewsService;
import com.ubang.table.CampusSafe;
import com.ubang.table.Job;
import com.ubang.table.JobFirst;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;

@Service
public class NewsServiceImp implements NewsService{

	@Autowired
	private NewsDao newsDao;

	@Override
	public JSONArray GetAllNewsAdmin(int page) {
		// TODO Auto-generated method stub
		try {
			List<Job> jons = newsDao.GetAllNewsAdmin(page);
			JSONArray json= JSONArray.parseArray(JSON.toJSONString(jons));
			return json;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public JSONArray GetNewsAdmin(int id) {
		// TODO Auto-generated method stub
		List<Job> jobs = newsDao.GetNewsAdmin(id);
		JSONArray json = JSON.parseArray(jobs.toString());
		return json;
	}

	@Override
	public void DeleteNewsAdmin(int id) {
		// TODO Auto-generated method stub
		newsDao.DeleteNewsAdmin(id);
	}

	@Override
	public void UpdateNewsAdmin(JobFirst jobFirst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String GetCampusSafeList(int start) {
	
		List<CampusSafe> campusSafes = newsDao.GetCampusSafeList(start);
	
		return campusSafes.toString();
	}

}
