package com.kh.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.post.model.service.PostService;

/**
 * Servlet implementation class ReviewPostDeleteController
 */
@WebServlet("/delete.po")
public class ReviewPostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPostDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(request.getParameter("pno"));

		// 게시글 번호를 넘기면서 삭제 요청 후 결과 받기
		// (Attachment 테이블은 따로 건들일 필요가 없음!!)
		
		System.out.println("삭제 포스트" + postNo);
		
		int result = new PostService().deletePost(postNo);

		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "게시글이 삭제되었습니다.");
			response.sendRedirect(request.getContextPath() + "/review.bo?currentPage=1");
		} else {
			request.setAttribute("errorMsg", "게시글 삭제에 실패했습니다.");
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
