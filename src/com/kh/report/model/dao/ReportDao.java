package com.kh.report.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.post.model.dao.PostDao;
import com.kh.report.model.vo.Report;

public class ReportDao {

   private Properties prop = new Properties();
	
	public ReportDao() {
		String fileName = PostDao.class.getResource("/sql/report/report-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertReport(Connection conn, Report r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Report> selectReportList(Connection conn) {
		
		ArrayList<Report> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Report re = new Report();

				re.setReportNo(rset.getInt("REPORT_NO"));
				re.setReportCategory(rset.getString("REPORT_CATEGORY"));
				re.setReportContent(rset.getString("REPORT_CONTENT"));
				re.setReportType(rset.getInt("REPORT_TYPE"));
				re.setReportAnswer(rset.getString("REPORT_ANSWER"));
				re.setMemberNo(rset.getInt("MEMBER_NO"));
				re.setReMemberNo(rset.getInt("RE_MEMBER_NO"));
				re.setPostNo(rset.getInt("POST_NO"));
				re.setReplyNo(rset.getInt("REPLY_NO"));
				
				list.add(re);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int updateReport(Connection conn, int reportNo, String reportAnswer) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reportAnswer);
			pstmt.setInt(2, reportNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteReport(Connection conn, int reportNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reportNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}



	
	
}
