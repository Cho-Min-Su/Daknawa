package com.kh.store.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.store.model.service.StoreService;
import com.kh.store.model.vo.Store;

/**
 * Servlet implementation class StoreKeywordListController
 */
@WebServlet("/list.st")
public class StoreListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreListController() {
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
		int postLimit; // 한 페이지에 보여질 게시글의 최대 갯수

		int maxPage; // 가장 마지막 페이지 (총 페이지 수)
		int startPage; // 페이징바의 시작수
		int endPage; // 페이징바의 끝수
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		int storeNo = Integer.parseInt(request.getParameter("nno"));
		
		// 검색 전달값을 뽑아서 변수에 기록
		String brandName = request.getParameter("bname");
		String keyword = request.getParameter("keyword");
		
		if(brandName == null) {
			brandName = "";
		}
		
		if(keyword == null) {
			keyword = "";
		}
		
		
		System.out.println("브랜드값 받기 : " + brandName);
		System.out.println("키워드값 받기 : " + keyword);
		
		// * listCount : 총 게시글 갯수 (삭제된 게시글은 제외하고 카운트)
		listCount = new StoreService().selectStoreListCount(brandName, keyword);
		
		System.out.println("브랜드 키워드 값 받기 : " + listCount);
		
		pageLimit = 10;
		
		postLimit = 8;
		
		maxPage = (int)Math.ceil((double)listCount /postLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		Store s = new Store();
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,
				                    postLimit, maxPage, startPage, endPage);
		
		ArrayList<Store> list = new StoreService().selectStoreList(pi, s, brandName , keyword);
		
		
		// System.out.println(pi);
		System.out.println(list);
		
		request.setAttribute("bname", brandName);
		request.setAttribute("keyword", keyword);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/store/StoreListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
