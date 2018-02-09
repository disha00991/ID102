package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Trader")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = User.class)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Role> roles;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(User user) {
		this.userName = user.userName;
		this.password = user.password;
		this.roles = user.roles;
	}

	

	public User(String userName, String password, List<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Trader [id=" + id + ", userName=" + userName + ", password=" + password + ", roles=" + roles + "]";
//	}
	
	public String toString(){
		JSONObject jsonInfo = new JSONObject();
		
		try {
			jsonInfo.put("id", this.id);
			jsonInfo.put("userName", this.userName);
			jsonInfo.put("password", this.password);
 
			JSONArray productArray = new JSONArray();
			if (this.roles != null) {
				this.roles.forEach(product -> {
					JSONObject subJson = new JSONObject();
					try {
						subJson.put("role", product.getRole());
					} catch (JSONException e) {}
					
					productArray.put(subJson);
				});
			}
			jsonInfo.put("roles", productArray);
		} catch (JSONException e1) {}
		return jsonInfo.toString();
	}
	
	
	
}
