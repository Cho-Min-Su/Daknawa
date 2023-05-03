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
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String newPwd = request.getParameter("newPwd");
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(newPwd);

		
		int result = new MemberService().updatePwd(m);
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "비밀번호 변경에 성공하였습니다. 다시 로그인 해 주세요.");
			
			request.getSession().removeAttribute("loginUser");
			
			response.sendRedirect(request.getContextPath());
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "비밀번호 변경에 실패하였습니다. 다시 시도 해 주세요.");
			
			request.getRequestDispatcher("views/member/updatePwdForm.jsp").forward(request, response);
			
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
