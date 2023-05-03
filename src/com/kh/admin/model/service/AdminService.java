package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminDao;
import com.kh.common.model.vo.Reply;
import com.kh.menu.model.vo.Menu;
import com.kh.post.model.vo.Post;
import com.kh.qna.model.vo.Qna;
import com.kh.store.model.vo.Store;

public class AdminService {

	public ArrayList<Post> selectAdminPostList() {
		
		Connection conn = getConnection();
        
        ArrayList<Post> list = new AdminDao().selectAdminPostList(conn);
        
        close(conn);
        
        return list;
	}

	public ArrayList<Qna> selectQnaList() {
		
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new AdminDao().selectQnaList(conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Store> selectStoreList() {
		
		Connection conn = getConnection();
		
		ArrayList<Store> list = new AdminDao().selectStoreList(conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Post> selectPostList(int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Post> list = new AdminDao().selectPostList(conn, userNo);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Reply> selectReplyList(int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new AdminDao().selectReplyList(conn, userNo);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Menu> selectMenuList() {
		
		Connection conn = getConnection();

		ArrayList<Menu> list = new AdminDao().selectMenuList(conn);

		close(conn);

		return list;
	}

}
