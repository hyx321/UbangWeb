package com.ubang.util;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ubang.table.HelpInfoUpdate;
import com.ubang.table.picture_url;

public class backgroud {

	public static void main(String[] args)
	{
		
		picture_url picture_url = new picture_url();
		picture_url.setHelp_id(1);
		picture_url.setPicture("q");
		
		List<picture_url> picture_urls = new ArrayList<>();
		picture_urls.add(picture_url);
		
	
		List<HelpInfoUpdate> help = new ArrayList<>();
		
		HelpInfoUpdate helpInfoUpdate = new HelpInfoUpdate();
		helpInfoUpdate.setAvatar("q");
		helpInfoUpdate.setPisList(picture_urls);
		
		help.add(helpInfoUpdate);
	
		
		//System.out.println(helpInfoUpdate.toString());
		
		JSONObject.toJSON(helpInfoUpdate).toString();
		
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(help));
		
		List<HelpInfoUpdate> list = JSONObject.parseArray(array.toJSONString(), HelpInfoUpdate.class);
		
		System.out.println(list.get(0).getAvatar());
		
		
		
		/*String aString = helpInfoUpdate.toString();
		
		JSONArray jsonArray = JSONArray.parseArray(aString);
		
		String ava = "";
		JSONObject help;
		String picture = "";
		String id = "";
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			ava = (String) jsonObject.get("avatar");
			JSONArray jsonArray1 = JSONArray.parseArray(jsonObject.getString("pisList"));
			for(int j=0;i<jsonArray1.size();j++) {
				help = jsonArray.getJSONObject(j);
				id = help.getString("help");
				picture = help.getString("picture");
			}
		}
		System.out.println(ava+":"+picture+":"+id);*/
	}
 

}
