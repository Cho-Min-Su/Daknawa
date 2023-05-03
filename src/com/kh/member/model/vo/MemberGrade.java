package com.kh.member.model.vo;

public class MemberGrade {

	private String memberCode; //	MEMBER_CODE	CHAR(1 BYTE)
	private String gradeName;  //	GRADE_NAME	VARCHAR2(12 BYTE)
	private int pointMin;	   //	POINT_MIN	NUMBER
	private int pointMax; 	   //	POINT_MAX	NUMBER
	
	public MemberGrade() { }

	public MemberGrade(String memberCode, String gradeName, int pointMin, int pointMax) {
		super();
		this.memberCode = memberCode;
		this.gradeName = gradeName;
		this.pointMin = pointMin;
		this.pointMax = pointMax;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public int getPointMin() {
		return pointMin;
	}

	public void setPointMin(int pointMin) {
		this.pointMin = pointMin;
	}

	public int getPointMax() {
		return pointMax;
	}

	public void setPointMax(int pointMax) {
		this.pointMax = pointMax;
	}

	@Override
	public String toString() {
		return "MemberGrade [memberCode=" + memberCode + ", gradeName=" + gradeName + ", pointMin=" + pointMin
				+ ", pointMax=" + pointMax + "]";
	}
}
