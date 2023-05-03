package com.kh.report.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.report.model.dao.ReportDao;
import com.kh.report.model.vo.Report;


public class ReportService {

	public int insertReport(Report r) {
		
        Connection conn = getConnection();
        
        int result = new ReportDao().insertReport(conn, r);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        
        close(conn);
        
        return result;
	}

	public ArrayList<Report> selectReportList() {
		
        Connection conn = getConnection();
        
        ArrayList<Report> list = new ReportDao().selectReportList(conn);
        
        close(conn);
        
        return list;
	}

	public int updateReport(int reportNo, String reportAnswer) {
		
        Connection conn = getConnection();
        
        int result = new ReportDao().updateReport(conn, reportNo, reportAnswer);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        
        close(conn);
        
        return result;
	}

	public int deleteReport(int reportNo) {
		
        Connection conn = getConnection();
        
        int result = new ReportDao().deleteReport(conn, reportNo);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        
        close(conn);
        
        return result;
	}
	
}
