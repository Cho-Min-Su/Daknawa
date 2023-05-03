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
import com.kh.post.model.vo.Post;

/**
 * Servlet implementation class AdminTable
 */
@WebServlet("/table.ad")
public class AdminTableXXX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTableXXX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SubNav sn = new SubNav();
		
		sn.setTitle1("ADMIN PAGE");
		sn.setTitle1Addr("admin.me");
		sn.setTitle2("메뉴 관리");
		sn.setTitle2Addr("menu.ad");
		sn.setTitle3("게시글 관리??");
		sn.setActive1("1");
		sn.setActive2("1");
		sn.setActive3("active");
		sn.setActive4("1");
		
		request.setAttribute("sn", sn);

		ArrayList<Post> list = new AdminService().selectAdminPostList();

		System.out.println(list);

		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/admin/adminTable.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
