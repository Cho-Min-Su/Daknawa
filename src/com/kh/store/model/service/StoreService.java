package com.kh.store.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.store.model.dao.StoreDao;
import com.kh.store.model.vo.Store;

public class StoreService {

	// 매장정보 상세조회용 서비스
	public Store selectStore(int storeNo) {

		// 1. Connection 객체 생성
		Connection conn = getConnection();

		// 2. 로 만들어진 Connection 과 전달값을 넘기면서 요청 후 결과 받기
		Store s = new StoreDao().selectStore(conn, storeNo);

		// 3. 트랜잭션 처리 => 패스 (SELECT 문)

		// 4. Connection 객체 반납
		close(conn);

		// 5. 결과 반환
		return s;
	}

	// 매장 추가 작성용 서비스
	public int insertStore(Store s) {

		// 1. Connection 객체 생성
		Connection conn = getConnection();

		// 2. Dao 로 만들어진 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		int result = new StoreDao().insertStore(conn, s);

		// 3. 트랜잭션 처리
		if(result > 0) { // 성공
			commit(conn);
		} else { // 실패
			rollback(conn);
		}

		// 4. Connection 객체 반납
		close(conn);

		// 5. 결과 반환
		return result;
	}


	// 매장 정보 수정용 서비스
	public int updateStore(Store s) {

		// 1. Connection 객체 생성
		Connection conn = getConnection();

		// 2.  로 만들어진 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		int result = new StoreDao().updateStore(conn, s);

		// 3. 트랜잭션 처리
		if(result > 0) { // 성공
			commit(conn);
		} else { // 실패
			rollback(conn);
		}

		// 4. Connection 객체 반납
		close(conn);

		// 5. 결과 반환
		return result;
	}

	// 매장정보 삭제용 서비스
	public int deleteStore(int storeNo) {

		// 1. Connection 생성
		Connection conn = getConnection();

		// 2. Dao 로 Connection 과 전달값을 넘기면서 요청 후 결과 받기
		int result = new StoreDao().deleteStore(conn, storeNo);

		// 3. 트랜잭션 처리
		if(result > 0) { 
			commit(conn);
		} else {
			rollback(conn);
		}

		// 4. Connection 반납
		close(conn);

		// 5. 결과 반환
		return result;
	}

	// 브랜드 추가 작성용 서비스
	public int countBrand(String brandName) {

		// 1. Connection 객체 생성
		Connection conn = getConnection();

		// 2. Dao 로 만들어진 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		int result = new StoreDao().countBrand(conn, brandName);

		close(conn);

		// 5. 결과 반환
		return result;
	}

	public int insertBrand(String brandName) {
		
		// 1. Connection 객체 생성
		Connection conn = getConnection();

		// 2. Dao 로 만들어진 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		int result = new StoreDao().insertBrand(conn, brandName);

		// 3. 트랜잭션 처리
		if(result > 0) { // 성공
			commit(conn);
		} else { // 실패
			rollback(conn);
		}

		// 4. Connection 객체 반납
		close(conn);

		// 5. 결과 반환
		return result;
	}
	
		// 총 매장 갯수를 구하는 서비스
		public int selectStoreListCount(String brandName, String keyword) {
	
			// 1. Connection 객체 생성
			Connection conn = getConnection();
	
			// 2. Dao 로 만들어진 Connection 과 전달값을 넘기면서 요청 후 결과 받기
			int listCount = new StoreDao().selectStoreListCount(conn, brandName, keyword);
	
			// 3. 트랜잭션 처리 => SELECT 문 이므로 패스
	
			// 4. Connection 객체 반납
			close(conn);
	
			// 5. 결과 반환
			return listCount;
		}

		public ArrayList<Store> selectStoreList(PageInfo pi, Store s, String brandName , String keyword) {

			// 1. Connection 객체 생성
			Connection conn = getConnection();

			// 2. Dao 로 만들어진 Connection 과 전달값을 넘기면서 요청 후 결과 받기
			ArrayList<Store> list = new StoreDao().selectStoreList(conn, pi, s, brandName, keyword);

			// 3. 트랜잭션 처리 => SELECT 문 패스

			// 4. Connection 반납
			close(conn);

			// 5. 결과 반환
			return list;
		}

	}

