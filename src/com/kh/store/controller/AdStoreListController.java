package com.kh.store.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.common.model.vo.SubNav;
import com.kh.store.model.service.StoreService;
import com.kh.store.model.vo.Store;

/**
 * Servlet implementation class AdStoreListController
 */
@WebServlet("/adlist.st")
public class AdStoreListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdStoreListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int listCount; // 총 게시글 수
		int currentPage; // 사용자가 요청하는 현재 페이지
		int pageLimit; // 페이징바 최대 페이지 수
		int storeLimit; // 한 페이지에 보여질 게시글의 최대 갯수

		int maxPage; // 가장 마지막 페이지 (총 페이지 수)
		int startPage; // 페이징바의 시작수
		int endPage; // 페이징바의 끝수
		
		// 검색 전달값을 뽑아서 변수에 기록
		String brandName = request.getParameter("bname");
		String keyword = request.getParameter("keyword");
		
		if(brandName == null && keyword == null) {
			brandName = "";
			keyword = "";
		}
				
		// * listCount : 총 게시글 갯수 (삭제된 게시글은 제외하고 카운트)
		listCount = new StoreService().selectStoreListCount(brandName, keyword);
		
		// * currentPage : 현재페이지 (즉, 사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage")); // "1" -> 1
		
		// * pageLimit : 페이지 하단에 보여질 페이징바의 페이지 최대 갯수
		//				 (페이지 목록들을 몇개씩 보여지게 할거냐)
		pageLimit = 10;
		
		// * storeLimit : 한 페이지에 보여질 게시글의 최대 갯수
		//				  (게시글을 몇개씩 보여지게 할거냐)
		
		storeLimit = 10;
		
		
		maxPage = (int)Math.ceil((double)listCount /storeLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		Store s = new Store();      // 왜 필요할까?
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,
				                    storeLimit, maxPage, startPage, endPage);
		
		ArrayList<Store> list = new StoreService().selectStoreList(pi, s, brandName , keyword);
		
		// 응답페이지에서 필요로 하는 데이터 먼저 담기
		// 실제 조회된 리스트 (list), 페이징바 (pi)
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);

		SubNav sn = new SubNav();
		
		sn.setTitle1("ADMIN PAGE");
		sn.setTitle1Addr("admin.me");
		sn.setTitle2("매장 관리");
		sn.setTitle2Addr("adlist.st");
		sn.setTitle3("전체 매장 조회");
		sn.setActive1("1");
		sn.setActive2("active");
		sn.setActive3("1");
		sn.setActive4("1");
		
		request.setAttribute("sn", sn);
		
		request.getRequestDispatcher("views/store/AdStoreList.jsp").forward(request, response);
		

	}
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
