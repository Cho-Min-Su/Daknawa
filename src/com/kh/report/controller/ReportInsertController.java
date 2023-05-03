package com.kh.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.report.model.service.ReportService;
import com.kh.report.model.vo.Report;

/**
 * Servlet implementation class ReportInsertController
 */
@WebServlet("/insert.re")
public class ReportInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String reportCategory = request.getParameter("reportCategory");
		String reportContent = request.getParameter("reportContent");
		String reportType = request.getParameter("reportType");
		String reportAnswer = request.getParameter("reportAnswer");
		String memberNo = request.getParameter("memberNo");
		String reMemberNo = request.getParameter("reMemberNo");
		String postNo = request.getParameter("postNo");
		String replyNo = request.getParameter("replyNo");

		if(reportAnswer == null) {
			reportAnswer = "";
		}

		if(reMemberNo == null) {
			reMemberNo = "0";
		}

		if(postNo == null) {
			postNo = "0";
		}

		if(replyNo == null) {
			replyNo = "0";
		}

		Report r = new Report();
		r.setReportCategory(reportCategory);
		r.setReportContent(reportContent);
		r.setReportType(Integer.parseInt(reportType));
		r.setReportAnswer(reportAnswer);
		r.setMemberNo(Integer.parseInt(memberNo));
		r.setReMemberNo(Integer.parseInt(reMemberNo));
		r.setPostNo(Integer.parseInt(postNo));
		r.setReplyNo(Integer.parseInt(replyNo));
		
		int result = new ReportService().insertReport(r);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "신고가 접수되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.ad?postNo=" + postNo);
		} else {
			request.setAttribute("errorMsg", "신고 접수에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
