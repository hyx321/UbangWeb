package com.ubang.util;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ubang.service.SeekHelpService;
import com.ubang.table.ChatMessage;
import com.ubang.table.RoughlyHelpInfo;
import com.ubang.table.User;

@ServerEndpoint(value = "/RemindOthers/{user}")
public class RemindSocket implements Serializable {

    private static final long serialVersionUID = -602733845022657881L;
    private static final Set<RemindSocket> connections = new CopyOnWriteArraySet<>();
    private static final Map<Integer, RemindSocket> remindSockets = new HashMap<>(); 
    
    private static final int Service_Notice = 1012;
    private static final int Service_Online = 1013;
    private static final int Service_OffOnline = 1014;
    private Session session = null;
    private User currentUser = new User();
    private int id = 0;
    
	@Autowired
	private SeekHelpService seekHelpService;

    @OnOpen
    public void onOpen(Session session, @PathParam("user") String user) {
        try {
     
        	System.out.println("用户 "+user+" 加入");
        	for (RemindSocket client : connections) {
        		System.out.println(client.id);
        	}
        	
            id = Integer.parseInt(user);
            if(id != 0) {
	            this.session = session;
	            remindSockets.put(id, this);
	            connections.add(this);
            }
        	
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("onOpen"+e.getMessage());
        }
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
    	System.out.println("接收信息: "+message);
    	try {
    		RoughlyHelpInfo info = JSONObject.parseObject(message, RoughlyHelpInfo.class);
         	RemindOthers(info);
    	}catch (Exception e) {
			ChatMessage chatMessage = JSON.parseObject(message, ChatMessage.class);
			OneChatOne(chatMessage);
		}
     	
    }

   
    private void OneChatOne(ChatMessage chatMessage) {
    	
    	for (Integer key : remindSockets.keySet()) { 
    		  System.out.println("Key = " + key); 
    		} 
    	if(remindSockets.containsKey(chatMessage.getRecieve())) {
    		MoreUtil moreUtil = new MoreUtil();
    		chatMessage.setTime(moreUtil.getTime());
    		remindSockets.get(chatMessage.getRecieve()).session.getAsyncRemote().sendText(chatMessage.toString());
    	}
	}

	private void RemindOthers(RoughlyHelpInfo info) {

    	if(info.getType() == Service_Notice) {
    		if(remindSockets.containsKey(info.getResourse())) {	
	    		remindSockets.get(info.getResourse()).session.getAsyncRemote().sendText(Service_Notice+":"+info.getHelp_id());	    	
    		}
    	}else {
    		if(remindSockets.containsKey(info.getResourse())) {
    			remindSockets.get(info.getHelper()).session.getAsyncRemote().sendText(Service_Online+":"+info.getResourse());
    		}else {
    			remindSockets.get(info.getHelper()).session.getAsyncRemote().sendText(Service_OffOnline+":"+info.getResourse());
    		}	
    	}     
    }
	

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
    	System.out.println("onClose: "+id);
        connections.remove(this);
        remindSockets.remove(id);
    }

    @OnError
    public void onError(Throwable t) {
    	t.printStackTrace();
    	System.out.println("onError: "+id);
        connections.remove(this);
        remindSockets.remove(id);
    }
}