package com.kh.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.store.model.service.StoreService;

/**
 * Servlet implementation class StoreDeleteController
 */
@WebServlet("/delete.st")
public class StoreDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int storeNo = Integer.parseInt(request.getParameter("sno"));
			
			// 매장 정보 번호를 넘기면서 삭제 요청 후 결과 받기
			int result = new StoreService().deleteStore(storeNo);
			
			// 결과에 따른 응답뷰 지정
			if(result > 0) { // 성공 => 
				
				request.getSession().setAttribute("alertMsg", "성공적으로 매장정보가 삭제되었습니다.");
				
				response.sendRedirect(request.getContextPath() + "/store.ad");
				
			} else { // 실패 => 에러페이지로 포워딩
				
				request.setAttribute("errorMsg", "매장정보 삭제 실패");
				
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
