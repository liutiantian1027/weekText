package com.liutiantian.beans;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	//定义id
	private int id;
	//定义name
	private String name;
	//定义性别
	private String gender;
	//定义手机号
	private String phoneNum;
	//定义邮箱
	private String email;
	//定义生日
	private String birthday;
	//构造方法
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	//tostring方法
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", phoneNum=" + phoneNum + ", email="
				+ email + ", birthday=" + birthday + "]";
	}
	//有参
	public User(int id, String name, String gender, String phoneNum, String email, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.email = email;
		this.birthday = birthday;
	}
	//无参
	public User() {
		
	}
	
}
