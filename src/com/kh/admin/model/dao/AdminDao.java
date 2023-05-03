package com.kh.admin.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.Reply;
import com.kh.menu.model.vo.Menu;
import com.kh.post.model.dao.PostDao;
import com.kh.post.model.vo.Post;
import com.kh.qna.model.vo.Qna;
import com.kh.store.model.vo.Store;

public class AdminDao {

    private Properties prop = new Properties();
	
	public AdminDao() {
		String fileName = PostDao.class.getResource("/sql/admin/admin-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Post> selectAdminPostList(Connection conn) {
		
        ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdminPostList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Post po = new Post();

                po.setPostNo(rset.getInt("POST_NO"));
                po.setPostTitle(rset.getString("POST_TITLE"));
                po.setPostContent(rset.getString("POST_CONTENT"));
                po.setPostView(rset.getInt("POST_VIEW"));
                po.setPostDate(rset.getDate("POST_DATE"));
				
				list.add(po);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Qna> selectQnaList(Connection conn) {
	
        ArrayList<Qna> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectQnaList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                Qna q = new Qna();
                
                q.setAskNo(rset.getInt("ASK_NO"));
                q.setAskType(rset.getInt("ASK_TYPE"));
                q.setAskTitle(rset.getString("ASK_TITLE"));
                q.setAskContent(rset.getString("ASK_CONTENT"));
                q.setAskDate(rset.getDate("ASK_DATE"));
                q.setAnswerContent(rset.getString("ANSWER_CONTENT"));
                q.setAnswerDate(rset.getDate("ANSWER_DATE"));
                q.setMemberNo(rset.getInt("MEMBER_NO"));
                
                list.add(q);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }	
        return list;
	}

	public ArrayList<Store> selectStoreList(Connection conn) {
		
        ArrayList<Store> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectStoreList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
            	Store q = new Store();

                q.setStoreNo(rset.getInt("STORE_NO"));
                q.setStoreName(rset.getString("STORE_NAME"));
                q.setStoreAddress(rset.getString("STORE_ADDRESS"));
                q.setStorePhone(rset.getString("STORE_PHONE"));
                q.setStoreTime(rset.getString("STORE_TIME"));
                q.setBrandName(rset.getString("BRAND_NAME"));
                
                list.add(q);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }	
        return list;
	}

	public ArrayList<Post> selectPostList(Connection conn, int userNo) {
		
        ArrayList<Post> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectPostList");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                Post po = new Post();

                po.setPostNo(rset.getInt("POST_NO"));
                po.setPostTitle(rset.getString("POST_TITLE"));
                po.setPostContent(rset.getString("POST_CONTENT"));
                po.setPostView(rset.getInt("POST_VIEW"));
                po.setPostDate(rset.getDate("POST_DATE"));
                
                list.add(po);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }	
        return list;
	}

	public ArrayList<Reply> selectReplyList(Connection conn, int userNo) {
		
        ArrayList<Reply> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectReplyList");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                Reply re = new Reply();

                re.setReplyNo(rset.getInt("REPLY_NO"));
                re.setReplyContent(rset.getString("REPLY_CONTENT"));
                re.setCreateDate(rset.getString("CREATE_DATE"));
                re.setStatus(rset.getString("STATUS"));
                re.setPostNo(rset.getInt("POST_NO"));
                re.setMemberNo(rset.getString("MEMBER_NO"));
                
                list.add(re);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }	
        return list;
	}

	public ArrayList<Menu> selectMenuList(Connection conn) {
		
        ArrayList<Menu> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectMenuList");

        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                Menu me = new Menu();
  
                me.setMenuNo(rset.getInt("MENU_NO"));
                me.setMenuName(rset.getString("MENU_NAME"));
                me.setMenuPrice(rset.getInt("MENU_PRICE"));
                me.setMenuCategory(rset.getString("MENU_CATEGORY"));
                me.setMenuDesc(rset.getString("MENU_DESC"));
                me.setBrandName(rset.getString("BRAND_NAME"));
                
                list.add(me);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }	
        return list;
	}

    
}
