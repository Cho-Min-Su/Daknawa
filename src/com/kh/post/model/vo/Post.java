package com.kh.post.model.vo;
import java.sql.Date;
public class Post {
	
	private int postNo;				// 게시글 번호
	private int memberNo;       	// 회원 번호
	private String MemberNickname;	// 맴버 닉네임
	private String postTitle;		// 게시글 제목
	private String postContent;		// 게시글 내용
	private int postView;			// 조회수
	private Date postDate;			// 게시글 등록 날짜
	private String postDel;			// POST_DEL	CHAR(1 BYTE)
	private int postCatNo;			// 카테고리 번호 
	

	
	
	
	public Post() {
		super();
	}

	public Post(int postNo, int memberNo, String memberNickname, String postTitle, String postContent, int postView,
			Date postDate, String postDel, int postCatNo) {
		super();
		this.postNo = postNo;
		this.memberNo = memberNo;
		MemberNickname = memberNickname;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postView = postView;
		this.postDate = postDate;
		this.postDel = postDel;
		this.postCatNo = postCatNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNickname() {
		return MemberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		MemberNickname = memberNickname;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public int getPostView() {
		return postView;
	}

	public void setPostView(int postView) {
		this.postView = postView;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostDel() {
		return postDel;
	}

	public void setPostDel(String postDel) {
		this.postDel = postDel;
	}

	public int getPostCatNo() {
		return postCatNo;
	}

	public void setPostCatNo(int postCatNo) {
		this.postCatNo = postCatNo;
	}

	@Override
	public String toString() {
		return "Post [postNo=" + postNo + ", memberNo=" + memberNo + ", MemberNickname=" + MemberNickname
				+ ", postTitle=" + postTitle + ", postContent=" + postContent + ", postView=" + postView + ", postDate="
				+ postDate + ", postDel=" + postDel + ", postCatNo=" + postCatNo + "]";
	}
	
}
	
	