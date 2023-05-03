package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userNickname = request.getParameter("userNickname");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		Member m = new Member(userId, userPwd, userNickname, userName, email, phone, birth, gender, address1, address2);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) { // 회원가입 성공
			
			request.getSession().setAttribute("alertMsg", "회원 가입에 성공했습니다. 당신의 치킨 지식을 뽐내주세요!");
			
			response.sendRedirect(request.getContextPath());
			
		} else { // 회원가입 실패
			
			request.getSession().setAttribute("alertMsg", "회원 가입에 실패했습니다. 다시 시도해주세요.");
			
			request.getRequestDispatcher("views/member/memberEnrollForm.jsp").forward(request, response);
			
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
