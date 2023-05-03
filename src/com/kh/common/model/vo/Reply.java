package com.kh.common.model.vo;

import java.sql.Date;

public class Reply {

    private int replyNo;
    private String replyContent;
    private String createDate;
    private String status;
    private int postNo;
    private String memberNo;

    public Reply() {
    }

    public Reply(int replyNo, String replyContent, String createDate, String status, int postNo, String memberNo) {
        this.replyNo = replyNo;
        this.replyContent = replyContent;
        this.createDate = createDate;
        this.status = status;
        this.postNo = postNo;
        this.memberNo = memberNo;
    }

    public int getReplyNo() {
        return replyNo;
    }

    public void setReplyNo(int replyNo) {
        this.replyNo = replyNo;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", createDate=" + createDate + ", status="
                + status + ", postNo=" + postNo + ", memberNo=" + memberNo + "]";
    }
}
