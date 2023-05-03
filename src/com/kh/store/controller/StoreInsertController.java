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
 * Servlet implementation class StoreInsertController
 */
@WebServlet("/insert.st")
public class StoreInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			// 0. 인코딩 설정 (POST 방식)
			request.setCharacterEncoding("UTF-8");
			
			// 1. 요청시 전달값을 뽑아서 변수에 기록
			String brandName = request.getParameter("bname");
			String storeName = request.getParameter("sname");
			String storeAddress = request.getParameter("address");
			String storePhone = request.getParameter("phone");
			String storeTime = request.getParameter("time");
			
			
			
			// 2. 전달값들을 VO로 가공
			Store s = new Store();
			s.setBrandName(brandName);
			s.setStoreName(storeName);
			s.setStoreAddress(storeAddress);
			s.setStorePhone(storePhone);
			s.setStoreTime(storeTime);
			
			int countBrand = new StoreService().countBrand(brandName);
			
			System.out.println("브랜드 갯수 : " + countBrand);
			
			if(countBrand == 0) {
				int reusult2 = new StoreService().insertBrand(brandName);
				
				System.out.println("브랜드명 추가" + reusult2);
			}
			
			int result = new StoreService().insertStore(s);

			System.out.println("입력 :ㅣ " + s);
			
			// 3. Service 로 전달값을 넘기면서 요청 후 결과 받기
			
			// 4. 결과에 따른 응답페이지 지정
			if(result > 0) { // 성공
				
				request.getSession().setAttribute("alertMsg", "성공적으로 매장이 등록되었습니다.");
				response.sendRedirect(request.getContextPath() + "/store.ad");
				
			} else { // 실패 => 에러페이지 응답
				
				request.setAttribute("errorMsg", "매장 등록 실패");
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
