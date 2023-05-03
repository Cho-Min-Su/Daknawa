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
 * Servlet implementation class EmailConfirmController
 */
@WebServlet("/emailConfirm.me")
public class EmailConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailConfirmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");
		String random = String.valueOf(request.getSession().getAttribute("random"));
		String userId = (String)request.getSession().getAttribute("userId");
		
		if(code.equals(random)) { // 인증 성공
			
			Member m = new Member();
			m.setUserId(userId);
			m.setUserPwd(random);
			
			int result = new MemberService().updatePwd(m);
			
			if(result > 0) { // 임시비밀번호로 변경 성공
				
				request.getSession().setAttribute("alertMsg", "이메일로 발송해드린 인증번호로 임시비밀번호가 설정되었습니다.\\n로그인 후 새로운 비밀번호로 반드시 변경해주세요!");
				
				response.sendRedirect(request.getContextPath());
			} else { // 임시비밀번호로 변경 실패
			
				request.getSession().setAttribute("alertMsg", "알 수 없는 오류가 발생했습니다. 다시 시도해 주세요.");
				
				response.sendRedirect(request.getContextPath() + "/searchPwd.me");
			}
		} else { // 인증 실패
			
			request.getSession().setAttribute("alertMsg", "입력하신 인증번호가 틀렸습니다. 다시 시도해 주세요.");
			
			response.sendRedirect(request.getContextPath() + "/searchPwd.me");
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
