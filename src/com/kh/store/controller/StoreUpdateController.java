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
 * Servlet implementation class StoreUpdateController
 */
@WebServlet("/update.st")
public class StoreUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 인코딩 설정 (POST)
		request.setCharacterEncoding("UTF-8");
		
		// 1. 요청시 전달값을 뽑아서 변수에 기록
		int storeNo = Integer.parseInt(request.getParameter("sno"));
		String brandName = request.getParameter("bname");
		String storeName = request.getParameter("sname");
		String storeAddress = request.getParameter("address");
		String storePhone = request.getParameter("phone");
		String storeTime = request.getParameter("time");
		
		
		// 2. 전달값들을 VO로 가공
		Store s = new Store();
		s.setStoreNo(storeNo);
		s.setBrandName(brandName);
		s.setStoreName(storeName);
		s.setStoreAddress(storeAddress);
		s.setStorePhone(storePhone);
		s.setStoreTime(storeTime);
		
		System.out.println("받아옴 : " + s);
		
		// 3. Service 로 전달값을 넘기면서 요청 후 결과 받기
		int result = new StoreService().updateStore(s);
		
		// 4. 전달값에 따라서 응답페이지 지정
		if(result > 0) { // 성공 => 해당 게시글의 상세조회 페이지로 url 재요청
			
			request.getSession().setAttribute("alertMsg", "매장정보가 성공적으로 수정되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/store.ad");
			
		} else { // 실패 => 에러페이지 포워딩
			
			request.setAttribute("errorMsg", "매장 정보 수정 실패");
			
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
