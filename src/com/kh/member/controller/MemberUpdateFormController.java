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
 * Servlet implementation class MemberUpdateFormController
 */
@WebServlet("/update.me")
public class MemberUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userNickname = request.getParameter("userNickname");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		Member m = new Member(userId, userNickname, userName, email, phone, birth, gender, address1, address2);
		
		Member updateMem = new MemberService().updateMember(m);
		
		if(updateMem != null) { // 정보변경 성공
			
			request.getSession().setAttribute("loginUser", updateMem);
			
			request.getSession().setAttribute("alertMsg", "회원정보 수정에 성공했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/myInfo.me");
			
		} else { // 정보변경 실패
			
			request.getSession().setAttribute("alertMsg", "회원정보 수정에 실패했습니다. 다시 시도해주세요.");
			
			request.getRequestDispatcher("views/member/myInfo.jsp").forward(request, response);
			
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
