package com.kh.menu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.model.vo.Attachment;
import com.kh.member.model.vo.Member;
import com.kh.menu.model.service.MenuService;
import com.kh.menu.model.vo.Menu;

/**
 * Servlet implementation class MenuDetailController
 */
@WebServlet("/list.mn")
public class MenuDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int mno = Integer.parseInt(request.getParameter("mno"));
		Member loginUser = (Member)session.getAttribute("loginUser");
		if (loginUser == null) {
		    // 로그인하지 않은 사용자일 경우 처리할 내용 작성
		    // 예를 들어, 로그인 화면으로 이동하는 등의 처리가 가능합니다.
		} else {
			int mbno = loginUser.getUserNo();
			int heart = new MenuService().selectHeart(mbno, mno);
			if(heart > 0) {
				request.setAttribute("heart", heart);
			}
		}
		  
		int love = new MenuService().heartCount(mno);
		int result = new MenuService().increaseCount(mno);
	    ArrayList<Menu> list = new MenuService().selectDeList(mno);
		ArrayList<Attachment> ilist = new MenuService().selectImgDeList(mno);
		if (love > 0) request.setAttribute("love", love);
	    request.setAttribute("list", list);
		request.setAttribute("ilist", ilist);

	    request
	      .getRequestDispatcher("views/menu/menuDetailView.jsp")
	      .forward(request, response);
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
