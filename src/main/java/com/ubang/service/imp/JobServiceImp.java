package com.ubang.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubang.dao.JobDao;
import com.ubang.service.JobService;
import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;

@Service
public class JobServiceImp implements JobService{

	@Autowired
	private JobDao jobDao;
	
	@Override
	public List<String> getCityTag() {
		// TODO Auto-generated method stub
		return jobDao.getCityTag();
	}

	@Override
	public List<String> getSalaryTag() {
		// TODO Auto-generated method stub
		return jobDao.getSalaryTag();
	}

	@Override
	public List<String> getRequireExp() {
		// TODO Auto-generated method stub
		return jobDao.getRequireExp();
	}

	@Override
	public  List<String> getRequireDegree() {
		// TODO Auto-generated method stub
		return jobDao.getRequireDegree();
	}

	@Override
	public List<String> getCompanyNum() {
		// TODO Auto-generated method stub
		return jobDao.getCompanyNum();
	}

	@Override
	public List<String> getCompanyType() {
		// TODO Auto-generated method stub
		return jobDao.getCompanyType();
	}

	@Override
	public List<Job> getJobInfo(JobInfoUpdate jobInfo) {
		// TODO Auto-generated method stub
		return jobDao.getJobInfo(jobInfo);
	}
	
	
}
