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
 * Servlet implementation class QnaInsertController
 */
@WebServlet("/insert.qna")
public class QuestionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 인코딩 (POST)
		request.setCharacterEncoding("UTF-8");
		
		// 1. 요청시 전달값뽑기 (반드시 input, select, textarea 태그의 name 속성으로 뽑아야함)
		// => String 변수 = request.getParameter("name속성값");
		int askType = Integer.parseInt(request.getParameter("askType"));
		String askTitle = request.getParameter("askTitle");
		String askContent = request.getParameter("askContent");
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		// 2. VO로 가공하기
		Qna q = new Qna();
		q.setAskType(askType);
		q.setAskTitle(askTitle);
		q.setAskContent(askContent);
		q.setMemberNo(memberNo);
		
		// 3. Service 로 요청 후 결과 받기
		// insert 문 => int (insert 된 행의 갯수)
		int result = new QnaService().insertQuestion(q);
		
		// 4. 결과값을 가지고 응답페이지를 지정
		if(result > 0) { // 성공
			
			request.getSession().setAttribute("alertMsg", "1:1 문의 등록에 성공했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/faq.qna");
			
		} else { // 실패
			
			request.getSession().setAttribute("alertMsg", "1:1 문의 등록에 실패했습니다. 다시 시도해 주세요.");
			
			response.sendRedirect(request.getContextPath() + "/questionForm.qna");
			
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
