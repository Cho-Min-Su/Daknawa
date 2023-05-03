package com.kh.member.model.vo;

public class Member {

	private int userNo; 	  	   //	user_NO	NUMBER
	private String userId;  	   //	user_ID	VARCHAR2(12 BYTE)
	private String userPwd; 	   //	user_PWD	VARCHAR2(15 BYTE)
	private String userNickName; //	user_NICKNAME	VARCHAR2(30 BYTE)
	private String userName; 	   //	user_NAME	VARCHAR2(15 BYTE)
	private String email; 		   //	EMAIL	VARCHAR2(30 BYTE)
	private String phone;			   //	PHONE	VARCHAR2(11 BYTE)
	private String birth;		   //	BIRTH	DATE
	private String gender;		   //	GENDER	CHAR(3 BYTE)
	private String address1;		   //	ADDRESS1	VARCHAR2(150 BYTE)
	private String address2;			// ADDRESS2 VARCHAR2(300 BYTE)
	private String blackList;	   //	BLACKLIST	CHAR(1 BYTE)
	private int userPoint;	   //	user_POINT	NUMBER
	private String gradeName;  //  + 회원등급 이름 (준회원, 정회원, ..)
	private String status;		   //	STATUS	CHAR(1 BYTE)
	
	public Member() { }

	public Member(int userNo, String userId, String userPwd, String userNickName, String userName,
			String email, String phone, String birth, String gender, String address1, String address2, String blackList, int userPoint,
			String gradeName, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNickName = userNickName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.address1 = address1;
		this.address2 = address2;
		this.blackList = blackList;
		this.userPoint = userPoint;
		this.gradeName = gradeName;
		this.status = status;
	}
	
	public Member(int userNo, String userId, String userPwd, String userNickName, String userName, String email,
			String phone, String birth, String gender, String address1, String address2, String blackList, int userPoint, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNickName = userNickName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.address1 = address1;
		this.address2 = address2;
		this.blackList = blackList;
		this.userPoint = userPoint;
		this.status = status;
	}

	public Member(String userId, String userPwd, String userNickName, String userName, String email, String phone,
			String birth, String gender, String address1, String address2) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNickName = userNickName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.address1 = address1;
		this.address2 = address2;
	}

	public Member(String userId, String userNickName, String userName, String email, String phone, String birth,
			String gender, String address1, String address2) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.address1 = address1;
		this.address2 = address2;
	}

	

	public Member(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getBlackList() {
		return blackList;
	}

	public void setBlackList(String blackList) {
		this.blackList = blackList;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setuserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	
	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userNickName="
				+ userNickName + ", userName=" + userName + ", email=" + email + ", phone=" + phone + ", birth=" + birth
				+ ", gender=" + gender + ", address1=" + address1 + ", address2=" + address2 + ", blackList=" + blackList + ", userPoint="
				+ userPoint + ", gradeName=" + gradeName + ", status=" + status + "]";
	}

}
