package com.example.demo.model;

import java.sql.Date;

public class UserModel {
	private int id;
	private String name;
	private String password;
	private String email;
	private Date created_on;
	private boolean login_yn;
	private String client_ip;
	
	public UserModel(int id, String name, String password, String email, Date created_on, boolean login_yn,
			String client_ip) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.created_on = created_on;
		this.login_yn = login_yn;
		this.client_ip = client_ip;
	}

	public UserModel(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public boolean isLogin_yn() {
		return login_yn;
	}

	public void setLogin_yn(boolean login_yn) {
		this.login_yn = login_yn;
	}

	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", created_on=" + created_on + ", login_yn=" + login_yn + ", client_ip=" + client_ip + "]";
	}
	
}
