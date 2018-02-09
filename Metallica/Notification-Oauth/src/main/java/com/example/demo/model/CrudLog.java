package com.example.demo.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = CrudLog.class)
public class CrudLog {
	private User content;
	private String routingKey;

	public CrudLog() {
		// TODO Auto-generated constructor stub
	}

	// @Override
	// public String toString() {
	// return "Log [content=" + content + ", routingKey=" + routingKey + "]";
	// }

	// @Override
	// public String toString() {
	// return String.format("{content = %s, routingKey = %s}", content, routingKey);
	// }

	public CrudLog(User content, String routingKey) {
		this.content = content;
		this.routingKey = routingKey;
	}

	public User getContent() {
		return content;
	}

	public void setContent(User content) {
		this.content = content;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public String toString() {
		JSONObject jsonInfo = new JSONObject();

		try {
			jsonInfo.put("content", this.content);
			jsonInfo.put("routingKey", this.routingKey);

		} catch (JSONException e1) {
		}
		return jsonInfo.toString();
	}

}
