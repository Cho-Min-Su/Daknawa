package com.kh.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.store.model.service.StoreService;
import com.kh.store.model.vo.Store;

/**
 * Servlet implementation class StoreUpdateFormController
 */
@WebServlet("/updateForm.st")
public class StoreUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// 글번호 뽑기
			int storeNo = Integer.parseInt(request.getParameter("sno")); // "3" -> 3
			
			// 수정페이지에서 기존의 게시글 내용이 노출되야 하므로
			// => 상세보기 기능에서 만들어 뒀었던 selectStore 서비스를 그대로 재활용하기
			Store s = new StoreService().selectStore(storeNo);
			
			// System.out.println("storeNo : " + s);
			// 글번호, 브랜드명, 매장명, 매장주소, 매장전화번호, 영업시간
			
			request.setAttribute("s", s);
			
//			System.out.println(s);
			
			// 수정페이지 포워딩
			request.getRequestDispatcher("views/store/StoreUpdateForm.jsp").forward(request, response);
			
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
