package com.kh.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.qna.model.service.QnaService;

/**
 * Servlet implementation class AskDeleteController
 */
@WebServlet("/delete.ask")
public class AskDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int askNo = Integer.parseInt(request.getParameter("ano"));
		
		int result = new QnaService().deleteAsk(askNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 해당 문의가 삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/list.ask?currentPage=1");
			
		} else {
			
			request.setAttribute("errorMsg", "문의 삭제 실패");
			
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
