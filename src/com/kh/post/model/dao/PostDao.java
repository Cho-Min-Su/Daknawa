package com.kh.post.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;
import com.kh.common.model.vo.Reply;
import com.kh.post.model.vo.Category;
import com.kh.post.model.vo.Post;

public class PostDao {

    private Properties prop = new Properties();
	
	public PostDao() {
		String fileName = PostDao.class.getResource("/sql/post/post-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectReviewListCount(Connection conn) {
		
        int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset =  null;
		String sql = prop.getProperty("selectReviewListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public ArrayList<Post> selectReviewList(Connection conn, PageInfo pi) {
		
        ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
		int endRow = startRow + pi.getPostLimit() - 1;
		
		// System.out.println(startRow);
		// System.out.println(endRow);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Post po = new Post();

                po.setPostNo(rset.getInt("POST_NO"));
                po.setPostTitle(rset.getString("POST_TITLE"));
                po.setPostContent(rset.getString("POST_CONTENT"));
                po.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
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
	
	public ArrayList<Post> selectPostList(Connection conn, PageInfo pi ,int Category) {
		
        ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
		int endRow = startRow + pi.getPostLimit() - 1;
		
		// System.out.println(startRow);
		// System.out.println(endRow);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Post po = new Post();

                po.setPostNo(rset.getInt("POST_NO"));
                po.setPostTitle(rset.getString("POST_TITLE"));
                po.setPostContent(rset.getString("POST_CONTENT"));
                po.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
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
	
	public Post selectPost(Connection conn, int postNo, int category) {
		
		Post p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			pstmt.setInt(2, category);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Post();
				
				p.setPostNo(rset.getInt("POST_NO"));
				p.setPostTitle(rset.getString("POST_TITLE"));
				p.setPostContent(rset.getString("POST_CONTENT"));
				p.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
				p.setPostView(rset.getInt("POST_VIEW"));
				p.setPostDate(rset.getDate("POST_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}

    public int increaseCount(Connection conn, int postNum) {
        
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("increaseCount");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postNum);
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

	public Post selectPost(Connection conn, int postNo) {
		
		Post p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Post();
				
				p.setPostNo(rset.getInt("POST_NO"));
				p.setPostTitle(rset.getString("POST_TITLE"));
				p.setPostContent(rset.getString("POST_CONTENT"));
				p.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
				p.setPostView(rset.getInt("POST_VIEW"));
				p.setPostDate(rset.getDate("POST_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}
	
	public Post selectPost2(Connection conn, int postNo) {
			
			Post p = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectPost");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, postNo);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					p = new Post();
					
					p.setPostNo(rset.getInt("POST_NO"));
					p.setPostTitle(rset.getString("POST_TITLE"));
					p.setPostContent(rset.getString("POST_CONTENT"));
					p.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
					p.setPostView(rset.getInt("POST_VIEW"));
					p.setPostDate(rset.getDate("POST_DATE"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return p;
		}


	public Attachment selectAttachment(Connection conn, int postNo) {
		
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment();
				
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFileDate(rset.getDate("FILE_DATE"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setFileLevel(rset.getInt("FILE_LEVEL"));

				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return at;
	}

	public ArrayList<Attachment> selectAttachmentList(Connection conn, int boardNo) {
		
		ArrayList<Attachment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		// 일반게시판 상세조회 요청 시 썼던 쿼리문 재활용
		try {
				pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();

			list = new ArrayList<>();

			while(rset.next()) {

				Attachment at = new Attachment();

				// 만약 게시글 수정 시 파일도 같이 변경하고 싶다면 FILE_NO 을 가져오는 것이 좋음
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				//=> 단순히 이미지만 노출시키고 말 경우에는 원본 파일명까진 필요 없음!!

				list.add(at);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertPost(Connection conn, Post p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, p.getPostCatNo());
			pstmt.setString(2, p.getPostTitle());
			pstmt.setString(3, p.getPostContent());
			pstmt.setInt(4, p.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public int insertAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deletePost(Connection conn, int postNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deletePost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updatePost(Connection conn, Post p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPostTitle());
			pstmt.setString(2, p.getPostContent());
			pstmt.setInt(3, p.getPostNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getFileNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertNewAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, at.getPostNo());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertReply(Connection conn, Reply r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql); 	
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getPostNo());
			pstmt.setInt(3, Integer.parseInt(r.getMemberNo()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Reply> selectReplyList(Connection conn, int postNo) {
		
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyList");

		// System.out.println("댓글dao : " + postNo);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reply r = new Reply();
				
				r.setReplyNo(rset.getInt("REPLY_NO"));
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setMemberNo(rset.getString("MEMBER_NICKNAME"));
				r.setCreateDate(rset.getString("CREATE_DATE"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	
	
	
	
	
//	public Attachment selectAttachment(Connection conn, int postNo) {
//		
//		Attachment at = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String sql = prop.getProperty("selectAttachment");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, postNo);
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				at = new Attachment();
//				
//				at.setFileNo(rset.getInt("FILE_NO"));
//				at.setOriginName(rset.getString("ORIGIN_NAME"));
//				at.setChangeName(rset.getString("CHANGE_NAME"));
//				at.setFilePath(rset.getString("FILE_PATH"));
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
//		}
//		return at; 
//	}

// --------------------------------------------------------------
// 현우님 코드--------------------------------------------------

	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				listCount = rset.getInt("COUNT");
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Post> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		int startRow = (pi.getCurrentPage() -1) * pi.getPostLimit() + 1;
		int endRow = startRow + pi.getPostLimit() - 1;
		
		System.out.println(startRow);
		System.out.println(endRow);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Post p = new Post();
				
				p.setPostNo(rset.getInt("POST_NO"));
				p.setPostTitle(rset.getString("POST_TITLE"));
				p.setPostContent(rset.getString("POST_CONTENT"));
                p.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
                p.setPostView(rset.getInt("POST_VIEW"));
                p.setPostDate(rset.getDate("POST_DATE"));

                list.add(p);
             
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int updateReply(Connection conn, int rno, String content) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, content);
			pstmt.setInt(2, rno);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
		
	
	public int deleteReply(Connection conn, int rno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Category> selectCategoryList(Connection conn) {
		
		ArrayList<Category> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Category(rset.getInt("POST_CAT_NO")
									, rset.getString("CATEGORY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return list;
		
		
	}
	
	
public ArrayList<Post> selectNoticeList(Connection conn, PageInfo pi) {
		
		ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		int startRow = (pi.getCurrentPage() -1) * pi.getPostLimit() + 1;
		int endRow = startRow + pi.getPostLimit() - 1;
		
		System.out.println(startRow);
		System.out.println(endRow);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Post p = new Post();
				
				p.setPostNo(rset.getInt("POST_NO"));
				p.setPostTitle(rset.getString("POST_TITLE"));
				p.setPostContent(rset.getString("POST_CONTENT"));
                p.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
                p.setPostView(rset.getInt("POST_VIEW"));
                p.setPostDate(rset.getDate("POST_DATE"));

                list.add(p);
             
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int selectNoticeListCount(Connection conn) {
	
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				listCount = rset.getInt("COUNT");
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
	}
	
	public Post selectNoticePost(Connection conn, int postNo) {
		
		Post p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticePost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Post();
				
				p.setPostNo(rset.getInt("POST_NO"));
				p.setPostTitle(rset.getString("POST_TITLE"));
				p.setPostContent(rset.getString("POST_CONTENT"));
				p.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
				p.setPostView(rset.getInt("POST_VIEW"));
				p.setPostDate(rset.getDate("POST_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}
	
	public int updateNoticePost(Connection conn, Post p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNoticePost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPostTitle());
			pstmt.setString(2, p.getPostContent());
			pstmt.setInt(3, p.getPostNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
