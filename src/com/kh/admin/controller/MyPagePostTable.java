package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminService;
import com.kh.common.model.vo.SubNav;
import com.kh.member.model.vo.Member;
import com.kh.post.model.vo.Post;

/**
 * Servlet implementation class MyPagePostTable
 */
@WebServlet("/postlist.mp")
public class MyPagePostTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPagePostTable() {
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
			sn.setTitle2("내 활동 관리");
			sn.setTitle2Addr("postlist.mp");
			sn.setTitle3("게시글 관리");
			sn.setActive1("1");
			sn.setActive2("active");
			sn.setActive3("1");
			
			request.setAttribute("sn", sn);
			
			int userNo = (((Member)request.getSession().getAttribute("loginUser")).getUserNo());

			ArrayList<Post> list = new AdminService().selectPostList(userNo);

			System.out.println(list);

			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/admin/myPagePostTable.jsp").forward(request, response);
			
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
