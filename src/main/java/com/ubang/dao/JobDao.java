package com.ubang.dao;

import java.util.HashMap;
import java.util.List;

import com.ubang.table.Job;
import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;

public interface JobDao {
	
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
}
