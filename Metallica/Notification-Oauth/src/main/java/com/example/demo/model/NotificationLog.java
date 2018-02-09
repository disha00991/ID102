package com.example.demo.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = NotificationLog.class)
public class NotificationLog {
	private String content;
	private String routingKey;
	
	public NotificationLog(){};
	
	public NotificationLog(String content, String routingKey){
		this.content = content;
		this.routingKey = routingKey;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getRoutingKey(){
		return this.routingKey;
	}
	
	public void setRoutingKey(String routingKey){
		this.routingKey = routingKey;
	}

	@Override
	public String toString() {
		return "Log [content=" + content + ", routingKey=" + routingKey + "]";
	}
	
//	@Override
//	public String toString() {
//		return String.format("{content = %s, routingKey = %s}", content, routingKey);
//	}
	
//	public String toString(){
//		JSONObject jsonInfo = new JSONObject();
//		
//		try {
//			jsonInfo.put("content", this.content);
//			jsonInfo.put("routingKey", this.routingKey);
//			
//		} catch (JSONException e1) {}
//		return jsonInfo.toString();
//	}
	
	
	
}
