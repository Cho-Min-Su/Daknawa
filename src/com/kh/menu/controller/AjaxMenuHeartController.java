package com.kh.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.menu.model.service.MenuService;

/**
 * Servlet implementation class AjaxMenuHeartController
 */
@WebServlet("/heart.mn")
public class AjaxMenuHeartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMenuHeartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(); // 세션 객체 가져오기
		 Member m = ((Member)request.getSession().getAttribute("loginUser"));
		 if (m == null) { // 로그인 여부 확인
	         response.setContentType("text/html; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>alert('로그인 후 이용해주세요.'); location.href='login.jsp';</script>");
	         out.flush();
	         out.close();
	         return;
		 }
	         
	     int mbno = m.getUserNo(); // 회원번호
		 int mno = Integer.parseInt(request.getParameter("menuNo")); // 멤버번호
		 String type = request.getParameter("type"); // 타입
		 
		 int result = new MenuService().heart(mbno, mno, type); // like / unlike 진행
		
		if(result > 0) { // 성공
			response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print("{\"success\": true}");
	        out.flush();
	        out.close();
		} else { // 실패
			response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print("{\"success\": false}");
	        out.flush();
	        out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
