package com.kh.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.Reply;
import com.kh.member.model.vo.Member;
import com.kh.post.model.service.PostService;

/**
 * Servlet implementation class AjaxReplyInsertContoller
 */
@WebServlet("/reinsert.po")
public class AjaxReplyInsertContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String replyContent = request.getParameter("content");
		int PostNo = Integer.parseInt(request.getParameter("pno"));
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		System.out.println(PostNo);
		System.out.println(replyContent);
		Reply r = new Reply();
		r.setReplyContent(replyContent);
		r.setPostNo(PostNo);
		r.setMemberNo(String.valueOf(userNo));
		// int -> String : String.valueOf(int)

		// 서비스 요청 후 결과 받기
		int result = new PostService().insertReply(r);
		
		// System.out.println("댓글서비스결과" + result);

		response.setContentType("text/html; charset=UTF-8");

		response.getWriter().print(result); // 1 or 0
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
