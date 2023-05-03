package com.kh.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.qna.model.service.QnaService;
import com.kh.qna.model.vo.Qna;

/**
 * Servlet implementation class AskUpdateController
 */
@WebServlet("/update.ask")
public class AskUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int askNo = Integer.parseInt(request.getParameter("ano"));
		String askTitle = request.getParameter("askTitle");
		String askContent = request.getParameter("askContent");
		
		Qna q = new Qna();
		q.setAskNo(askNo);
		q.setAskTitle(askTitle);
		q.setAskContent(askContent);
		
		System.out.println("수정 후 :" + q);
		
		int result = new QnaService().updateAsk(q);

		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 1:1문의가 수정되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.ask?currentPage=1");
		} else {
			
			request.setAttribute("errorMsg", "1:1문의 수정 실패");
			
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
