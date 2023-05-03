package com.kh.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.SubNav;

/**
 * Servlet implementation class FaqListController
 */
@WebServlet("/faq.qna")
public class FaqListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SubNav sn = new SubNav();
		
		sn.setTitle1("MY PAGE");
		sn.setTitle1Addr("myInfo.me");
		sn.setTitle2("문의내역");
		sn.setTitle2Addr("list.ask?currentPage=1");
		sn.setTitle3("FAQ");
		sn.setActive1("1");
		sn.setActive2("1");
		sn.setActive3("active");
		
		request.setAttribute("sn", sn);
		
		
		
		
		// faq 화면 포워딩 (하드코딩된 정적인화면을 보여질때도 서블릿 거쳐가기)
		request.getRequestDispatcher("views/qna/faqList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
