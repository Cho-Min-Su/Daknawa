package com.kh.report.model.vo;

public class Report {

        private int reportNo;
        private String reportCategory;
        private String reportContent;
        private int reportType;
        private String reportAnswer;
        private int memberNo;
        private int reMemberNo;
        private int postNo;
        private int replyNo;

        public Report() {}

        public Report(int reportNo, String reportCategory, String reportContent, int reportType, String reportAnswer,
                        int memberNo, int reMemberNo, int postNo, int replyNo) {
                super();
                this.reportNo = reportNo;
                this.reportCategory = reportCategory;
                this.reportContent = reportContent;
                this.reportType = reportType;
                this.reportAnswer = reportAnswer;
                this.memberNo = memberNo;
                this.reMemberNo = reMemberNo;
                this.postNo = postNo;
                this.replyNo = replyNo;
        }

        public int getReportNo() {
                return reportNo;
        }

        public void setReportNo(int reportNo) {
                this.reportNo = reportNo;
        }

        public String getReportCategory() {
                return reportCategory;
        }

        public void setReportCategory(String reportCategory) {
                this.reportCategory = reportCategory;
        }

        public String getReportContent() {
                return reportContent;
        }

        public void setReportContent(String reportContent) {
                this.reportContent = reportContent;
        }

        public int getReportType() {
                return reportType;
        }

        public void setReportType(int reportType) {
                this.reportType = reportType;
        }

        public String getReportAnswer() {
                return reportAnswer;
        }

        public void setReportAnswer(String reportAnswer) {
                this.reportAnswer = reportAnswer;
        }

        public int getMemberNo() {
                return memberNo;
        }

        public void setMemberNo(int memberNo) {
                this.memberNo = memberNo;
        }

        public int getReMemberNo() {
                return reMemberNo;
        }

        public void setReMemberNo(int reMemberNo) {
                this.reMemberNo = reMemberNo;
        }

        public int getPostNo() {
                return postNo;
        }

        public void setPostNo(int postNo) {
                this.postNo = postNo;
        }

        public int getReplyNo() {
                return replyNo;
        }

        public void setReplyNo(int replyNo) {
                this.replyNo = replyNo;
        }

        @Override
        public String toString() {
                return "Report [reportNo=" + reportNo + ", reportCategory=" + reportCategory + ", reportContent="
                                + reportContent + ", reportType="   + reportType + ", reportAnswer=" + reportAnswer
                                + ", memberNo=" + memberNo + ", reMemberNo=" + reMemberNo + ", postNo=" + postNo
                                + ", replyNo=" + replyNo + "]";
        }
}
