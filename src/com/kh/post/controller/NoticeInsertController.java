package com.kh.post.controller;

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
import com.kh.post.model.service.PostService;
import com.kh.post.model.vo.Post;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/ninsert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
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
			
			String savePath = request.getSession().getServletContext().getRealPath("resources/post_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int MemberNickname = 1;
			String postTitle = multiRequest.getParameter("title");
			String postContent = multiRequest.getParameter("content");
			
			
			Post p = new Post();
			p.setPostCatNo(1);
			p.setMemberNo(MemberNickname);
			p.setPostTitle(postTitle);
			p.setPostContent(postContent);
			
			Attachment at = null;
			
				if(multiRequest.getOriginalFileName("upfile") != null ) {
					
					at = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName("upfile"));
					at.setChangeName(multiRequest.getFilesystemName("upfile"));
					at.setFilePath("resources/post_upfiles/");
				}
				
				int result = new PostService().insertPost(p, at);
				
				if(result > 0) {
					request.getSession().setAttribute("alert", "게시글 등록 성공!");
					response.sendRedirect(request.getContextPath() + "/nlist.no?currentPage=1");
				} else {
					if(at != null) {
						new File(savePath + at.getChangeName()).delete();
					}
					request.setAttribute("alert", "게시글 등록 실패");
					request.getRequestDispatcher("views/post/noticeEnrollForm.jsp").forward(request, response);
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
