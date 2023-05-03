package com.kh.qna.model.vo;

import java.sql.Date;

public class Qna {
	
	// 필드부
	private int askNo; //	ASK_NO	NUMBER
	private int askType; //	ASK_TYPE	NUMBER
	private String askTitle; //	ASK_TITLE	VARCHAR2(100 BYTE)
	private String askContent;//	ASK_CONTENT	VARCHAR2(1000 BYTE)
	private Date askDate; //	ASK_DATE	DATE
	private String answerContent;//	ANSWER_CONTENT	VARCHAR2(1000 BYTE)
	private Date answerDate; //	ANSWER_DATE	DATE
	private int memberNo; //	MEMBER_NO	NUMBER
	
	// 생성자부
	public Qna() {}

	public Qna(int askNo, int askType, String askTitle, String askContent, Date askDate, String answerContent,
			Date answerDate, int memberNo) {
		super();
		this.askNo = askNo;
		this.askType = askType;
		this.askTitle = askTitle;
		this.askContent = askContent;
		this.askDate = askDate;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.memberNo = memberNo;
	}
	
	// 전체조회용
	public Qna(int askNo, int askType, String askTitle, String askContent, int memberNo, Date askDate, String answerContent, Date answerDate) {
		super();
		this.askNo = askNo;
		this.askType = askType;
		this.askTitle = askTitle;
		this.askContent = askContent;
		this.memberNo = memberNo;
		this.askDate = askDate;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}
	
	
	
	

	// 메소드부
	public int getAskNo() {
		return askNo;
	}


	public void setAskNo(int askNo) {
		this.askNo = askNo;
	}

	public int getAskType() {
		return askType;
	}

	public void setAskType(int askType) {
		this.askType = askType;
	}

	public String getAskTitle() {
		return askTitle;
	}

	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}

	public String getAskContent() {
		return askContent;
	}

	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}

	public Date getAskDate() {
		return askDate;
	}

	public void setAskDate(Date askDate) {
		this.askDate = askDate;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Qna [askNo=" + askNo + ", askType=" + askType + ", askTitle=" + askTitle + ", askContent=" + askContent
				+ ", askDate=" + askDate + ", answerContent=" + answerContent + ", answerDate=" + answerDate
				+ ", memberNo=" + memberNo + "]";
	}
}
