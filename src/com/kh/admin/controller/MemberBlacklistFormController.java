package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.SubNav;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberBlacklistFormController
 */
@WebServlet("/blacklist.me")
public class MemberBlacklistFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBlacklistFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(((Member)request.getSession().getAttribute("loginUser")).getUserId().equals("admin")) { // 정상진입
			
			ArrayList<Member> list = new MemberService().selectBlackMemberList();
			
			SubNav sn = new SubNav();
			
			sn.setTitle1("ADMIN PAGE");
			sn.setTitle1Addr("admin.me");
			sn.setTitle2("회원 관리");
			sn.setTitle2Addr("admin.me");
			sn.setTitle3("블랙리스트 목록");
			sn.setActive1("active");
			sn.setActive2("1");
			sn.setActive3("1");
			sn.setActive4("1");
			
			request.setAttribute("sn", sn);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/admin/blacklistView.jsp").forward(request, response);
			
		} else { // 로그인하지 않은 상태에서 주소입력으로 마이페이지 진입
				
			request.getSession().setAttribute("alertMsg", "관리자만 이용 가능한 서비스입니다.");
			
			response.sendRedirect(request.getContextPath());
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
