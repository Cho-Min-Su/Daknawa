package com.kh.menu.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;
import com.kh.menu.model.vo.Menu;

public class MenuDao {

	private Properties prop = new Properties();

	public MenuDao() {
		String fileName = MenuDao.class.getResource("/sql/menu/menu-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int increaseCount(Connection conn, int mno) {

		int result = 0;
		PreparedStatement pstmt = null;

		// 실행할 쿼리문
		String sql = prop.getProperty("increaseCount");

		try {
			// 2. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3_1. 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, mno);

			// 3_2. 쿼리문 실행 후 결과 받기
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 자원 반납
			close(pstmt);
		}

		// 5. 결과 반환
		return result;
	}

	public ArrayList<Menu> selectList(Connection conn) {
		ArrayList<Menu> list = new ArrayList<Menu>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectList");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Menu(rset.getInt("MENU_NO"), rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"),
						rset.getString("MENU_CATEGORY"), rset.getInt("BRAND_NO"), rset.getString("MENU_DESC")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList selectDeList(Connection conn, int mno) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Menu> list = new ArrayList<Menu>();

		// 실행할 쿼리문
		String sql = prop.getProperty("selectDeList");

		try {
			// 2. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3_1. 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, mno);
			pstmt.setInt(2, mno);

			// 3_2. 쿼리문 실행 후 결과 받기
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Menu(rset.getInt("MENU_NO"), rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"),
		                   rset.getString("MENU_CATEGORY"), rset.getInt("BRAND_NO"), rset.getString("MENU_DESC"),
		                   rset.getInt("MENU_VIEW"), rset.getString("BRAND_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 자원 반납
			close(rset);
			close(pstmt);
		}
		
		// 5. 결과 반환
		return list;
	}

	public ArrayList<Attachment> selectImgDeList(Connection conn, int mno) {

		ArrayList<Attachment> list = new ArrayList<Attachment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectImgDeList");

		try {
			// 2. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3_1. 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, mno);
			pstmt.setInt(2, mno);
			pstmt.setInt(3, mno);
			pstmt.setInt(4, mno);

			// 3_2. 쿼리문 실행 후 결과 받기
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Attachment(rset.getInt("FILE_NO"), rset.getString("ORIGIN_NAME"),
						rset.getString("CHANGE_NAME"), rset.getString("FILE_PATH"), rset.getInt("MENU_NO")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 자원 반납
			close(rset);
			close(pstmt);
		}

		// 5. 결과 반환
		return list;
	}

	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectListCount");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public int selectListCount(Connection conn, String type) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, type);
			
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}
	
	

	public ArrayList<Menu> selectPageList(Connection conn, PageInfo pi) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Menu> list = new ArrayList<Menu>();

		// 실행할 쿼리문
		String sql = prop.getProperty("selectPageList");

		try { // 2. PreparedStatement 객체 생성

			pstmt = conn.prepareStatement(sql);

			// 3_1 미완성된 쿼리문을 완성시키기 => 완성된 쿼리문이기 때문에 패스

			/*
			 * boardLimit가 10이라는 가정하에 currentPage = 1 => 시작값 1, 끝값 10 currentPage = 2 => 시작값
			 * 11, 끝값 20 currentPage = 3 => 시작값 21, 끝값 30 currentPage = 4 => 시작값 31, 끝값 40
			 * ...
			 * 
			 * 시작값 = (currentPage - 1) * boardLimit + 1 끝값 = 시작값 + boardLimit - 1
			 */

			int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
			int endRow = startRow + pi.getPostLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			// 3_2 실행할 쿼리문을 실행하고 결과를 받아옴
			rset = pstmt.executeQuery();

			// 4. ResultSet 객체에서 값을 꺼내서 변수에 저장
			while (rset.next()) {
				list.add(new Menu(rset.getInt("MENU_NO"), rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"),
						rset.getString("MENU_CATEGORY"), rset.getInt("BRAND_NO"), rset.getString("MENU_DESC")
						, rset.getString("BRAND_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원 반납
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Attachment> selectImgPageList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = new ArrayList<Attachment>();

		String sql = prop.getProperty("selectImgPageList");

		try {

			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
			int endRow = startRow + pi.getPostLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Attachment(rset.getInt("FILE_NO"), rset.getString("ORIGIN_NAME"),
						rset.getString("CHANGE_NAME"), rset.getString("FILE_PATH"), rset.getInt("MENU_NO")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원 반납
			close(rset);
			close(pstmt);
		}
		return list;
	}

/////////////////////////////////////////////////////////////////////////////////////////////           

	public ArrayList<Menu> selectPageChList(Connection conn, PageInfo pi, String type) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Menu> list = new ArrayList<Menu>();
		String sql = prop.getProperty("selectPageChList");

		try { // 2. PreparedStatement 객체 생성

			pstmt = conn.prepareStatement(sql);

			// 3_1 미완성된 쿼리문을 완성시키기 => 완성된 쿼리문이기 때문에 패스

			/*
			 * boardLimit가 10이라는 가정하에 currentPage = 1 => 시작값 1, 끝값 10 currentPage = 2 => 시작값
			 * 11, 끝값 20 currentPage = 3 => 시작값 21, 끝값 30 currentPage = 4 => 시작값 31, 끝값 40
			 * ...
			 * 
			 * 시작값 = (currentPage - 1) * boardLimit + 1 끝값 = 시작값 + boardLimit - 1
			 */

			int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
			int endRow = startRow + pi.getPostLimit() - 1;

			pstmt.setString(1, type);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);

			// 3_2 실행할 쿼리문을 실행하고 결과를 받아옴
			rset = pstmt.executeQuery();

			// 4. ResultSet 객체에서 값을 꺼내서 변수에 저장
			while (rset.next()) {
				list.add(new Menu(rset.getInt("MENU_NO"), rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"),
						rset.getString("MENU_CATEGORY"), rset.getInt("BRAND_NO"), rset.getString("MENU_DESC")
						, rset.getString("BRAND_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원 반납
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Attachment> selectImgPageChList(Connection conn, PageInfo pi, String type) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		String sql = prop.getProperty("selectImgPageChList");
		
		try {

			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
			int endRow = startRow + pi.getPostLimit() - 1;
			
			pstmt.setString(1, type);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Attachment(rset.getInt("FILE_NO"), rset.getString("ORIGIN_NAME"),
						rset.getString("CHANGE_NAME"), rset.getString("FILE_PATH"), rset.getInt("MENU_NO")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원 반납
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public int insertMenu(Connection conn, Menu m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("insertMenu");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getMenuName());
			pstmt.setInt(2, m.getMenuPrice());
			pstmt.setString(3, m.getMenuCategory());
			pstmt.setInt(4, m.getBrandNo());
			pstmt.setString(5, m.getMenuDesc());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertAttachment(Connection conn, Attachment at) {
		PreparedStatement pstmt = null;
		int result = 0;

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
			close(pstmt);
		}

		return result;
	}

	public int deleteMenu(Connection conn, int menuNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("deleteMenu");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, menuNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Menu selectMenu(Connection conn, int menuNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Menu m = null;

		String sql = prop.getProperty("selectMenu");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, menuNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Menu(rset.getInt("MENU_NO"), rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"),
						rset.getString("MENU_CATEGORY"), rset.getInt("BRAND_NO"), rset.getString("MENU_DESC"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return m;
	}

	public Attachment selectAttachment(Connection conn, int menuNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Attachment at = null;

		String sql = prop.getProperty("selectAttachment");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, menuNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				at = new Attachment(rset.getInt("FILE_NO"), rset.getString("ORIGIN_NAME"),
						rset.getString("CHANGE_NAME"), rset.getString("FILE_PATH"), rset.getInt("MENU_NO"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return at;
	}

	public int updateMenu(Connection conn, Menu m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("updateMenu");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getMenuName());
			pstmt.setInt(2, m.getMenuPrice());
			pstmt.setString(3, m.getMenuCategory());
			pstmt.setInt(4, m.getBrandNo());
			pstmt.setString(5, m.getMenuDesc());
			pstmt.setInt(6, m.getMenuNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateAttachment(Connection conn, Attachment at) {
		PreparedStatement pstmt = null;
		int result = 0;

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
			close(pstmt);
		}

		return result;
	}

	public int insertNewAttachment(Connection conn, Attachment at) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("insertNewAttachment");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, at.getMenuNo());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	
	public int selectSEListCount(Connection conn, String query) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSEListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, query);
			
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	public ArrayList<Menu> searchMenu(Connection conn, PageInfo pi, String query) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Menu> list = new ArrayList<Menu>();

		String sql = prop.getProperty("searchMenu");

		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
			int endRow = startRow + pi.getPostLimit() - 1;

			pstmt.setString(1, query);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);


			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Menu(rset.getInt("MENU_NO"), rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"),
						rset.getString("MENU_CATEGORY"), rset.getInt("BRAND_NO"), rset.getString("MENU_DESC"),
						rset.getString("FILE_PATH"), rset.getString("BRAND_NAME")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	
	public ArrayList<Menu> searchMenu(Connection conn, PageInfo pi, String query, String type) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Menu> list = new ArrayList<Menu>();

		String sql = prop.getProperty("searchCMenu");

		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
			int endRow = startRow + pi.getPostLimit() - 1;

			pstmt.setString(1, query);
			pstmt.setString(2, type);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Menu(rset.getInt("MENU_NO"), rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"),
						rset.getString("MENU_CATEGORY"), rset.getInt("BRAND_NO"), rset.getString("MENU_DESC"),
						rset.getString("FILE_PATH"), rset.getString("BRAND_NAME")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	

	public int insertHeart(Connection conn, int menuNo, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("insertHeart");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, menuNo);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int heart(Connection conn, int menuNo, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("heart");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, menuNo);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectHeart(Connection conn, int menuNo, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String sql = prop.getProperty("selectHeart");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, menuNo);
			pstmt.setInt(2, userNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

public int heartCount(Connection conn, int menuNo) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	int result = 0;

	String sql = prop.getProperty("heartCount");

	try {
		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, menuNo);

		rset = pstmt.executeQuery();

		if (rset.next()) {
			result = rset.getInt("COUNT");
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}

	return result;
}

}
