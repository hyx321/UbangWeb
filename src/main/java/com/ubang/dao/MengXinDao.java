package com.ubang.dao;

import java.util.List;

import com.ubang.table.Assistant;
import com.ubang.table.Campus;
import com.ubang.table.Pagination;
import com.ubang.table.SolveAssistant;
import com.ubang.table.Test;

public interface MengXinDao {
	//获取校园景色图片
	List<Campus> getCampusBeauty(Pagination pagination);
	
	List<Test> getTest();
	
	//获取图片的总数
	int getPhotoSum();
	
	//助手问答
	List<Assistant> getAnswer(String question_key);
	
	//获取对应已解决回答
	Assistant getSolveAssistant(SolveAssistant solveAssistant);
	
	//获取所有解决回答
	List<String> getSolveAllAssistant(int id);
}
