package com.ubang.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubang.dao.MengXinDao;
import com.ubang.service.MengXinService;
import com.ubang.table.Assistant;
import com.ubang.table.Campus;
import com.ubang.table.Pagination;
import com.ubang.table.SolveAssistant;
import com.ubang.table.Test;

@Service
public class MengXinServiceImp implements MengXinService{
	
	@Autowired
	private MengXinDao mengXinDao;

	//获取校园景色图片
	@Override
	public List<Campus> getCampusBeauty(Pagination pagination) {
		// TODO Auto-generated method stub
		return mengXinDao.getCampusBeauty(pagination);
	}
	
	@Override
	public List<Test> getTest() {
		// TODO Auto-generated method stub
		return mengXinDao.getTest();
	}

	//获取图片的总数
	@Override
	public int getPhotoSum() {
		// TODO Auto-generated method stub
		return mengXinDao.getPhotoSum();
	}

	//获取助手的回答
	@Override
	public List<Assistant> getAnswer(String question_key) {
		// TODO Auto-generated method stub
		return mengXinDao.getAnswer(question_key);
	}

	@Override
	public Assistant getSolveAssistant(SolveAssistant solveAssistant) {
		// TODO Auto-generated method stub
		return mengXinDao.getSolveAssistant(solveAssistant);
	}

	@Override
	public List<String> getSolveAllAssistant(int id) {
		// TODO Auto-generated method stub
		return mengXinDao.getSolveAllAssistant(id);
	}

	
}
