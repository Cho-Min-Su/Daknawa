package com.kh.menu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;
import com.kh.menu.model.service.MenuService;
import com.kh.menu.model.vo.Menu;

/**
 * Servlet implementation class MenuListController
 */
@WebServlet("/menu.mn")
public class MenuListController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public MenuListController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    int listCount; // 현재 총 게시글의 갯수
    int currentPage; // 현재 페이지 (즉, 사용자가 요청하는 페이지)
    int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 페이지 갯수
    int PostLimit; // 한 페이지에 보여질 게시글의 최대 객수 (몇개 단위씩 끊어서 볼거냐)

    int maxPage; // 가장 마지막 페이지가 몇번째페이지인지 (즉, 총 페이지 수)
    int startPage; // 페이징 하단에 보여질 페이징바의 시작수
    int endPage; // 페이징 하단에 보여질 페이징바의 끝수

    // * listCount : 총 게시글의 갯수
    listCount = new MenuService().selectListCount();
    // 만약 currentPage=1 이거를 생략하면 무조건 그냥 1 페이지가 보여지고싶은경우에는
    String tmp = request.getParameter("currentPage"); // 키값이 없으면 null
    
    if(tmp == null) {
    	currentPage = 1;
    } else {
    	currentPage = Integer.parseInt(tmp);
    }

    //System.out.println(listCount);

    // * pageLimit : 페이지 하단에 보여질 페이징바의 페이지 최대 갯수
    //               (페이지 목록들을 몇개씩 보여지게 할거냐)
    pageLimit = 10;

    // * boardLimit : 한 페이지에 보여질 게시글 최대 갯수
    //                (한 페이지에 몇개의 게시글을 보여줄거냐)

    PostLimit = 8;

    // * maxPage : 가장 마지막 페이지가 몇번째 페이지인지 (총 페이지 수)
    /*
     listCount, boardLimit에 영향을 받음

     - 공식 구하기
      단, boardLimit가 10이라는 가정 하에 구해보자

      게시글의 총 갯수   boardLimit    maxPage
      100               10            10
      101               10            11
      105               10            11
      110               10            11
      111               10            12
      115               10            12
      120               10            12
      121               10            13
      121.0             10            13
      => 나눗셈 연산한 결과를 올림처리 해버리면 maxPage 값이 나온다.

		 * 1) listCount 를 double 로 형변환
		 * 2) boardLimit 를 double 로 형변환
		 * 3) 결과에 올림처리 Math.ceil() 메소드 호출
		 * 4) 결과값을 int 로 형변환
		 *
		 * (double)listCount / boardLimit
		 */

    maxPage = (int) Math.ceil((double) listCount / PostLimit);
    // System.out.println(maxPage);

    // * startPage : 페이지 하단에 보여질 페이징바의 시작수
    /*
        pageLimit, currentPage에 영향을 받음

    - 공식 구하기
      단, pageLimit가 10이라는 가정 하에 구해보자

      pageLimit가 10일 경우
      startPage : 1, 11, 21, 31, ...
      => m * 10 + 1 (즉, 10의 배수 + 1)

      pageLimit가 5일 경우
      startPage : 1, 6, 11, 16, ...
      => m * 5 + 1 (즉, 5의 배수 + 1)

      pageLimit가 3일 경우
      startPage : 1, 4, 7, 10, ...
      => m * 3 + 1 (즉, 3의 배수 + 1)

      즉, startPage는 m * pageLimit + 1 이다.

      pageLimit가 10일 경우

      currentPage   startPage
      1             1           => 0 * pageLimit + 1
      5             1           => 0 * pageLimit + 1
      10            1           => 0 * pageLimit + 1
      11            11          => 1 * pageLimit + 1
      15            11          => 1 * pageLimit + 1
      20            11          => 1 * pageLimit + 1
      21            21          => 2 * pageLimit + 1
      25            21          => 2 * pageLimit + 1

      => 1 ~ 10 : n = 0
      => 11 ~ 20 : n = 1
      => 21 ~ 30 : n = 2
      => 31 ~ 40 : n = 3
      n = 1 ~ 10 / pageLimit

      공식 합체하기
      startPage = n * pageLimit + 1
                = (currentPage - 1) / pageLimit * pageLimit + 1
  */

    startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
    // * endPage : 페이지 하단에 보여질 페이징바의 끝수

    // * engPage : startPage + pageLimit - 1
    endPage = startPage + pageLimit - 1;

    // 만약 startPage가 51이여서 endPage가 60인데
    // 이 상황에서 애초에 maxPage가 56이였다면?
    // endPage를 maxPage로 바꿔줘야 한다.
    if (endPage > maxPage) {
      endPage = maxPage;
    }

    // 페이지 정보들을 하나의 VO 객체로 담아서 보내자
    // => 페이지 정보들을 담을 VO 객체를 정의
    // (공지사항, 일반게시판 등에서 공통적으로 쓰일 수 있기에 common 패키지에 정의)
    PageInfo pi = new PageInfo(
      listCount,
      currentPage,
      pageLimit,
      PostLimit,
      maxPage,
      startPage,
      endPage
    );

    ArrayList<Menu> list = new MenuService().selectPageList(pi);
	ArrayList<Attachment> ilist = new MenuService().selectImgPageList(pi);
	

    request.setAttribute("list", list);
    request.setAttribute("ilist", ilist);
    request.setAttribute("pi", pi);

    request
      .getRequestDispatcher("views/menu/menuListView.jsp")
      .forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
