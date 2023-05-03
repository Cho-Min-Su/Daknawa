package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login.me")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// 추가적으로 아이디 저장 기능을 위한 saveId 체크 여부를 골라내기
		String saveId = request.getParameter("saveId");
		
		// 체크를 했을 경우 실행할 코드 작성
		if(saveId != null && saveId.equals("Y")) {

			/*
			 * * Cookie
			 * 서버로부터 사용자의 브라우저에 저장하려고 하는 정보들 (데이터들)
			 * 개발자도구를 통해 데이터가 노출될 수 있고 쉽게 위변조 될 수 있음
			 * 주로 보안과 관련 없는 기능을 구현할 때 사용한다.
			 * 
			 * * 쿠키 생성
			 * - 쿠키는 객체를 생성한 다음 응답정보에 첨부해야 완전히 생성된다.
			 * - 쿠키 생성 시 name, value 는 필수이다. (name : 키값, value : 밸류값)
			 * - expires (만료시간) 을 지정할 수 있고, 필수속성은 아니다.
			 * - name, value 가 모두 문자열이여야만 한다.
			 * - 당연하게도 name 이 중복되면 덮어씌워진다.
			 * 
			 * [ 표현법 ]
			 * Cookie cookie = new Cookie("키값", "밸류값"); // 쿠키 객체 생성 구문
			 * cookie.setMaxAge(초단위만료시간); // 만료시간 지정
			 * response.addCookie(cookie); // 응답정보에 첨부
			 */
			
			Cookie cookie = new Cookie("saveId", userId);
			cookie.setMaxAge(1 * 24 * 60 * 60); // 만료기간 생성일로부터 1일 (초단위)
			response.addCookie(cookie);
		} else { // 아이디 저장 X
			
			Cookie cookie = new Cookie("saveId", userId);
			// 기존의 savaId 키밸류가 있었다면 덮어씌워짐
			cookie.setMaxAge(0);
			// 만료시간이 0초로 셋팅됨
			response.addCookie(cookie);		
		}
			
		// 2. VO 객체로 가공 (Member)
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		// System.out.println(m);
		
		// 3. 해당 요청을 처리하는 서비스 클래스의 어떤 메소드를 호출해서 요청 후 결과 받기
		Member loginUser = new MemberService().loginMember(m);
		
		
		
		if(loginUser == null) { // 로그인 실패 => 에러페이지 응답
			
			request.getSession().setAttribute("alertMsg", "로그인에 실패했습니다. 아이디와 비밀번호를 다시한번 확인해주세요.");
			
			request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);
			
		} else {
			
			int userPoint = loginUser.getUserPoint();
			
			String gradeName = new MemberService().selectGradeName(userPoint);
			
			loginUser.setGradeName(gradeName);
			
			request.getSession().setAttribute("loginUser", loginUser);
			
			request.getSession().setAttribute("alertMsg", "환영합니다! 닭나와에 오신 걸 환영합니다.");
			
			response.sendRedirect(request.getContextPath());
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
