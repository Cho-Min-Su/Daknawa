package com.kh.menu.model.service;

import static com.kh.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;
import com.kh.menu.model.dao.MenuDao;
import com.kh.menu.model.vo.Menu;

public class MenuService {

    public ArrayList<Menu> selectList() {
        // 1. 드라이버 등록
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        ArrayList<Menu> list = new MenuDao().selectList(conn);

        // 3. 트랜잭션 처리
        close(conn);

        return list;
    }
    
    public ArrayList selectDeList(int mno) {
        // 1. 드라이버 등록
        Connection conn = getConnection();

        // 2. dao 메소드 호출
         ArrayList<Menu> list = new MenuDao().selectDeList(conn, mno);

         close(conn);

        return list;
    }

    public int increaseCount(int mno) {
        // 1. 드라이버 등록
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        int result = new MenuDao().increaseCount(conn, mno);

        // 3. 트랜잭션 처리
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        close(conn);

        return result;
    }

    public ArrayList<Attachment> selectImgDeList(int mno) {
        // 1. 드라이버 등록
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        ArrayList<Attachment> list = new MenuDao().selectImgDeList(conn, mno);

        // 3. 트랜잭션 처리
        close(conn);

        return list;
    }

    public int selectListCount() {
        // 1. 드라이버 등록
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        int listCount = new MenuDao().selectListCount(conn);

        // 3. 트랜잭션 처리
        close(conn);

        return listCount;
    }
    
    public int selectListCount(String type) {
        // 1. 드라이버 등록
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        int listCount = new MenuDao().selectListCount(conn, type);

        // 3. 트랜잭션 처리
        close(conn);

        return listCount;
    }
      
        public ArrayList<Attachment> selectImgPageList(PageInfo pi) {
        
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        ArrayList<Attachment> list = new MenuDao().selectImgPageList(conn, pi);

        // 3. 트랜잭션 처리
        close(conn);

        return list;
    }

        public ArrayList<Menu> selectPageList(PageInfo pi) {
        // 1. 드라이버 등록
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        ArrayList<Menu> list = new MenuDao().selectPageList(conn, pi);

        // 3. 트랜잭션 처리
        close(conn);

        return list;
    }

        public ArrayList<Attachment> selectImgPageChList(PageInfo pi, String type) {
        
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        ArrayList<Attachment> list = new MenuDao().selectImgPageChList(conn, pi, type);

        // 3. 트랜잭션 처리
        close(conn);

        return list;
    }
    
        public ArrayList<Menu> selectPageChList(PageInfo pi, String type) {
            // 1. 드라이버 등록
            Connection conn = getConnection();

            // 2. dao 메소드 호출
            ArrayList<Menu> list = new MenuDao().selectPageChList(conn, pi, type);

            // 3. 트랜잭션 처리
            close(conn);

            return list;
        }

        public int insertMenu(Menu m, Attachment at){
            Connection conn = getConnection();
            
        int result1 = new MenuDao().insertMenu(conn, m);

        // result 에는 1또는 0이 들어있음

        // 2_2. result 가 1이면 (게시글이 정상적으로 등록되었다면)

        //      => Attachment INSERT 진행

        //      => result 에 Attachment INSERT 결과를 대입

        // 미리 선언과 초기화 진행
        int result2 = 1;
        // 첨부파일이 없는 경우 BOARD INSERT가 아무리 성공했음에도
        // result2가 0이면 실패로 간주되기 때문에 ROLLBACK이 발생함
        // 따라서 result2의 초기값을 1로 설정해주어야 함

        if(at != null) {
            // 첨부파일이 있을 경우에만 Dao로 요청 후 결과 받기
            result2 = new MenuDao().insertAttachment(conn, at);

        }

        // 3. 트랜잭션 처리
        // => 모든 DML이 성공 이여야지만 COMMIT
        // (즉, 하나라도 실패하는 순간 바로 ROLLBACK)
        if(result1 > 0 && result2 > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }

        // 4. 자원반납 => Connection 객체는 Service에서 생성했으므로 Service에서 반납
        close(conn);

        // 5. 결과 반환
        return result1 * result2;
        // => 혹시라도 하나라도 실패하여 0이 될 경우
        // 아예 실패값을 반환하기 위해 곱셈 결과를 리턴
    }

    public int deleteMenu(int mno) {
        Connection conn = getConnection();
        
        int result = new MenuDao().deleteMenu(conn, mno);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        
        close(conn);
        
        return result;
    }

    public Menu selectMenu(int mno) {
        Connection conn = getConnection();
        
        Menu m = new MenuDao().selectMenu(conn, mno);
        
        close(conn);
        
        return m;
    }

    public Attachment selectAttachment(int mno) {
        Connection conn = getConnection();
        
        Attachment at = new MenuDao().selectAttachment(conn, mno);
        
        close(conn);
        
        return at;
    }

    public int updateMenu(Menu m, Attachment at) {
        Connection conn = getConnection();
        
        int result1 = new MenuDao().updateMenu(conn, m);
        
        int result2 = 1;
        
        if(at != null) {

            if(at.getFileNo() != 0) {
            	
            	result2 = new MenuDao().updateAttachment(conn, at);

            }else {

            	result2 = new MenuDao().insertNewAttachment(conn, at);
            }
        }
        
        if(result1 > 0 && result2 > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        
        close(conn);
        
        return result1 * result2;
    }
    
    
    public int selectSEListCount(String query) {
        // 1. 드라이버 등록
        Connection conn = getConnection();
        
        // 2. dao 메소드 호출
        int listCount = new MenuDao().selectSEListCount(conn, query);

        // 3. 트랜잭션 처리
        close(conn);

        return listCount;
    }
    
    
    public ArrayList<Menu> searchMenu(String query, PageInfo pi, String type){
       
        Connection conn = getConnection();
        ArrayList<Menu> list = null;
        
        if(type=="") { 
        	list = new MenuDao().searchMenu(conn, pi, query);
        }
        else {
        	list = new MenuDao().searchMenu(conn, pi, query, type);
        }
        
        close(conn);
        
        return list;
    }

        public int heart(int mno, int uno, String type) {
        Connection conn = getConnection();
        int result = 0;
        
        if("like".equals(type)) {
        	result = new MenuDao().insertHeart(conn, mno, uno);
        }
        else {
        	result = new MenuDao().heart(conn, mno, uno);
        }
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        
        close(conn);
        
        return result;
    }

    public int selectHeart(int mno, int uno) {
        Connection conn = getConnection();
        
        int result = new MenuDao().selectHeart(conn, mno, uno);
        
        close(conn);
        
        return result;
    }
    
    public int heartCount(int mno) {
Connection conn = getConnection();
        
        int result = new MenuDao().heartCount(conn, mno);
        
        close(conn);
        
        return result;
    }
}
