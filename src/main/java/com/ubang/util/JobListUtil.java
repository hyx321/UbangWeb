package com.ubang.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ubang.table.JobInfo;
import com.ubang.table.JobInfoUpdate;

public class JobListUtil {
	
	public List<String> setDegree(){
		String[] degree = {"中专","大专","本科","硕士","博士"};
		List<String> degreeList = new ArrayList<>();
		for(int i=0;i<degree.length;i++) {
			degreeList.add(degree[i]);
		}
		return degreeList;
	}
	
	public List<String> setExp(){
		String[] exp = {"无工作经验","1年经验","2年经验","3-4年经验","5-7年经验","8-9年经验","10年以上经验"};
		List<String> expList = new ArrayList<>();
		for(int i=0;i<exp.length;i++) {
			expList.add(exp[i]);
		}
		return expList;
	}
	
	public List<String> setNum(){
		String[] peopleNum = {"少于50人","50-150人","150-500人","500-1000人","1000-5000人","5000-10000人","10000人以上"};
		List<String> peopleList = new ArrayList<>();
		for(int i=0;i<peopleNum.length;i++) {
			peopleList.add(peopleNum[i]);
		}
		return peopleList;
	}
	
	
	
}
