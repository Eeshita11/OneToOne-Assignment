package com.one.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userInfo")
public class UserInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userInfoId;
	
	private int mobile;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String nationality;

	public UserInfo(int userInfoId, int mobile, Gender gender, String nationality) {
		super();
		this.userInfoId = userInfoId;
		this.mobile = mobile;
		this.gender = gender;
		this.nationality = nationality;
	}

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
