package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.SubNav;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/deleteForm.me")
public class MemberDeleteFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("loginUser") != null) { // 정상진입
			
			SubNav sn = new SubNav();
			
			sn.setTitle1("MY PAGE");
			sn.setTitle1Addr("myInfo.me");
			sn.setTitle2("내 정보 관리");
			sn.setTitle2Addr("myInfo.me");
			sn.setTitle3("회원 탈퇴");
			sn.setActive1("active");
			sn.setActive2("1");
			sn.setActive3("1");
			sn.setActive4("1");
			
			request.setAttribute("sn", sn);
			
			request.getRequestDispatcher("views/member/memberDeleteForm.jsp").forward(request, response);
			
		} else { // 로그인하지 않은 상태에서 주소입력으로 마이페이지 진입
				
			request.getSession().setAttribute("alertMsg", "로그인 후 이용 가능한 서비스입니다.");
			
			response.sendRedirect(request.getContextPath() + "/loginPage.me");
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
