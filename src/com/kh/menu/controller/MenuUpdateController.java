package com.kh.menu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.model.vo.Attachment;
import com.kh.menu.model.service.MenuService;
import com.kh.menu.model.vo.Menu;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MenuUpdateController
 */
@WebServlet("/update.mn")
public class MenuUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/menu_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			int mno = Integer.parseInt(multiRequest.getParameter("mno"));
			String menuName = multiRequest.getParameter("name");
			int menuPrice = Integer.parseInt(multiRequest.getParameter("price"));
			String menuCategory = multiRequest.getParameter("category");
			int menuBrand = Integer.parseInt(multiRequest.getParameter("brand"));
			String menuDesc = multiRequest.getParameter("desc");

			Menu m = new Menu();
			m.setMenuNo(mno);
			m.setMenuName(menuName);
			m.setMenuPrice(menuPrice);
			m.setMenuCategory(menuCategory);
			m.setBrandNo(menuBrand);
			m.setMenuDesc(menuDesc);

			Attachment at = null;
			
			// 넘어온 첨부파일이 있다면 그제서야 객체 생성하기
			if(multiRequest.getOriginalFileName("reupfile") != null) {
				
				at = new Attachment();
				
				// 경우의 수에 따라 필드값을 셋팅
				// ATTACHMENT UPDATE => originName, changeName, filePath, fileNo 필요
				// ATTACHMENT INSERT => originName, changeName, filePath, refNo 필요
				
				// 일단 공통적으로 필요한 필드값 먼저 담기
				at.setOriginName(multiRequest.getOriginalFileName("reupfile"));
				at.setChangeName(multiRequest.getFilesystemName("reupfile"));
				at.setFilePath("resources/menu_upfiles/");
				
				// case1. 기존 첨부파일이 있을 경우
				// => 기존 첨부파일의 파일번호, 수정명을 hidden 으로 넘겼었음!!
				if(multiRequest.getParameter("originFileNo") != null) {
					
					// 새로운 첨부파일이 있고, 기존의 파일이 있었을 경우
					// => ATTACHMENT UPDATE
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					
					// 기존의 첨부파일은 서버로부터 삭제
					new File(savePath + multiRequest.getParameter("originFileName")).delete();
				} else {
					
					// case2. 기존 첨부파일이 없을 경우
					// => ATTACHMENT INSERT
					at.setMenuNo(mno);
				}
			}

			int result = new MenuService().updateMenu(m, at);

			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "메뉴 수정에 성공하였습니다.");
				response.sendRedirect(request.getContextPath() + "/menu.ad");
			} else {
				request.setAttribute("errorMsg", "메뉴 수정에 실패하였습니다.");
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
