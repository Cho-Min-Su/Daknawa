package com.kh.post.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;
import com.kh.common.model.vo.Reply;
import com.kh.post.model.dao.PostDao;
import com.kh.post.model.vo.Category;
import com.kh.post.model.vo.Post;

public class PostService {
	
	

	public int selectReviewListCount() {
        
        Connection conn = getConnection();
        
        int result = new PostDao().selectReviewListCount(conn);
        
        close(conn);
        
        
        
        return result;
	}
	
	public ArrayList<Post> selectReviewList(PageInfo pi) {
		
        Connection conn = getConnection();
        
        ArrayList<Post> list = new PostDao().selectReviewList(conn, pi);
        
        close(conn);
        
        return list;
	}
	
	public ArrayList<Post> selectPostList(PageInfo pi, int category) {
		
        Connection conn = getConnection();
        
        ArrayList<Post> list = new PostDao().selectPostList(conn, pi, category);
        
        close(conn);
        
        return list;
	}

	public int increaseCount(int postNum) {
		
        Connection conn = getConnection();
        
        try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
        int result = new PostDao().increaseCount(conn, postNum);
        
        if(result > 0) {
        	commit(conn);
        	
        	
        } else {
        	rollback(conn);
        }
        
        close(conn);
        
        return result;
	}

	public Post selectPost(int postNo) {
		
		Connection conn = getConnection();
		
		Post p = new PostDao().selectPost(conn, postNo);
		
		close(conn);
		
		return p;
	}

	public Post selectPost2(int postNo) {
		
		Connection conn = getConnection();
		
		Post p = new PostDao().selectPost2(conn, postNo);
		
		close(conn);
		
		return p;
	}



	public ArrayList<Attachment> selectAttachmentList(int PostNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new PostDao().selectAttachmentList(conn, PostNo);
		
		close(conn);
		
		return list;
	}

	public int insertPost(Post p, Attachment at) {
		
		Connection conn = getConnection();
		
		int result1 = new PostDao().insertPost(conn, p);
		
		int result2 = 1;

		if(at != null) {
			result2 = new PostDao().insertAttachment(conn, at);
			
	        }
		

		if(result1 > 0 && result2 > 0) {
			commit(conn);
			
		} else {
			rollback(conn);
		}

		close(conn);

		return result1 * result2;
	}

	public Attachment selectAttachment(int postNo) {
		
		Connection conn = getConnection();
		
		Attachment at = new PostDao().selectAttachment(conn, postNo);
		
		close(conn);
		
		return at;
	}

	public int deletePost(int postNo) {
		
		Connection conn = getConnection();
		
		int result = new PostDao().deletePost(conn, postNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updatePost(Post p, Attachment at) {
		
		Connection conn = getConnection();
		
		int result1 = new PostDao().updatePost(conn, p);
		
		System.out.println(result1);
		
		int result2 = 1;
		
		// 새롭게 첨부된 파일이 있을 경우 
		if(at != null) {
			if(at.getFileNo() != 0) {
				// case1. ATTACHMENT UPDATE => fileNo 필드값
				result2 = new PostDao().updateAttachment(conn, at);
			}else {
				// case2. ATTACHMENT INSERT => refBno 필드값
				result2 = new PostDao().insertNewAttachment(conn, at);
			}
			
			System.out.println(result2);
			
			if(result1 > 0 && result2 > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		 } else {
			if(result1 > 0 && result2 > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
		 }
			
		close(conn);
		
		return result1 * result2;
	}

	public int insertReply(Reply r) {
		
		Connection conn = getConnection();
		
		int result = new PostDao().insertReply(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Reply> selectReplyList(int postNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new PostDao().selectReplyList(conn, postNo);
		
		close(conn);
		
		return list;
	}

//	public ArrayList<Attachment> selectReviewFileList() {
//		
//		Connection conn = getConnection();
//		
//		ArrayList<Attachment> list = new PostDao().selectAttachmentList(conn);
//		
//		close(conn);
//		
//		return list;
//	}

// --------------------------------------------------------------
// 현우님 코드--------------------------------------------------

	public int selectListCount() {
		
		Connection conn = getConnection(); 
		
				
		int listCount = new PostDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Post> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Post> list = new PostDao().selectList(conn, pi);
		
		
		close(conn);
		
		return list;
	}
	

	public int updateReply(int rno, String content) {
		
		Connection conn = getConnection();
		
		int result = new PostDao().updateReply(conn, rno, content);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public int deleteReply(int rno) {
		
		Connection conn = getConnection();
		
		int result = new PostDao().deleteReply(conn, rno);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<Category> selectCategoryList() {
		
		Connection conn = getConnection();
		
		ArrayList<Category> list = new PostDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
		
	}
	
	
	public ArrayList<Post> selectNoticeList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Post> list = new PostDao().selectNoticeList(conn, pi);
		
		
		close(conn);
		
		return list;
	}
	
	public int selectNoticeListCount() {
		
		Connection conn = getConnection(); 
		
				
		int listCount = new PostDao().selectNoticeListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public Post selectNoticePost(int postNo) {
		
			Connection conn = getConnection();
			
			Post p = new PostDao().selectNoticePost(conn, postNo);
			
			close(conn);
			
			return p;
		}

	public int updateNoticePost(Post p, Attachment at) {
	
		Connection conn = getConnection();
		
		int result1 = new PostDao().updatePost(conn, p);
		
		System.out.println(result1);
		
		int result2 = 1;
		
		// 새롭게 첨부된 파일이 있을 경우 
		if(at != null) {
			if(at.getFileNo() != 0) {
				// case1. ATTACHMENT UPDATE => fileNo 필드값
				result2 = new PostDao().updateAttachment(conn, at);
			}else {
				// case2. ATTACHMENT INSERT => refBno 필드값
				result2 = new PostDao().insertNewAttachment(conn, at);
			}
			
			System.out.println(result2);
			
			if(result1 > 0 && result2 > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		 } else {
			if(result1 > 0 && result2 > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
		 }
			
		close(conn);
		
		return result1 * result2;
	}


	
}
