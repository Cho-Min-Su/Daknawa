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
 * Servlet implementation class AdUpdateController
 */
@WebServlet("/adUpdate.ask")
public class AdUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		int askNo = Integer.parseInt(request.getParameter("ano"));
		String answerContent = request.getParameter("answerContent");
		
		Qna q = new Qna();
		q.setAskNo(askNo);
		q.setAnswerContent(answerContent);
		
		int result = new QnaService().updateAnswer(q);
		
		System.out.println(result);
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 답변이 등록됐습니다..");
			response.sendRedirect(request.getContextPath() + "/qna.ad");
		} else {
			
			request.setAttribute("errorMsg", "답변 등록 실패");
			
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
