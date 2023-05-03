package com.kh.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.Attachment;
import com.kh.post.model.service.PostService;
import com.kh.post.model.vo.Post;

/**
 * Servlet implementation class ReviewPostUpdateFormController
 */
@WebServlet("/updateForm.po")
public class ReviewPostUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPostUpdateFormController() {

       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int postNo = Integer.parseInt(request.getParameter("pno"));
			
			// 카테고리 리스트, 게시글 상세조회, 첨부파일 1건 조회 요청을 보내고 결과 받기 
			
			PostService pService = new PostService();
			
			Post p = pService.selectPost(postNo); // 글번호, 카테고리명, 제목, 내용, 작성자아이디, 작성일
			Attachment at = pService.selectAttachment(postNo); // 첨부파일번호, 원본명, 수정명, 저장경로 | null
			
			request.setAttribute("p", p);
			request.setAttribute("at", at);
			
			request.getRequestDispatcher("views/post/reviewPostUpdateFrom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
