package com.ubang.util;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ubang.table.User;

@ServerEndpoint(value = "/1111RemindOthers/{user}")
public class ChatSocket implements Serializable {

    private static final long serialVersionUID = -602733845022657881L;

    private static final String SYSTEM_MSG_TYPE = "SYS";
    private static final String P2P_MSG_TYPE = "P2P";
    private static final String P2M_MSG_TYPE = "P2M";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final Set<ChatSocket> connections = new CopyOnWriteArraySet<>();
    private Session session = null;
    private User currentUser = null;
    private int id = 0;


    @OnOpen
    public void onOpen(Session session, @PathParam("user") String user) {
        try {
           // logger.info("请求参数{}", user);
        	user = "{"+ user +"}";
            this.session = session;
            connections.add(this);
            currentUser = new User();
            currentUser = JSON.parseObject(user,User.class);
            //id = Integer.parseInt(user);
//            JSONObject msg = new JSONObject();
//            msg.put("uID", currentUser.getId());
//            msg.put("nickname", currentUser.getNickname());
//            msg.put("extra", "当前在线人数(" + connections.size() + ")");
//
//            JSONObject json = new JSONObject();
//            json.put("msgType", SYSTEM_MSG_TYPE);
//            json.put("from", "SYSTEM");
//            json.put("time", dateFormat.format(new Date()));
//            json.put("msg", msg);
            //systemBroadcast("nihao ", SYSTEM_MSG_TYPE);
        } catch (NullPointerException e) {
            //logger.error("", e.getMessage());
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        //logger.info("请求参数{}", currentUser);
//        JSONObject msg = new JSONObject();
//        msg.put("uID", currentUser.getId());
//        msg.put("nickname", currentUser.getNickname());
//        msg.put("extra", currentUser.getNickname() + "下线");
//
//        JSONObject json = new JSONObject();
//        json.put("msgType", SYSTEM_MSG_TYPE);
//        json.put("from", "SYSTEM");
//        json.put("time", dateFormat.format(new Date()));
//        json.put("msg", msg);
//        systemBroadcast(json.toJSONString(), SYSTEM_MSG_TYPE);
//
//        BaseObservable observable = BaseObservable.getBaseObservable();
//        observable.notifyObservers(this.currentUser.getId());
        connections.remove(this);
    }

    @OnError
    public void onError(Throwable t) {
    	  String tString = t.getMessage();
    	  t.printStackTrace();
//        JSONObject msg = new JSONObject();
//        msg.put("uID", currentUser.getId());
//        msg.put("nickname", currentUser.getNickname());
//        msg.put("extra", currentUser.getNickname() + "下线");
//
//        JSONObject json = new JSONObject();
//        json.put("msgType", SYSTEM_MSG_TYPE);
//        json.put("from", "SYSTEM");
//        json.put("time", dateFormat.format(new Date()));
//        json.put("msg", msg);
//        systemBroadcast(json.toJSONString(), SYSTEM_MSG_TYPE);
//
//        BaseObservable observable = BaseObservable.getBaseObservable();
//        observable.notifyObservers(this.currentUser.getId());

        connections.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
//        JSONObject msg = JSONObject.parseObject(message);
//        JSONObject to = msg.getJSONObject("to");
//
//        JSONObject data = new JSONObject();
//        data.put("msg", msg.getString("msg"));
//        data.put("from", msg.getJSONObject("from"));
//        data.put("time", dateFormat.format(new Date()));

        try {
            //data.put("msgType", P2P_MSG_TYPE);
            broadcastOneToOne(message,currentUser.getId());
        } catch (Exception e) {
           // data.put("msgType", P2M_MSG_TYPE);
        	String eString = e.getMessage();
        	e.printStackTrace();
            systemBroadcast(message, P2M_MSG_TYPE);
        }
    }

    private void systemBroadcast(String msg, String msgType) {
        if (SYSTEM_MSG_TYPE.equals(msgType)) {
            for (ChatSocket client : connections) {
                try {
                    client.session.getAsyncRemote().sendText(msg);
                } catch (Exception e) {
                    connections.remove(client);
                }
            }
            return;
        }
        if (P2M_MSG_TYPE.equals(msgType)) {
            for (ChatSocket client : connections) {
                if (client.currentUser.getId() != this.currentUser.getId()) {
                    try {
                        client.session.getAsyncRemote().sendText(msg);
                    } catch (Exception e) {
                        connections.remove(client);
                    
                    }
                }
            }
        }
    }

    private void broadcastOneToOne(String msg, int target) {
        for (ChatSocket client : connections) {
            if (client.currentUser.getId()== target) {
                try {
                    client.session.getAsyncRemote().sendText("你好");
                } catch (Exception e) {
                    connections.remove(client);
                    //logger.debug("", e.getMessage());
                }
                break;
            }
        }
    }
}