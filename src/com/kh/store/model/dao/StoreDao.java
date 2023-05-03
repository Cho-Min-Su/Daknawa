package com.kh.store.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.close;

import com.kh.common.model.vo.PageInfo;
import com.kh.store.model.vo.Store;

public class StoreDao {

	private Properties prop = new Properties();

	public StoreDao() {

		String fileName = StoreDao.class.getResource("/sql/store/store-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Store selectStore(Connection conn, int storeNo) {

		// SELECT 문 => ResultSet (단일행 조회) => Notice 객체

		// 1. 필요한 변수들 먼저 셋팅
		Store s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 실행할 쿼리문
		String sql = prop.getProperty("selectStore");

		try {
			// 2. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3_1. 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, storeNo);

			// 3_2. 쿼리문 실행 후 결과 받기
			rset = pstmt.executeQuery();

			// 4. ResultSet 에 담긴 결과를 VO 로 가공하기
			if(rset.next()) {

				s = new Store();
				s.setStoreNo(rset.getInt("STORE_NO"));
				s.setStoreName(rset.getString("STORE_NAME"));
				s.setStoreAddress(rset.getString("STORE_ADDRESS"));
				s.setStorePhone(rset.getString("STORE_PHONE"));
				s.setStoreTime(rset.getString("STORE_TIME"));
				s.setBrandName(rset.getString("BRAND_NAME"));

			}

			// 이 시점 기준으로 조회가 되지 않았다면 null 이 들어가 있음

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 5. 자원 반납 (생성 순서의 역순)
			close(rset);
			close(pstmt);
		}

		// 6. 결과 반환
		return s;
	}

	public int insertStore(Connection conn, Store s) {

		// INSERT 문 => int (처리된 행의 갯수)

		// 1. 필요한 변수들 먼저 셋팅
		int result = 0;
		PreparedStatement pstmt = null;

		// 실행할 쿼리문
		String sql = prop.getProperty("insertStore");

		try {
			// 2. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3_1. 미완성된 쿼리문 완성시키기
			pstmt.setString(1, s.getStoreName());
			pstmt.setString(2, s.getStoreAddress());
			pstmt.setString(3, s.getStorePhone());
			pstmt.setString(4, s.getStoreTime());
			pstmt.setString(5, s.getBrandName());

			// 3_2. 쿼리문 실행 후 결과 받기
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 자원 반납 (생성된 순서의 역순)
			close(pstmt);
		}

		// 5. 결과 반환
		return result;
	}

	public int updateStore(Connection conn, Store s) {

		// UPDATE 문 => int (처리된 행의 갯수)

		// 1. 필요한 변수 먼저 셋팅
		int result = 0;
		PreparedStatement pstmt = null;

		// 실행할 쿼리문
		String sql = prop.getProperty("updateStore");

		try {
			// 2. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3_1. 미완성된 쿼리문 완성시키기
			pstmt.setString(1, s.getStoreName());
			pstmt.setString(2, s.getStoreAddress());
			pstmt.setString(3, s.getStorePhone());
			pstmt.setString(4, s.getStoreTime());
			pstmt.setString(5, s.getBrandName());
			pstmt.setInt(6, s.getStoreNo());

			// 3_2. 쿼리문 실행 후 결과 받기
			result = pstmt.executeUpdate();

			System.out.println("result : " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 자원 반납 (생성 순서의 역순)
			close(pstmt);
		}

		// 5. 결과 반환
		return result;
	}

	// 매장정보 삭제용 서비스

	public int deleteStore(Connection conn, int storeNo) {

		// UPDATE 문 => int (처리된 행의 갯수)

		// 1. 필요한 변수들 먼저 셋팅
		int result = 0;
		PreparedStatement pstmt = null;

		// 실행할 쿼리문
		String sql = prop.getProperty("deleteStore");

		try {
			// 2. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3_1. 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, storeNo);

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

	public int insertBrand(Connection conn, String brandName) {
	
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertBrand");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, brandName);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 자원 반납 (생성된 순서의 역순)
			close(pstmt);
		}

		// 5. 결과 반환
		return result;
	}

	public int countBrand(Connection conn, String brandName) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("countBrand");

		try {
	
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, brandName);

			rset = pstmt.executeQuery();
			if(rset.next()) {
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

	public int selectStoreListCount(Connection conn, String brandName, String keyword) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectStoreListCount");

		try {
	
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + brandName + "%");
			pstmt.setString(2, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
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

	public ArrayList<Store> selectStoreList(Connection conn, PageInfo pi, Store s, String brandName , String keyword) {

		// SELECT 문 => ResultSet (여러 행) => ArrayList<Board> 

		// 1. 필요한 변수들 먼저 셋팅
		ArrayList<Store> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 실행할 쿼리문
		String sql = prop.getProperty("selectStoreList");

		try {
			// 2. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3_1. 미완성된 쿼리문 완성시키기

			/*
			 * PageLimit 가 10 이라는 가정 하에
			 * 
			 * currentPage = 1 => 시작값 1, 끝값 10
			 * currentPage = 2 => 시작값 11, 끝값 20
			 * currentPage = 3 => 시작값 21, 끝값 30
			 * currentPage = 4 => 시작값 31, 끝값 40
			 * ...
			 * 
			 * 시작값 = (currentPage - 1) * PageLimit + 1
			 * 끝값 = 시작값 + PageLimit - 1
			 */
			int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
			int endRow = startRow + pi.getPostLimit() - 1;
			
			pstmt.setString(1, "%" + brandName + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);

			System.out.println(startRow);
			System.out.println(endRow);

			// 3_2. 쿼리문 실행 후 결과 받기
			rset = pstmt.executeQuery();

			// 4. 조회된 결과를 VO 로 가공
			while(rset.next()) {

				list.add(new Store(rset.getInt("STORE_NO")
						, rset.getString("STORE_NAME")
						, rset.getString("STORE_ADDRESS")
						, rset.getString("STORE_PHONE")
						, rset.getString("STORE_TIME")
						, rset.getString("BRAND_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 5. 자원 반납 (생성 순서의 역순)
			close(rset);
			close(pstmt);
		}

		// 6. 결과 반환
		return list;
	}
}










