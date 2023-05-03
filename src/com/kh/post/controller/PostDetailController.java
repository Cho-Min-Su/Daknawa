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
 * Servlet implementation class PostDetailController
 */
@WebServlet("/pDetail.bo")
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(request.getParameter("pno"));

		int category = 2;

		System.out.println("postNo : " + postNo);


		
		PostService pService = new PostService();
		
		int result = pService.increaseCount(postNo);
		
		if(result > 0) {
			
			Post p = pService.selectPost(postNo, category);
			System.out.println(p);
			
			Attachment at = pService.selectAttachment(postNo);
			
			request.setAttribute("p", p);
			// System.out.println(p);
			request.setAttribute("at", at);
			// System.out.println(at);
			request.getRequestDispatcher("views/post/postDetail.jsp").forward(request, response);
			
		} else {
			
			request.setAttribute("errorPage", "자유게시판 상세조회 실패");
			
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
