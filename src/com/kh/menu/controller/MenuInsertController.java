package com.kh.menu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.common.model.vo.Attachment;
import com.kh.menu.model.service.MenuService;
import com.kh.menu.model.vo.Menu;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MenuInsertController
 */
@WebServlet("/insert.mn")
public class MenuInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 인코딩 설정 (Post 방식)
		request.setCharacterEncoding("UTF-8");
		
		// 1. 요청 시 전달값들을 뽑아서 변수에 기록
		
		
//		String userNo = request.getParameter("userNo");
//		String category = request.getParameter("category");
//		String boardTitle = request.getParameter("title");
//		String boardContent = request.getParameter("content");
//		String upfile = request.getParameter("upfile");
		
		/*
		System.out.println(userNo);
		System.out.println(category);
		System.out.println(boardTitle);
		System.out.println(boardContent);
		System.out.println(upfile);
		*/
		
		// 1. form 태그에 enctype 속성 부여 전
		// 요청 시 전달값으로 파일을 넘길려고 했으나 파일명만 문자열로 딸랑 넘어옴!!
		// => 기능이 제대로 동작하려면파일 실물이 필요함
		
		// 2. form 태그에 enctype 속성 부여 후
		// 제대로된 키값으로 밸류를 뽑았으나 죄다 null 로 나옴 (즉, 제대로 뽑히지 않음)
		// => enctype="multipart/form-data" 방식으로 요청을 전달하는 경우에는
		// 	 request 로부터 값 뽑기가 불가함
		
		// 폼 전송을 일반 방식이 아니라 multipart/form-data 로 전송하는 경우
		// HttpServletRequest 로 부터 값 뽑기 불가
		// 이 경우 MultipartRequest 라는 객체에 값을 이관시켜서 다뤄야 한다.
		
		// 1) enctype 이 multipart/form-data 로 잘 전송되었는지부터 검사하기
		// [ 표현법 ]
		// ServletFileUpload.isMultipartContent(request)
		// => multipart/form-data 형식의 요청이라면 true 반환 / 아니라면 false
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// System.out.println("잘 실행되나?");
			
			// 2) HttpServletRequest 타입을 MultipartRequest 타입으로 변환시키기
			
			// 1. 전송되는 파일을 처리할 작업 내용지정
			// (전송되는 파일의 용량 제한, 전달된 파일을 저장할 폴더 경로)
			
			// 1_1. 전송파일 용량 제한 (반드시 byte 단위의 값을 기술해야 함)
			// => 1Mbyte 로 제한
			// 단위정리
			// byte -> kbyte -> mbyte -> gbyte -> tbyte -> ...
			// 1kbyte == 1024byte (2의 10승)
			// 1mbyte == 1024byte == 1024kbyte == 1024 * 1024byte (2의 20승)
			int maxSize = 10 * 1024 * 1024; // byte 단위
			
			// 1_2. 전달된 파일을 저장할 서버의 실제 폴더 경로를 지정 (문자열로 지정함)
			// => 세션객체에서 제공하는 getServletContext 메소드를 통해
			// 	 application scope 내장객체를 생성
			String savePath = request.getSession().getServletContext().getRealPath("/resources/menu_upfiles/");
			// 다만 WebContent 폴더로부터 board_upfiles 폴더까지의 경로를 지정함
			// 추가적으로 board_upfiles 라는 폴더 "안쪽에" 파일을 저장해야 하기 때문에
			// 제일 마지막에 / 를 한번 더 붙여줌!!
			
			// System.out.println(maxSize);
			// System.out.println(savePath);
			
			// 2. 전달된 파일명 수정 및 서버에 업로드 작업
			// => HttpServletRequest -> MultipartRequest
			// [ 표현법 ]
			// MultipartRequest multiRequest = new MultipartRequest(request객체, 저장할파일경로, 용량제한, 인코딩값, 파일명을수저시켜주는객체);
			// => 위 구문 한줄 실행만으로 넘어온 첨부파일들이 해당 폴더에 무조건 업로드됨!!
			
			// 그리고 사용자가 올린 파일명은 그대로 서버에 업로드 하지않는게 일반적임
			// => 왠만해선 같은 파일명이 있을 경우를 대비해서 파일명을 수정해서 업로드함!!
			// (파일이 덮어씌워질 수 있고, 혹여나 파일명에 한글, 특수문자, 띄어쓰기가 포함될 경우도 대비해야 하기 때문)
			
			// 단, 이 기능을 이용하려면 외부 라이브러리를 끌어다 써야 함
			// => cos.jar (com.oreilly.servlet 의 약자)
			// 다운로드 링크 : http://www.servlets.com
			
			/*
			 * cos.jar 에서 제공하는 기본적으로 파일명 수정 작업을 해주는 객체
			 * - DefaultFileRenamePolicy 객체
			 * => 객체 생성 시 내부적으로 rename() 이라는 메소드가 실행되면서 파일명 수정이 진행됨
			 * 	 기본적으로 동일한 파일명이 있다면 뒤에 카운팅된 숫자를 붙여서 파일명 수정을 진행함
			 * 	 예) aaa.jpg, aaa1.jpg, aaa2.jpg, ...
			 * - 하지만 우리 입맛대로 절대 파일명이 안겹치게끔 rename 해볼것임
			 * (DefaultfileRenamePolicy 객체 사용 X)
			 * => 나만의 com.kh.common.MyFileRenamePolicy 클래스를 만들어서 rename 메소드 정의
			 */
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());

			// 3. 요청 시 전달값 뽑기 (multiRequest 로부터 뽑아야함)
			// MultipartRequest 로부터 값 뽑기
			// 표현법
			// multiRequest.getParameter("키값") : String 벨류값

			// 순수 게시글에 대한 정보만 먼저 뽑기
			String menuName = multiRequest.getParameter("name");
			int menuPrice = Integer.parseInt(multiRequest.getParameter("price"));
			String menuCategory = multiRequest.getParameter("category");
			int menuBrand = Integer.parseInt(multiRequest.getParameter("brand"));
			String menuDesc = multiRequest.getParameter("desc");

			Menu m = new Menu();
			m.setMenuName(menuName);
			m.setMenuPrice(menuPrice);
			m.setMenuCategory(menuCategory);
			m.setBrandNo(menuBrand);
			m.setMenuDesc(menuDesc);

			//  Board가 먼저 1번 insert 되고 나서 Attachment도 한번 insert 되야함
			// Board는 무조건 1번 insert가 되야함
			// 하지만 Attachment는 넘어온 첨부파일이 있다면 insert 되야함
			// 근데 넘어온 첨부파일이 없다면 insert 되면 안됨

			// 일단은 null로 초기화만 진행
			Attachment at = new Attachment();
					String key = "file";
					
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/menu_upfiles/");

			// 첨부파일이 있다면 그때 객체 생성
			// => 원본명, 수정명, 폴더경로를 뽑아서 필드에 담아두기


			// 우선 넘어온 첨부파일이 있는지 확인
			// 표현법
			// multiRequest.getOriginalFileName("키값") : String 원본명 (첨부파일이 없다면 null)
			// => 첨부파일이 없을 경우에는 null을 리턴
			if(multiRequest.getOriginalFileName("upfile") != null) {
				// 넘어온 첨부파일이 있을 경우
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile")); // 원본 파일명
				at.setChangeName(multiRequest.getFilesystemName("upfile")); // 수정 파일명
				at.setFilePath("resources/menu_upfiles/"); // 파일 저장 경로

				// multipartRequest.getFilesystemName("키값") : String 수정명
				
			}

			// 이 시점 기준으로
			// 사용자가 첨부파일을 올렸다면 at에는 파일 정보가 잘 담겨있을 것
			// 사용자가 첨부파일을 올리지 않았다면 at는 null일 것임
			// 추가적으로 첨부파일이 있든 없든 간에 이 시점 기준으로
			// b에는 게시글 정보가 담겨있을 것임

			// 4. 서비스 요청 (b, at)
			int result = new MenuService().insertMenu(m, at);

			// 5. 결과에 따른 응답페이지 지정
			if(result > 0) {
				// 게시글 등록 성공
				// => 게시글 목록 페이지로 이동
				request.getSession().setAttribute("alertMsg", "게시글 등록 성공!");
				response.sendRedirect(request.getContextPath() + "/menu.ad");
			} else {
				request.setAttribute("errorMsg", "게시글 등록 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
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
