package com.tour.VO;

import java.sql.Timestamp;

public class MemberVO {
	private String id;
	private String pswd;
	private String name;
	private String birth;
	private int	   gender;
	private String tel;
	private String address;
	private Timestamp regDate;
	
	private static MemberVO memberVO = new MemberVO();
	public static MemberVO getInstance() {
		return memberVO;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pswd=" + pswd + ", name=" + name + ", birth=" + birth + ", gender=" + gender
				+ ", tel=" + tel + ", address=" + address + ", regDate=" + regDate + "]";
	}

		
	
}
